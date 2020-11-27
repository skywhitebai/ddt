package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.report.SalesReportConstant;
import com.sky.ddt.dao.custom.CustomReportMapper;
import com.sky.ddt.dto.report.salesReport.request.ListSalesReportRequest;
import com.sky.ddt.dto.report.salesReport.request.ListSalesmanReportRequest;
import com.sky.ddt.dto.report.salesReport.response.ListSalesReportResponse;
import com.sky.ddt.dto.report.salesReport.response.ListSalesmanReportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IImgService;
import com.sky.ddt.service.IReportService;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    /**
     * @param params@return
     * @description 查询销售人员业绩
     * @author baixueping
     * @date 2020/11/27 11:43
     */
    @Override
    public BaseResponse salesmanReportChart(ListSalesmanReportRequest params) {
        List<ListSalesmanReportResponse> list = customReportMapper.listSalesmanReport(params);
        return getSalesmanReportChart(list);
    }

    private BaseResponse getSalesmanReportChart(List<ListSalesmanReportResponse> list) {
        String categories = getSalesmanReportChartCategories(list);
        String series = getSalesmanReportChartSeries(list);
        String res = "{\"categories\":" + categories + ",\"series\":" + series + "}";
        return BaseResponse.successData(res);
    }

    private String getSalesmanReportChartSeries(List<ListSalesmanReportResponse> list) {
        StringBuilder sbSeries = new StringBuilder();
        sbSeries.append(getSerie(list, "orderQuantityTotal", "订单数（个）",0));
        sbSeries.append(getSerie(list, "quantityTotal", "销售件数（个）",1));
        sbSeries.append(getSerie(list, "itemPriceTotal", "销售额（美元）",2));
        sbSeries.append(getSerie(list, "itemPriceAverage", "客单价（美元）",3));
        return "["+sbSeries.substring(1)+"]";
    }

    private Object getValue(Object t, String fieldName) {
        String getMethodName = "get"
                + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
        Class tCls = t.getClass();
        Method getMethod = null;
        try {
            getMethod = tCls.getMethod(getMethodName,
                    new Class[]{});
            Object value = getMethod.invoke(t, new Object[]{});
            return value;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getSerie(List<ListSalesmanReportResponse> list, String fieldName, String name, int yAxis) {
        StringBuilder sbSerie = new StringBuilder();
        sbSerie.append(",{\"name\":\"" + name + "\",\"yAxis\": "+yAxis+",\"data\":[");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sbSerie.append(",");
            }
            sbSerie.append(getValue(list.get(i), fieldName));
        }
        sbSerie.append("]}");
        return sbSerie.toString();
    }

    private String getSalesmanReportChartCategories(List<ListSalesmanReportResponse> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"").append(list.get(i).getRealName()).append("\"");
        }
        sb.append("]");
        return sb.toString();
    }

    private void updateListSalesReportResponse(ListSalesReportResponse listSalesReportResponse) {
        if (listSalesReportResponse.getQuantityToday() == null) {
            listSalesReportResponse.setQuantityToday(0);
        }
        if (listSalesReportResponse.getNetSalesToday() == null) {
            listSalesReportResponse.setNetSalesToday(BigDecimal.ZERO);
        }
        listSalesReportResponse.setUnitPriceToday(MathUtil.divideBigDecimalInteger(listSalesReportResponse.getNetSalesToday(), listSalesReportResponse.getQuantityToday(), 2));
        if (listSalesReportResponse.getQuantityYesterday() == null) {
            listSalesReportResponse.setQuantityYesterday(0);
        }
        if (listSalesReportResponse.getNetSalesYesterday() == null) {
            listSalesReportResponse.setNetSalesYesterday(BigDecimal.ZERO);
        }
        listSalesReportResponse.setUnitPriceYesterday(MathUtil.divideBigDecimalInteger(listSalesReportResponse.getNetSalesYesterday(), listSalesReportResponse.getQuantityYesterday(), 2));
        if (listSalesReportResponse.getQuantitySameDayLastWeek() == null) {
            listSalesReportResponse.setQuantitySameDayLastWeek(0);
        }
        if (listSalesReportResponse.getNetSalesSameDayLastWeek() == null) {
            listSalesReportResponse.setNetSalesSameDayLastWeek(BigDecimal.ZERO);
        }
        listSalesReportResponse.setUnitPriceSameDayLastWeek(MathUtil.divideBigDecimalInteger(listSalesReportResponse.getNetSalesSameDayLastWeek(), listSalesReportResponse.getQuantitySameDayLastWeek(), 2));
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
