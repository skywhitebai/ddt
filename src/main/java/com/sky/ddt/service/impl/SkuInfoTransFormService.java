package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomSkuInfoMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.skuinfo.response.SkuInfoResponse;
import com.sky.ddt.entity.SkuInfo;
import com.sky.ddt.entity.SkuInfoExample;
import com.sky.ddt.service.ISkuInfoTransFormService;
import com.sky.ddt.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SkuInfoTransFormService implements ISkuInfoTransFormService {
    Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    CustomSkuInfoMapper customSkuInfoMapper;

    @Override
    public BaseResponse exportTransformSkuInfoStream(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        if(file==null||file.isEmpty()){
            return BaseResponse.failMessage("请选择要上传的文件");
        };
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        if(!".xls".equals(extName)&&!".xlsx".equals(extName)){
            return BaseResponse.failMessage("文件格式错误，必须上传excel");
        }
        //先识别为workBook
        Workbook workbook= ExcelUtil.readExcel(file);
        if(workbook==null){
            return BaseResponse.failMessage("excel识别失败");
        }
        if(workbook.getNumberOfSheets()==0){
            return BaseResponse.failMessage("excel为空");
        }
        Sheet sheet=workbook.getSheetAt(0);
        //找到标题行
        Integer titleRowNum=null;
        for(int i=0;i<sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            if(row==null){
                continue;
            }
            String cellData = ExcelUtil.getCellFormatValueString(row.getCell(0));
            if("卖家 SKU".equals(cellData)){
                titleRowNum=i;
                break;
            }
        }
        if(titleRowNum==null){
            return BaseResponse.failMessage("模板错误,第一列找不到标题【卖家 SKU】");
        }
        Row titleRow = sheet.getRow(titleRowNum);
        Integer sendCountCellNum=null;
        for(int i=0;i<titleRow.getLastCellNum();i++){
            String cellData = ExcelUtil.getCellFormatValueString(titleRow.getCell(i));
            if("已发货".equals(cellData)){
                sendCountCellNum=i;
            }
        }
        if(sendCountCellNum==null){
            return BaseResponse.failMessage("模板错误,第"+(titleRowNum+1)+"行标题行找不到标题【已发货】");
        }
        StringBuilder sbErro = new StringBuilder();
        //如果导入模板只有店铺sku和已发货，则需要补全四列
        if(titleRow.getCell(1)==null){
            titleRow.createCell(1);
        }
        if(titleRow.getCell(2)==null){
            titleRow.createCell(2);
        }
        if(titleRow.getCell(3)==null){
            titleRow.createCell(3);
        }
        //校验数据是否完整 并获取所有sku
        List<String> sellerSkuList=new ArrayList<>();
        for(int i=titleRowNum+1;i<=sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            if(row==null){
                continue;
            }
            //[忽略空行
            Boolean isEmpty=true;
            for(int j=0;j<row.getLastCellNum();j++){
                if(!StringUtils.isEmpty(ExcelUtil.getCellFormatValueString(row.getCell(0)))){
                    isEmpty=false;
                    break;
                }
            }
            if(isEmpty){
                continue;
            }
            //忽略空行]
            String skuSeller= ExcelUtil.getCellFormatValueString(row.getCell(0));
            if(StringUtils.isEmpty(skuSeller)){
                sbErro.append(",第").append(i+2).append("行【卖家 SKU】数据为空");
            }else{
                if(!sellerSkuList.contains(skuSeller)){
                    sellerSkuList.add(skuSeller);
                }
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        //获取所有sku信息
        List<SkuInfoResponse> skuInfoResponseList=null;
        if(CollectionUtils.isEmpty(sellerSkuList)){
            skuInfoResponseList=new ArrayList<>();
        }else{
            skuInfoResponseList=customSkuInfoMapper.selectBySellerSku(sellerSkuList);
        }
        titleRow.getCell(1).setCellValue("仓库SKU");
        titleRow.getCell(2).setCellValue("供应商SKU");
        titleRow.getCell(3).setCellValue("已发货");
        //四列后面的赋值为空字符串
        for(int i=4;i<titleRow.getLastCellNum();i++){
            titleRow.getCell(i).setCellValue("");
        }
        for(int i=titleRowNum+1;i<=sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            //[忽略空行
            if(row==null){
                continue;
            }
            Boolean isEmpty=true;
            for(int j=0;j<row.getLastCellNum();j++){
                if(!StringUtils.isEmpty(ExcelUtil.getCellFormatValueString(row.getCell(0)))){
                    isEmpty=false;
                    break;
                }
            }
            if(isEmpty){
                continue;
            }
            //忽略空行]
            if(row.getCell(1)==null){
                row.createCell(1);
            }
            if(row.getCell(2)==null){
                row.createCell(2);
            }
            if(row.getCell(3)==null){
                row.createCell(3);
            }
            String skuSeller= ExcelUtil.getCellFormatValueString(row.getCell(0));
            String sendCount= ExcelUtil.getCellFormatValueString(row.getCell(sendCountCellNum));
            row.getCell(3).setCellValue(sendCount);
            SkuInfoResponse skuInfoResponse=getSkuInfo(skuInfoResponseList,skuSeller);
            if (skuInfoResponse!=null) {
                row.getCell(1).setCellValue(skuInfoResponse.getSkuWarehouse());
                row.getCell(2).setCellValue(skuInfoResponse.getSkuSupplier());
            }
            for(int j=4;j<row.getLastCellNum();j++){
                Cell cell=row.getCell(j);
                if(cell!=null){
                    row.getCell(j).setCellValue("");
                }
            }
        }

        // 第七步，将文件存到指定位置
        try {
            response.setContentType("application/octet-stream");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
            String fileName="sku信息"+sdf.format(new Date());
            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8")+".xls");//默认Excel名称
            ServletOutputStream out=response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseResponse.fail();
    }

    private SkuInfoResponse getSkuInfo(List<SkuInfoResponse> skuInfoResponseList, String skuSeller) {
        if(CollectionUtils.isEmpty(skuInfoResponseList)||StringUtils.isEmpty(skuSeller)){
            return null;
        }
        for(SkuInfoResponse skuInfoResponse:skuInfoResponseList){
            if(skuSeller.equals(skuInfoResponse.getSkuSeller())){
                return skuInfoResponse;
            }
        }
        return null;
    }

    String getfilePath(){
        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMM");
        String yearMonth=sf.format(date);
        String filePath="downLoad/skuInfo/"+yearMonth+"/"+java.util.UUID.randomUUID();
        return filePath;
    }
}

