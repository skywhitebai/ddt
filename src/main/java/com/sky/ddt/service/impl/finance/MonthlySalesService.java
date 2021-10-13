package com.sky.ddt.service.impl.finance;

import com.sky.ddt.common.constant.FinanceConstant;
import com.sky.ddt.common.constant.MonthlySalesConstant;
import com.sky.ddt.dao.custom.CustomFinanceMapper;
import com.sky.ddt.dao.custom.CustomMonthlySalesMapper;
import com.sky.ddt.dto.finance.request.ImportFinanceRequest;
import com.sky.ddt.dto.finance.request.MonthlySalesImportRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Finance;
import com.sky.ddt.entity.MonthlySales;
import com.sky.ddt.entity.MonthlySalesExample;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.finance.IFinanceService;
import com.sky.ddt.service.finance.IMonthlySalesService;
import com.sky.ddt.util.CheckUtil;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author baixueping
 * @description 月流水
 * @date 2019/11/27 14:24
 */
@Service
public class MonthlySalesService implements IMonthlySalesService {
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IFinanceService financeService;
    @Autowired
    CustomFinanceMapper customFinanceMapper;
    @Autowired
    CustomMonthlySalesMapper customMonthlySalesMapper;

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 导入月流水
     * @author baixueping
     * @date 2019/11/27 14:36
     */
    @Override
    public BaseResponse importMonthlySales(ImportFinanceRequest params, Integer dealUserId) {
        BaseResponse<List<Map<String, String>>> listResponse = ExcelUtil.getListByExcel(params.getFile(), null, "date/time");
        if (!listResponse.isSuccess()) {
            return listResponse;
        }
        List<Map<String, String>> list = listResponse.getData();
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历数据
        StringBuilder sbErro = new StringBuilder();
        List<MonthlySalesImportRequest> monthlySalesImportRequestList = new ArrayList<>();
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
            MonthlySalesImportRequest monthlySalesImportRequest = new MonthlySalesImportRequest();
            if (StringUtils.isEmpty(map.get("date/time"))) {
                sbErroItem.append(",").append(MonthlySalesConstant.DATE_TIME_EMPTY);
            } else {
                Date dateTime = DateUtil.EnglishStrToDateTime(map.get("date/time").replace("PDT", ""));
                if (dateTime == null) {
                    sbErroItem.append(",").append(MonthlySalesConstant.DATE_TIME_ERRO);
                } else {
                    monthlySalesImportRequest.setDateTime(dateTime);
                }
            }
            if (!StringUtils.isEmpty(map.get("settlement id"))) {
                Long settlementId = MathUtil.strToLong(map.get("settlement id"));
                if (settlementId == null) {
                    sbErroItem.append(",").append(MonthlySalesConstant.SETTLEMENT_ID_ERRO);
                } else {
                    monthlySalesImportRequest.setSettlementId(settlementId);
                }
            }
            monthlySalesImportRequest.setType(map.get("type"));
            monthlySalesImportRequest.setOrderId(map.get("order id"));
            String sku = map.get("sku");
            if (!StringUtils.isEmpty(sku)) {
                ShopSku shopSku = null;
                if (sku.startsWith("X") && sku.length() == 10) {
                    shopSku = shopSkuService.getShopSkuByFnsku(sku);
                    if (shopSku == null) {
                        shopSku = shopSkuService.getShopSkuByShopSku(sku);
                    }
                } else {
                    shopSku = shopSkuService.getShopSkuByShopSku(sku);
                }
                if (shopSku == null) {
                    sbErroItem.append(",").append(MonthlySalesConstant.SKU_NOT_EXIST);
                } else {
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                        shopIdSkuRowNum = i + 2;
                        shopIdSku = map.get("sku");
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(",").append("sku:" + map.get("sku") + "与第" + shopIdSkuRowNum + "行sku:" + shopIdSku + "的店铺不一致");
                    }
                    monthlySalesImportRequest.setShopSkuId(shopSku.getShopSkuId());
                }
                monthlySalesImportRequest.setSku(shopSku.getShopSku());
            }
            monthlySalesImportRequest.setDescription(map.get("description"));
            monthlySalesImportRequest.setQuantity(MathUtil.strToInteger(map.get("quantity")));
            monthlySalesImportRequest.setMarketplace(map.get("marketplace"));
            monthlySalesImportRequest.setFulfillment(map.get("fulfillment"));
            monthlySalesImportRequest.setOrderCity(map.get("order city"));
            monthlySalesImportRequest.setOrderState(map.get("order state"));
            monthlySalesImportRequest.setOrderPostal(map.get("order postal"));
            CheckUtil.checkAndSetStr(monthlySalesImportRequest, sbErroItem, map, "tax collection model", null, false);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "product sales", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "product sales tax", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "shipping credits", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "shipping credits tax", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "gift wrap credits", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "giftwrap credits tax", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "promotional rebates", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "promotional rebates tax", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "marketplace withheld tax", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "selling fees", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "fba fees", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "selling fees", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "other transaction fees", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "other", null, true);
            CheckUtil.checkAndSetBigDecimal(monthlySalesImportRequest, sbErroItem, map, "total", null, true);
            monthlySalesImportRequestList.add(monthlySalesImportRequest);
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
        if (Boolean.TRUE.equals(finance.getMonthlySales())) {
            MonthlySalesExample monthlySalesExample = new MonthlySalesExample();
            monthlySalesExample.createCriteria().andFinanceIdEqualTo(finance.getId());
            customMonthlySalesMapper.deleteByExample(monthlySalesExample);
        }
        for (MonthlySalesImportRequest monthlySalesImportRequest : monthlySalesImportRequestList) {
            MonthlySales monthlySales = new MonthlySales();
            BeanUtils.copyProperties(monthlySalesImportRequest, monthlySales);
            monthlySales.setCreateBy(dealUserId);
            monthlySales.setCreateTime(new Date());
            monthlySales.setFinanceId(finance.getId());
            customMonthlySalesMapper.insert(monthlySales);
        }
        Finance financeUpdate = new Finance();
        financeUpdate.setId(finance.getId());
        financeUpdate.setUpdateBy(dealUserId);
        financeUpdate.setUpdateTime(new Date());
        financeUpdate.setMonthlySales(true);
        customFinanceMapper.updateByPrimaryKeySelective(financeUpdate);
        return BaseResponse.success();
    }
}
