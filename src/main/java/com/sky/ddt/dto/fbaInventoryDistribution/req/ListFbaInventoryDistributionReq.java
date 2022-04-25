package com.sky.ddt.dto.fbaInventoryDistribution.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author sky
 * @Description
 * @date 2022/4/21 23:43
 */
@Data
public class ListFbaInventoryDistributionReq extends DataGridRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date snapshotDay;
    private String fnsku;
    private String sku;
    private String productName;
    private String fulfillmentCenterId;
    private String detailedDisposition;
}
