package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.WarehousingOrderMapper;
import com.sky.ddt.dto.warehousingOrder.request.ListWarehousingOrderRequest;
import com.sky.ddt.dto.warehousingOrder.response.ExportWarehousingOrderResponse;
import com.sky.ddt.dto.warehousingOrder.response.ListWarehousingOrderResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 入库单管理
 * @date 2020/4/10 9:16
 */
public interface CustomWarehousingOrderMapper extends WarehousingOrderMapper {
    /**
     * @param
     * @return
     * @description 分页查询入库单信息
     * @author baixueping
     * @date 2020/4/10 16:13
     */
    List<ListWarehousingOrderResponse> listWarehousingOrder(ListWarehousingOrderRequest listWarehousingOrderRequest);

    /**
     * @param
     * @return
     * @description 查询导出的入库单信息
     * @author baixueping
     * @date 2020/11/5 14:45
     */
    List<ExportWarehousingOrderResponse> listExportWarehousingOrder(ListWarehousingOrderRequest params);

    void updateShopSkuStorageLocation(@Param("id") Integer id,@Param("dealUserId")  Integer dealUserId);
}
