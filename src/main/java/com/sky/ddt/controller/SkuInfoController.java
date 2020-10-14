package com.sky.ddt.controller;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.skuinfo.request.SkuInfoListRequest;
import com.sky.ddt.dto.skuinfo.request.SkuInfoSaveRequest;
import com.sky.ddt.dto.skuinfo.request.SkuInfoTransForm;
import com.sky.ddt.entity.SkuInfo;
import com.sky.ddt.service.ISkuInfoService;
import com.sky.ddt.service.ISkuInfoTransFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("skuInfo")
public class SkuInfoController extends SuperController {
    @Autowired
    ISkuInfoService skuInfoService;
    @Autowired
    ISkuInfoTransFormService skuInfoTransFormService;
    @RequestMapping("/index")
    public  String index(){
        return "skuInfo/list";
    }
    @RequestMapping("/transformSkuAll")
    @Login(action = Action.Skip)
    public  String transformSkuAll(){
        return "skuInfo/transformSkuAll";
    }

    @RequestMapping("/transformSku")
    @Login(action = Action.Skip)
    public  String transformSku(){
        return "skuInfo/transformSku";
    }

    @RequestMapping("list")
    @ResponseBody
    public DataGridResponse list(SkuInfoListRequest params) {
        PageInfo<SkuInfo> page=skuInfoService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("save")
    @ResponseBody
    public BaseResponse save(SkuInfoSaveRequest params) {
        Integer dealUserId=getCurrentUserId();
        return skuInfoService.save(params,dealUserId);
    }
    @RequestMapping("delete")
    @ResponseBody
    public BaseResponse delete(@RequestParam(required = false, value = "ids[]") List<Integer> ids) {
        return skuInfoService.delete(ids);
    }
    @RequestMapping("importSkuInfo")
    @ResponseBody
    public BaseResponse importSkuInfo(MultipartFile file) {
        Integer dealUserId=getCurrentUserId();
        return skuInfoService.importSkuInfo(file,dealUserId);
    }
    //transformSkuInfo

    /**
     * 弃用
     * @param file
     * @return
     */
    @RequestMapping("transformSkuInfo")
    @ResponseBody
    @Login(action = Action.Skip)
    public BaseResponse transformSkuInfo(MultipartFile file) {
        try {
            //查询数据
            BaseResponse<List<SkuInfoTransForm>> baseResponse = skuInfoService.transformSkuInfo(file);
            if(!baseResponse.isSuccess()){
                return  baseResponse;
            }
            response.setContentType("application/octet-stream");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
            String fileName="sku信息"+sdf.format(new Date());
            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8")+".xls");//默认Excel名称

            ServletOutputStream out=response.getOutputStream();
            //导出数据
            baseResponse= skuInfoService.exportTransformSkuInfo(out,baseResponse.getData());
            return baseResponse;
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("exportOrder fail:{}",e.getMessage());
            return BaseResponse.fail();
        }
    }

    /**
     * 用的这个方法
     * @param file
     * @return
     */
    @RequestMapping("/transformSkuInfoAll")
    @ResponseBody
    @Login(action = Action.Skip)
    public BaseResponse transformSkuInfoAll(MultipartFile file) {
        return skuInfoTransFormService.exportTransformSkuInfoStream(file,request,response);
    }
}
