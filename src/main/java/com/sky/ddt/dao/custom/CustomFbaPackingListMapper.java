package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FbaPackingListMapper;
import com.sky.ddt.dto.deliverGoods.request.InvoiceSkuInfo;
import com.sky.ddt.dto.fbaPackingList.request.ListFbaPackingListRequest;
import com.sky.ddt.dto.fbaPackingList.request.ListInvoiceInfoRequest;
import com.sky.ddt.dto.fbaPackingList.response.ListFbaPackingListResponse;
import com.sky.ddt.dto.fbaPackingList.response.ListInvoiceInfoResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description fba装箱单
 * @date 2020/7/22 11:10
 */
public interface CustomFbaPackingListMapper extends FbaPackingListMapper {
    List<ListFbaPackingListResponse> listFbaPackingList(ListFbaPackingListRequest params);

    List<ListInvoiceInfoResponse> listInvoiceInfo(ListInvoiceInfoRequest params);

    List<InvoiceSkuInfo> listInvoiceSkuInfo(@Param("fbaPackingListId") Integer fbaPackingListId,@Param("orderNumber") String orderNumber);
}
