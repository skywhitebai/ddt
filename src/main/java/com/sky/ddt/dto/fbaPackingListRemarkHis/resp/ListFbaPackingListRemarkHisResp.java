package com.sky.ddt.dto.fbaPackingListRemarkHis.resp;

import com.sky.ddt.entity.FbaPackingListRemarkHis;
import lombok.Data;

/**
 * @author sky
 * @Description ListFbaPackingListRemarkHisResp
 * @date 2023/3/16 22:51
 */
@Data
public class ListFbaPackingListRemarkHisResp extends FbaPackingListRemarkHis {
    String createUserRealName;
}
