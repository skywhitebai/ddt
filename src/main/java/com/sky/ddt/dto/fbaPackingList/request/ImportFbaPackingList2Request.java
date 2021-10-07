package com.sky.ddt.dto.fbaPackingList.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sky
 * @Description ImportFbaPackingList2Request
 * @date 2021/10/7 23:16
 */
@Data
public class ImportFbaPackingList2Request {
    @NotEmpty(message = "FBAshipment id不能为空")
    String fbaShipmentId;
    @NotEmpty(message = "shipTo不能为空")
    String shipTo;
    MultipartFile file;
}
