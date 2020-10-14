package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.CouponConstant;
import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.dao.custom.CustomCouponMapper;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dto.finance.request.CouponImportRequest;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.RemoveOrdersImportRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.ICouponService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.util.CheckUtil;
import com.sky.ddt.util.ExcelUtil;
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
 * @description 优惠券
 * @date 2019/12/5 18:21
 */
@Service
public class CouponService implements ICouponService{
    @Autowired
    CustomCouponMapper customCouponMapper;
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
     * @description 导入优惠券
     * @author baixueping
     * @date 2019/12/5 18:32
     */
    @Override
    public BaseResponse importCoupon(ImportFinanceRequest params, Integer dealUserId) {
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
        List<CouponImportRequest> importRequestList=new ArrayList<>();
        Integer shopId = null;
        Integer shopIdSkuRowNum = null;
        String shopIdSku = null;
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            CouponImportRequest importRequest=new CouponImportRequest();
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(CouponConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("sku"));
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
            CheckUtil.checkAndSetBigDecimal(importRequest, sbErroItem, map, "fee", null, true);
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
        Finance finance=financeResponse.getData();
        if (FinanceConstant.FinanceStatusEnum.LOCKED.getStatus().equals(finance.getStatus())) {
            return BaseResponse.failMessage(FinanceConstant.FINANCE_LOCKED_NOT_ALLOW_IMPORT);
        }
        if (Boolean.TRUE.equals(finance.getCoupon())) {
            CouponExample example = new CouponExample();
            example.createCriteria().andFinanceIdEqualTo(finance.getId());
            customCouponMapper.deleteByExample(example);
        }
        for (CouponImportRequest importRequest : importRequestList) {
            Coupon coupon = new Coupon();
            BeanUtils.copyProperties(importRequest, coupon);
            coupon.setCreateBy(dealUserId);
            coupon.setCreateTime(new Date());
            coupon.setFinanceId(finance.getId());
            customCouponMapper.insert(coupon);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setCoupon(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
