package com.sky.ddt.dto.shopSku.request;

import com.sky.ddt.common.constant.ShopSkuConstant;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 店铺sku列表
 * @date 2019/7/29 15:10
 */
@Data
public class SalesCountRequest extends DataGridRequest {
    Integer shopId;
    String shopSku;
    String shopParentSku;
    String productCode;
    String sku;
    String productName;
    Integer userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = ShopSkuConstant.PURCHASE_DATE_START_EMPTY)
    Date purchaseDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = ShopSkuConstant.PURCHASE_DATE_END_EMPTY)
    Date purchaseDateEnd;
    //中间值 用于获取销售数据
    List<Integer> shopSkuIdList;
    List<String> shopParentSkuList;
    String searchType;
}
