package com.sky.ddt.dto.stockRemark.resp;

import com.sky.ddt.entity.StockRemark;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/10/25 23:07
 */
@Data
public class ListStockRemarkResp extends StockRemark {
    String createRealName;
    String shopSku;
}
