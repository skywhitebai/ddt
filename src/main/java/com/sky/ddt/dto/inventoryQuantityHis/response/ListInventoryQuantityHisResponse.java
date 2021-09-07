package com.sky.ddt.dto.inventoryQuantityHis.response;

import lombok.Data;

import java.util.Date;

/**
 * @author sky
 * @Description TODO
 * @date 2021/8/21 12:36
 */
@Data
public class ListInventoryQuantityHisResponse {
    private Long id;
    private Integer productId;
    private String productName;
    private String productCode;

    private Integer skuId;
    private String sku;

    private Integer inventoryQuantity;

    private Date month;

    private String remark;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;
}
