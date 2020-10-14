package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.OrderImportMapper;
import com.sky.ddt.dto.orderImport.request.ListOrderImportRequest;
import com.sky.ddt.dto.orderImport.response.ListOrderImportResponse;
import com.sky.ddt.dto.shopSku.request.SalesCountRequest;
import com.sky.ddt.dto.shopSku.response.SalesCountDayResponse;
import com.sky.ddt.dto.shopSku.response.SalesPriceDayResponse;
import com.sky.ddt.dto.shopSku.response.ShopSkuFullProductName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 订单导入
 * @date 2019/8/14 11:34
 */
public interface CustomOrderImportMapper extends OrderImportMapper {
    /**
     * @param
     * @return
     * @description 分页查询导入订单列表
     * @author baixueping
     * @date 2019/8/14 12:58
     */
    List<ListOrderImportResponse> listOrderImport(ListOrderImportRequest params);

    /**
     * @param
     * @return
     * @description 获取shopSku每日销售数据
     * @author baixueping
     * @date 2019/8/30 15:42
     */
    List<SalesCountDayResponse> listSalesCountDayResponse(SalesCountRequest params);

    List<SalesCountDayResponse> listSalesCountDayShopParentSkuResponse(SalesCountRequest params);

    List<SalesPriceDayResponse> listSalesPriceDayResponse(SalesCountRequest params);

    List<SalesPriceDayResponse> listSalesPriceDayShopParentSkuResponse(SalesCountRequest params);
}
