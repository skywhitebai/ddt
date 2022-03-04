package com.sky.ddt.dto.internalOrderNumberFinancialRemarkHis.resp;

import com.sky.ddt.entity.InternalOrderNumberFinancialRemarkHis;
import lombok.Data;

/**
 * @author sky
 * @Description 内部单号财务备注历史
 * @date 2022/3/4 22:11
 */
@Data
public class ListInternalOrderNumberFinancialRemarkHisResp extends InternalOrderNumberFinancialRemarkHis {
    String createUserRealName;
}
