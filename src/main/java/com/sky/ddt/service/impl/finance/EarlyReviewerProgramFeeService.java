package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.CouponConstant;
import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.dao.custom.CustomEarlyReviewerProgramFeeMapper;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dto.finance.request.EarlyReviewerProgramFeeImportRequest;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IEarlyReviewerProgramFeeService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.util.CheckUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.utilddt.ShopSkuUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author baixueping
 * @description 早评
 * @date 2019/12/5 19:00
 */
@Service
public class EarlyReviewerProgramFeeService implements IEarlyReviewerProgramFeeService {
    @Autowired
    CustomEarlyReviewerProgramFeeMapper customEarlyReviewerProgramFeeMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IFinanceService financeService;
    @Autowired
    CustomFinanceMapper customFinanceMapper;


    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 导入早评
     * @author baixueping
     * @date 2019/12/5 19:11
     */
    @Override
    public BaseResponse importEarlyReviewerProgramFee(ImportFinanceRequest params, Integer dealUserId) {
        BaseResponse<List<Map<String, String>>> listResponse = ExcelUtil.getListByExcel2(params.getFile());
        if (!listResponse.isSuccess()) {
            return listResponse;
        }
        List<Map<String, String>> list = listResponse.getData();
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历数据
        StringBuilder sbErro = new StringBuilder();
        List<EarlyReviewerProgramFeeImportRequest> importRequestList = new ArrayList<>();
        Integer shopId = null;
        Integer shopIdSkuRowNum = null;
        String shopIdSku = null;
        List<String> skuList = ShopSkuUtil.getList(list, "sku");
        List<ShopSku> shopSkuList = shopSkuService.getShopSkuListByShpSku(skuList);
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            EarlyReviewerProgramFeeImportRequest importRequest = new EarlyReviewerProgramFeeImportRequest();
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(CouponConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = ShopSkuUtil.getShopSkuByShopSku(map.get("sku"), shopSkuList);
                if (shopSku == null) {
                    sbErroItem.append(",").append(CouponConstant.SKU_NOT_EXIST);
                } else {
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                        shopIdSkuRowNum = i + 2;
                        shopIdSku = map.get("sku");
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(",").append("sku:" + map.get("sku") + "与第" + shopIdSkuRowNum + "行sku:" + shopIdSku + "的店铺不一致");
                    }
                    importRequest.setShopSkuId(shopSku.getShopSkuId());
                }
                importRequest.setSku(map.get("sku"));
            }
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "fee", "fee", true);
            importRequestList.add(importRequest);
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + map.get("rowNum") + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        if (shopId == null) {
            return BaseResponse.failMessage("没有有效的店铺，请完善数据后再导入");
        }
        BaseResponse<Finance> financeResponse = financeService.getOrCreateFinance(shopId, params.getMonthDate(), dealUserId);
        if (!financeResponse.isSuccess()) {
            return financeResponse;
        }
        Finance finance = financeResponse.getData();
        if (FinanceConstant.FinanceStatusEnum.LOCKED.getStatus().equals(finance.getStatus())) {
            return BaseResponse.failMessage(FinanceConstant.FINANCE_LOCKED_NOT_ALLOW_IMPORT);
        }
        if (Boolean.TRUE.equals(finance.getEarlyReviewerProgramFee())) {
            EarlyReviewerProgramFeeExample example = new EarlyReviewerProgramFeeExample();
            example.createCriteria().andFinanceIdEqualTo(finance.getId());
            customEarlyReviewerProgramFeeMapper.deleteByExample(example);
        }
        for (EarlyReviewerProgramFeeImportRequest importRequest : importRequestList) {
            EarlyReviewerProgramFee earlyReviewerProgramFee = new EarlyReviewerProgramFee();
            BeanUtils.copyProperties(importRequest, earlyReviewerProgramFee);
            earlyReviewerProgramFee.setCreateBy(dealUserId);
            earlyReviewerProgramFee.setCreateTime(new Date());
            earlyReviewerProgramFee.setFinanceId(finance.getId());
            customEarlyReviewerProgramFeeMapper.insert(earlyReviewerProgramFee);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setEarlyReviewerProgramFee(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
