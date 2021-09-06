package com.sky.ddt.dto.file.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description FileListRequest
 * @date 2019/7/23 11:01
 */
@Data
public class FileListRequest extends DataGridRequest {
    private Integer entityId;
    private String fileType;
}
