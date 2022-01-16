package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.CheckOrderMapper;
import com.sky.ddt.dto.checkOrder.request.ListCheckOrderRequest;
import com.sky.ddt.dto.checkOrder.response.ListCheckOrderResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 盘点单操作类
 * @date 2020/5/9 10:52
 */
public interface CustomCheckOrderMapper extends CheckOrderMapper {
    /**
     * @param
     * @return 
     * @description 列表查询盘点单
     * @author baixueping
     * @date 2020/5/11 10:06
    */
    List<ListCheckOrderResponse> listCheckOrder(ListCheckOrderRequest params);

    void insertShopSkuStorageLocationByCheckOrder(@Param("id") Integer id, @Param("dealUserId")  Integer dealUserId);

    void deleteShopSkuStorageLocationByCheckOrder(@Param("checkOrderId") Integer checkOrderId);
}
