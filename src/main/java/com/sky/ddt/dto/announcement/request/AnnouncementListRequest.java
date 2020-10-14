package com.sky.ddt.dto.announcement.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

@Data
public class AnnouncementListRequest extends DataGridRequest {
    String title;
    Integer status;
}
