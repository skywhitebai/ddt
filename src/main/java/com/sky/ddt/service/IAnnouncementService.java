package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.announcement.request.AnnouncementListRequest;
import com.sky.ddt.dto.announcement.request.AnnouncementSaveRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Announcement;

import java.util.List;

public interface IAnnouncementService {
    PageInfo<Announcement> list(AnnouncementListRequest params);

    BaseResponse save(AnnouncementSaveRequest params, Integer dealUserId);

    BaseResponse delete(List<Integer> announcementIds, Integer dealUserId);
}
