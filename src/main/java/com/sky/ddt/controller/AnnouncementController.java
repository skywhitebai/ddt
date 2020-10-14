package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.announcement.request.AnnouncementListRequest;
import com.sky.ddt.dto.announcement.request.AnnouncementSaveRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Announcement;
import com.sky.ddt.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("announcement")
public class AnnouncementController extends SuperController {
    @Autowired
    IAnnouncementService announcementService;
    @RequestMapping("/index")
    public  String index(){
        return "announcement/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public DataGridResponse list(AnnouncementListRequest params) {
        PageInfo<Announcement> page=announcementService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("save")
    @ResponseBody
    public BaseResponse save(AnnouncementSaveRequest params) {
        Integer dealUserId=getCurrentUserId();
        return announcementService.save(params,dealUserId);
    }
    @RequestMapping("delete")
    @ResponseBody
    public BaseResponse delete(@RequestParam(required = false, value = "announcementIds[]") List<Integer> announcementIds) {
        Integer dealUserId=getCurrentUserId();
        return announcementService.delete(announcementIds,dealUserId);
    }

}
