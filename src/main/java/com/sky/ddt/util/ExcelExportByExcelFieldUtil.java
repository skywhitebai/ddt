package com.sky.ddt.util;

import com.sky.ddt.common.excel.ExcelField;
import com.sky.ddt.dto.response.BaseResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author baixueping
 * @description excel导出
 * @date 2019/4/24 10:47
 */
public class ExcelExportByExcelFieldUtil<T> {

    public BaseResponse export(HttpServletResponse response, List<T> list, List<ExcelField> excelFieldList, String fileName) {
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx");//默认Excel名称
            return exportExcel(response, list, excelFieldList, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.failMessage(e.getMessage());
        }
    }

    private BaseResponse exportExcel(HttpServletResponse response, List<T> list, List<ExcelField> excelFieldList, String fileName) {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = fileName;
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        XSSFRow row = sheet.createRow(0);
        for (short i = 0; i < excelFieldList.size(); i++) {
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(excelFieldList.get(i).getTitle());
            cell.setCellValue(text);
        }
        try {
            // 遍历集合数据，产生数据行
            Iterator<T> it = list.iterator();
            int index = 0;
            //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
            Drawing patriarch = sheet.createDrawingPatriarch();
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = it.next();
                for (short i = 0; i < excelFieldList.size(); i++) {
                    String fieldName = excelFieldList.get(i).getFieldName();
                    String getMethodName = "get"
                            + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[]{});
                    Object value = getMethod.invoke(t, new Object[]{});
                    if (value == null) {
                        continue;
                    }
                    XSSFCell cell = row.createCell(i);
                    if (ExcelField.FieldTypeEnum.IMG_URL.equals(excelFieldList.get(i).getFieldType())) {
                        //如果是图片
                        if (StringUtils.isEmpty(value)) {
                            continue;
                        }
                        URL url = null;
                        String imgUrl = value.toString();
                        try {
                            String imgUrlReal = imgUrl;
                            if (imgUrlReal.contains("allmiin.cn")) {
                                imgUrlReal = imgUrlReal.replace("allmiin.cn", "ddt-file.oss-cn-beijing.aliyuncs.com");
                            }
                            url = new URL(imgUrlReal);
                        } catch (Exception ex) {
                            cell.setCellValue(imgUrl);
                            continue;
                        }
                        row.setHeight((short) 1000);
                        sheet.setColumnWidth(i, 2000);
                        setExcelImg(workbook, patriarch, index, i, url);
                    } else if (ExcelField.FieldTypeEnum.NUMBER_RATE_NEED_MULTIPLY_100.equals(excelFieldList.get(i).getFieldType())) {
                        BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));
                        String str = bigDecimal.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%";
                        cell.setCellValue(str);
                    } else if (value.getClass().equals(Date.class)) {
                        String textValue = DateUtil.getFormatDateStr((Date) value);
                        cell.setCellValue(textValue);
                    } else if (value.getClass().equals(Integer.class)) {
                        cell.setCellValue((Integer) value);
                    } else if (value.getClass().equals(Long.class)) {
                        cell.setCellValue((Long) value);
                    } else if (value.getClass().equals(BigDecimal.class)) {
                        cell.setCellValue(((BigDecimal) value).doubleValue());
                    } else if (value.getClass().equals(Double.class)) {
                        cell.setCellValue((Double) value);
                    } else {
                        cell.setCellValue(value.toString());
                    }
                }
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            ByteArrayInputStream tempIn = new ByteArrayInputStream(outputStream.toByteArray());
            response.setHeader("Content-Length", String.valueOf(tempIn.available()));
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int a;
            while ((a = tempIn.read(buffer)) != -1) {
                out.write(buffer, 0, a);
            }
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }
    }

    /**
     * 导出写图片
     */
    private static void setExcelImg(XSSFWorkbook wb,
                                    Drawing patriarch, int rowIndex, int cloumIndex, URL url) {
        // （jdk1.7版本try中定义流可自动关闭）
        try (InputStream is = url.openStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = is.read(buff, 0, 1024)) > 0) {
                outputStream.write(buff, 0, rc);
            }
            // 设置图片位置
            XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 1000, 1000,
                    cloumIndex, rowIndex, cloumIndex + 1, rowIndex + 1);
            anchor.setAnchorType(0);
            Picture pict = patriarch.createPicture(anchor, wb.addPicture(
                    outputStream.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            /*pict.resize();*/
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
