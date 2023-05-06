package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.LongStorageFeeConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomLongStorageFeeMapper;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.LongStorageFeeImportRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.LongStorageFee;
import com.sky.ddt.entity.LongStorageFeeExample;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.ILongStorageFeeService;
import com.sky.ddt.util.CheckUtil;
import com.sky.ddt.util.DateUtil;
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
 * @description 长期仓储费
 * @date 2019/12/2 18:25
 */
@Service
public class LongStorageFeeService implements ILongStorageFeeService {
    @Autowired
    CustomLongStorageFeeMapper customLongStorageFeeMapper;
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
     * @description 导入长期仓储费
     * @author baixueping
     * @date 2019/12/2 18:36
     */
    @Override
    public BaseResponse importLongStorageFee(ImportFinanceRequest params, Integer dealUserId) {
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
        List<LongStorageFeeImportRequest> longStorageFeeImportRequestList = new ArrayList<>();
        Integer shopId = null;
        Integer shopIdSkuRowNum = null;
        String shopIdSku = null;
        List<String> skuList = ShopSkuUtil.getList(list, "sku");
        List<ShopSku> shopSkuList = shopSkuService.getShopSkuListByShopSku(skuList);
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            if (map.containsKey("isEmpty")) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            LongStorageFeeImportRequest longStorageFeeImportRequest=new LongStorageFeeImportRequest();
            if (StringUtils.isEmpty(map.get("snapshot-date"))) {
                sbErroItem.append(",").append(LongStorageFeeConstant.SNAPSHOT_DATE_EMPTY);
            }else{
                Date snapshotDate= DateUtil.UtcStrToDateTime(map.get("snapshot-date"));
                if(snapshotDate==null){
                    sbErroItem.append(",").append(LongStorageFeeConstant.SNAPSHOT_DATE_ERRO);
                }else{
                    longStorageFeeImportRequest.setSnapshotDate(snapshotDate);
                }
            }
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append(LongStorageFeeConstant.SKU_EMPTY);
            } else {
                ShopSku shopSku = ShopSkuUtil.getShopSkuByShopSku(map.get("sku"), shopSkuList);
                if (shopSku == null) {
                    sbErroItem.append(",").append(LongStorageFeeConstant.SKU_NOT_EXIST);
                } else {
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                        shopIdSkuRowNum = i + 2;
                        shopIdSku = map.get("sku");
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(",").append("sku:" + map.get("sku") + "与第" + shopIdSkuRowNum + "行sku:" + shopIdSku + "的店铺不一致");
                    }
                    longStorageFeeImportRequest.setShopSkuId(shopSku.getShopSkuId());
                }
                longStorageFeeImportRequest.setSku(map.get("sku"));
            }
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "fnsku", null, true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "asin", null, true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "product-name", null, true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "condition","conditionType", true);
            CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "per-unit-volume", null, true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "currency", null, true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "volume-unit", null, true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "country", null, true);


            //v2版本新增字段
            CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "qty-charged", "qtyCharged12MoLongTermStorageFee", true);
            CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "amount-charged","mo12LongTermsStorageFee", true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "surcharge-age-tier", null, true);
            CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "rate-surcharge", null, true);


            //V1老版本注释掉
            /*CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "qty-charged-long-time-range-long-term-storage-fee", "qtyCharged12MoLongTermStorageFee", true);
            CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "long-time-range-long-term-storage-fee","mo12LongTermsStorageFee", true);
            CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "qty-charged-short-time-range-long-term-storage-fee", "qtyCharged6MoLongTermStorageFee", true);
            CheckUtil.checkAndSetBigDecimal(longStorageFeeImportRequest, sbErroItem, map, "short-time-range-long-term-storage-fee","mo6LongTermsStorageFee", true);
            CheckUtil.checkAndSetStr(longStorageFeeImportRequest, sbErroItem, map, "enrolled-in-small-and-light", null, true);*/

            longStorageFeeImportRequestList.add(longStorageFeeImportRequest);
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
        if (Boolean.TRUE.equals(finance.getLongStorageFee())) {
            LongStorageFeeExample longStorageFeeExample = new LongStorageFeeExample();
            longStorageFeeExample.createCriteria().andFinanceIdEqualTo(finance.getId());
            customLongStorageFeeMapper.deleteByExample(longStorageFeeExample);
        }
        for (LongStorageFeeImportRequest longStorageFeeImportRequest : longStorageFeeImportRequestList) {
            LongStorageFee longStorageFee = new LongStorageFee();
            BeanUtils.copyProperties(longStorageFeeImportRequest, longStorageFee);
            longStorageFee.setCreateBy(dealUserId);
            longStorageFee.setCreateTime(new Date());
            longStorageFee.setFinanceId(finance.getId());
            customLongStorageFeeMapper.insert(longStorageFee);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setLongStorageFee(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
