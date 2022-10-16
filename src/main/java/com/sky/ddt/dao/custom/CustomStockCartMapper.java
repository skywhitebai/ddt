package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.StockCartMapper;
import com.sky.ddt.dto.stock.request.ListSendQuntityReq;
import com.sky.ddt.dto.stock.request.ListStockRequest;
import com.sky.ddt.dto.stock.response.ListSendQuantityResp;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.dto.stock.response.SendQuantityDto;
import com.sky.ddt.entity.StockCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 备货
 * @date 2019/8/21 14:41
 */
public interface CustomStockCartMapper extends StockCartMapper {
    /**
     * @param
     * @return
     * @description 查询备货信息
     * @author baixueping
     * @date 2019/8/21 14:50
     */
    List<ListStockResponse> listStock(ListStockRequest params);

    List<ListStockResponse> listWarehouseStock(ListStockRequest params);

    List<ListStockResponse> listWarehouseStockOtherInfo(List<Integer> list);

    List<SendQuantityDto> listSendQuantity(@Param("shopSkuIdList") List<Integer> shopSkuIdList, @Param("shopId") Integer shopId);

    List<ListSendQuantityResp> listPageSendQuantity(ListSendQuntityReq params);
}
