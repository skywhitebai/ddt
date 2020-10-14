package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.report.SalesReportConstant;
import com.sky.ddt.dao.custom.CustomReportMapper;
import com.sky.ddt.dto.report.salesReport.request.ListSalesReportRequest;
import com.sky.ddt.dto.report.salesReport.response.ListSalesReportResponse;
import com.sky.ddt.service.IImgService;
import com.sky.ddt.service.IReportService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 报表服务
 * @date 2020/4/16 10:33
 */
@Service
public class ReportService implements IReportService {
    @Autowired
    CustomReportMapper customReportMapper;
    @Autowired
    IImgService imgService;

    /**
     * @param params@return
     * @description 分页查询销售统计报表
     * @author baixueping
     * @date 2020/4/16 10:39
     */
    @Override
    public PageInfo<ListSalesReportResponse> listSalesReport(ListSalesReportRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListSalesReportResponse> list = new ArrayList<>();
        if (SalesReportConstant.SkuTypeEnum.SHOP_SKU.getSkuType().equals(params.getSkuType())) {
            list = customReportMapper.listSalesReportByShopSku(params);
        } else if (SalesReportConstant.SkuTypeEnum.SHOP_PARENT_SKU.getSkuType().equals(params.getSkuType())) {
            list = customReportMapper.listSalesReportByShopParentSku(params);
        }
        for (ListSalesReportResponse listSalesReportResponse :
                list) {
            String imgUrl = imgService.getImgUrlBySkuId(listSalesReportResponse.getSkuId());
            if (!StringUtils.isEmpty(imgUrl)) {
                listSalesReportResponse.setImgUrl(imgUrl);
            }
            updateListSalesReportResponse(listSalesReportResponse);
        }
        PageInfo<ListSalesReportResponse> page = new PageInfo<ListSalesReportResponse>(list);
        return page;
    }

    private void updateListSalesReportResponse(ListSalesReportResponse listSalesReportResponse) {
        if (listSalesReportResponse.getQuantityToday() == null) {
            listSalesReportResponse.setQuantityToday(0);
        }
        if (listSalesReportResponse.getNetSalesToday() == null) {
            listSalesReportResponse.setNetSalesToday(BigDecimal.ZERO);
        }
        listSalesReportResponse.setUnitPriceToday(MathUtil.divideBigDecimalInteger(listSalesReportResponse.getNetSalesToday(),listSalesReportResponse.getQuantityToday(),2));
        if (listSalesReportResponse.getQuantityYesterday() == null) {
            listSalesReportResponse.setQuantityYesterday(0);
        }
        if (listSalesReportResponse.getNetSalesYesterday() == null) {
            listSalesReportResponse.setNetSalesYesterday(BigDecimal.ZERO);
        }
        listSalesReportResponse.setUnitPriceYesterday(MathUtil.divideBigDecimalInteger(listSalesReportResponse.getNetSalesYesterday(),listSalesReportResponse.getQuantityYesterday(),2));
        if (listSalesReportResponse.getQuantitySameDayLastWeek() == null) {
            listSalesReportResponse.setQuantitySameDayLastWeek(0);
        }
        if (listSalesReportResponse.getNetSalesSameDayLastWeek() == null) {
            listSalesReportResponse.setNetSalesSameDayLastWeek(BigDecimal.ZERO);
        }
        listSalesReportResponse.setUnitPriceSameDayLastWeek(MathUtil.divideBigDecimalInteger(listSalesReportResponse.getNetSalesSameDayLastWeek(),listSalesReportResponse.getQuantitySameDayLastWeek(),2));
        if (listSalesReportResponse.getAvailableQuantity() == null) {
            listSalesReportResponse.setAvailableQuantity(0);
        }
        if (listSalesReportResponse.getInboundQuantity() == null) {
            listSalesReportResponse.setInboundQuantity(0);
        }
        if (listSalesReportResponse.getReservedQuantity() == null) {
            listSalesReportResponse.setReservedQuantity(0);
        }
    }
}
