package com.sky.ddt.util;

import com.sky.ddt.dto.response.BaseResponse;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author baixueping
 * @description excel导出
 * @date 2019/4/24 10:47
 */
public class ExcelExportUtil<T> {

    public BaseResponse export(HttpServletResponse response, List<T> list, String[] headers, String fileName) {
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx");//默认Excel名称
            return exportExcel(response, list, headers, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.failMessage(e.getMessage());
        }
    }

    private BaseResponse exportExcel(HttpServletResponse response, List<T> list, String[] headers, String fileName) {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = fileName;
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        XSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        try {
            // 遍历集合数据，产生数据行
            Iterator<T> it = list.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < headers.length; i++) {
                    Field field = fields[i];
                    String fieldName = field.getName();
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
                    if (value.getClass().equals(Date.class)) {
                        String textValue = DateUtil.getFormatDateStr((Date) value);
                        cell.setCellValue(textValue);
                    } else if (value.getClass().equals(Integer.class)) {
                        cell.setCellValue((Integer)value);
                    } else if (value.getClass().equals(Long.class)) {
                        cell.setCellValue((Long)value);
                    }else if (value.getClass().equals(BigDecimal.class)) {
                        cell.setCellValue(((BigDecimal)value).doubleValue());
                    }else if (value.getClass().equals(Double.class)) {
                        cell.setCellValue((Double)value);
                    }else{
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
}
