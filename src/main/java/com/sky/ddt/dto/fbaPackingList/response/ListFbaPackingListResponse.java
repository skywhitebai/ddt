package com.sky.ddt.dto.fbaPackingList.response;

import com.sky.ddt.entity.FbaPackingList;
import lombok.Data;

/**
 * @author baixueping
 * @description fba装箱单返回值
 * @date 2020/7/22 11:14
 */
@Data
public class ListFbaPackingListResponse extends FbaPackingList{
    String shopName;
    Integer outboundOrderStatus;
}
