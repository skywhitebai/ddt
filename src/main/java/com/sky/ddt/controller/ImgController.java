package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.LogRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.img.request.AddImgRequest;
import com.sky.ddt.dto.img.request.ImgListRequest;
import com.sky.ddt.dto.productimg.request.ProductImgAddRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Img;
import com.sky.ddt.entity.ImgData;
import com.sky.ddt.entity.ProductImg;
import com.sky.ddt.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author baixueping
 * @description 图片controller
 * @date 2019/7/23 10:09
 */
@Controller
@RequestMapping("/img")
public class ImgController extends SuperController {
    @Autowired
    IImgService imgService;
    @RequestMapping("/addImg")
    @LogRequest(action = Action.Skip)
    @ResponseBody
    public BaseResponse addImg(AddImgRequest params) {
        Integer dealUserId = getCurrentUserId();
        return imgService.addImg(params, dealUserId);
    }
    @RequestMapping("/list")
    @ResponseBody
    public DataGridResponse list(ImgListRequest params){
        PageInfo<Img> page=imgService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/deleteImg")
    @ResponseBody
    @LogRequest(action = Action.Skip)
    public BaseResponse deleteImg(@RequestParam(required = false, value = "imgIds[]") List<Integer> imgIds) {
        return imgService.deleteImg(imgIds);
    }
    @Deprecated
    @RequestMapping("get")
    @ResponseBody
    public void get(Integer imgId) throws IOException {
        ImgData imgData=imgService.getImgDataById(imgId);
        response.setContentType("image/jpeg");  //设置图片格式
        if(imgData!=null){
            OutputStream out = response.getOutputStream(); //打开输出流
            out.write(imgData.getImgData());  //输出图片
            out.flush();	//输出
            out.close();  //关闭输出
        }
    }
}
