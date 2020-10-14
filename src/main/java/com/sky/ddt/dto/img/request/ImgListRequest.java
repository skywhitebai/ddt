package com.sky.ddt.dto.img.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description ImgListRequest
 * @date 2019/7/23 11:01
 */
@Data
public class ImgListRequest extends DataGridRequest {
    private Integer entityId;
    private String imgType;
}
