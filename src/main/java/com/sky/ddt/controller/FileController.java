package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.LogRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.file.request.AddFileRequest;
import com.sky.ddt.dto.file.request.FileListRequest;
import com.sky.ddt.dto.img.request.AddImgRequest;
import com.sky.ddt.dto.img.request.ImgListRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.File;
import com.sky.ddt.entity.Img;
import com.sky.ddt.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sky
 * @Description 文件控制器
 * @date 2021/9/6 21:48
 */
@Controller
@RequestMapping("/file")
public class FileController extends SuperController {
    @Autowired
    IFileService fileService;
    @RequestMapping("/addFile")
    @LogRequest(action = Action.Skip)
    @ResponseBody
    public BaseResponse addFile(AddFileRequest params) {
        Integer dealUserId = getCurrentUserId();
        return fileService.addFile(params, dealUserId);
    }
    @RequestMapping("/list")
    @ResponseBody
    public DataGridResponse list(FileListRequest params){
        PageInfo<File> page=fileService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/deleteFile")
    @ResponseBody
    @LogRequest(action = Action.Skip)
    public BaseResponse deleteFile(@RequestParam(required = false, value = "fileIds[]") List<Integer> fileIds) {
        return fileService.deleteFile(fileIds);
    }
}
