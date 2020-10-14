package com.sky.ddt.dto.orderImport.response;

import com.sky.ddt.entity.OrderImport;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表显示导入订单信息
 * @date 2019/8/14 12:43
 */
@Data
public class ListOrderImportResponse extends OrderImport{
    String shopName;
}
