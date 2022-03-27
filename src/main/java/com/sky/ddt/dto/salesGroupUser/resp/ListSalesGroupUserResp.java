package com.sky.ddt.dto.salesGroupUser.resp;

import com.sky.ddt.entity.SalesGroupUser;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/3/27 13:47
 */
@Data
public class ListSalesGroupUserResp extends SalesGroupUser {
    String groupName;
    String realName;
}
