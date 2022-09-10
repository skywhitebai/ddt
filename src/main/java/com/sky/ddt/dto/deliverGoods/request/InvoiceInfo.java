package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description发票信息
 * @date 2019/9/17 15:23
 */
@Data
public class InvoiceInfo {
    Integer fbaPackingListId;
    String shipmentId;
    String referenceId;
    String fbaNo;
    String shipTo;
    Date date;
    Integer numberOfBoxes;
    Double totalPrice;
    Double unitPrice;
    Integer totalQuantity;
    String shopName;
    List<InvoiceGoodsInfo> invoiceGoodsInfoList;
    List<InvoicePackingInfo> invoicePackingInfoList;
}
