package com.sky.ddt.dto.finance.response;

import com.sky.ddt.entity.Finance;
import lombok.Data;

/**
 * @author baixueping
 * @description 财务信息
 * @date 2019/11/20 16:13
 */
@Data
public class FinanceListResponse extends Finance {
    String shopName;
}
