package com.sky.ddt.util;

import com.sky.ddt.common.exception.NoticeException;
import com.sky.ddt.dto.response.BaseResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.*;

public class ExcelUtil {
    public static List<Map<String, String>> getListByExcel(MultipartFile file) {
        BaseResponse<List<Map<String, String>>> baseResponse = getListByExcel(file, null, null);
        return baseResponse.getData();
    }

    //读取excel
    public static Workbook readExcel(MultipartFile file) {
        Workbook wb = null;
        String extString = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            InputStream is = file.getInputStream();
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    //读取excel
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //用于转化为日期格式
                        Date d = cell.getDateCellValue();
                        cellValue = com.sky.ddt.util.DateUtil.getFormatDateStr(d);
                        break;
                    }
                    DecimalFormat df = new DecimalFormat("#.########");
                    cellValue = df.format(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    try {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    } catch (IllegalStateException e) {
                        try {
                            cellValue = String.valueOf(cell.getRichStringCellValue());
                        } catch (IllegalStateException ex) {
                            throw ex;
                        }
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                case Cell.CELL_TYPE_BOOLEAN: {
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

    public static String getCellFormatValueString(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    if (cell.getCellStyle().getDataFormat() == 58) {
                        double value = cell.getNumericCellValue();
                        Date date = DateUtil.getJavaDate(value);
                        cellValue = com.sky.ddt.util.DateUtil.getFormatDateStrYMD(date);
                    } else {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                        if (cellValue != null && cellValue.endsWith(".0")) {
                            cellValue = cellValue.substring(0, cellValue.length() - 2);
                        }
                    }
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        cellValue = com.sky.ddt.util.DateUtil.getFormatDateStr(cell.getDateCellValue());
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

    public static boolean isExcel(MultipartFile file) {
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        if (!".xls".equals(extName) && !".xlsx".equals(extName)) {
            return false;
        } else {
            return true;
        }
    }

    public static BaseResponse<List<Map<String, String>>> getListByExcel2(MultipartFile file) {
        return getListByExcel(file, null, null);
    }

    /**
     * @param file             导入的文件
     * @param titleRowNum      标题行号 1开始 默认1
     * @param firstColumnTitle 第一列标题
     * @return
     * @description 读取excel
     * @author baixueping
     * @date 2019/11/27 14:58
     */
    public static BaseResponse<List<Map<String, String>>> getListByExcel(MultipartFile file, Integer titleRowNum, String firstColumnTitle) {
        if (file == null) {
            return BaseResponse.failMessage("文件不能为空");
        }
        Workbook wb = readExcel(file);
        if (wb == null) {
            return BaseResponse.failMessage("文件读取失败");
        }
        //获取第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        Row row = null;
        String cellData = null;
        List<String> columns = new ArrayList<String>();
        //获取最大行数
        int rownum = sheet.getLastRowNum();
        if (rownum == 0) {
            return BaseResponse.failMessage("文件内容为空");
        }
        Integer actualTitleRowNum = 0;
        if (titleRowNum != null) {
            if (titleRowNum < 1) {
                return BaseResponse.failMessage("标题行设置错误");
            } else {
                actualTitleRowNum = titleRowNum - 1;
            }
        } else if (!StringUtils.isEmpty(firstColumnTitle)) {
            Boolean notHaveFirstColumnTitle = true;
            for (int i = 0; i <= rownum; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cellData = (String) getCellFormatValue(row.getCell(0));
                    if (firstColumnTitle.equals(cellData)) {
                        actualTitleRowNum = i;
                        notHaveFirstColumnTitle = false;
                        break;
                    }
                }
            }
            if (notHaveFirstColumnTitle) {
                return BaseResponse.failMessage("第一列标题不存在");
            }
        }
        //获取 标题行
        row = sheet.getRow(actualTitleRowNum);
        if (row == null) {
            return BaseResponse.failMessage("标题行为空");
        }
        //获取最大列数
        int colnum = row.getPhysicalNumberOfCells();
        //读取标题行
        for (int j = 0; j < colnum; j++) {
            cellData = (String) getCellFormatValue(row.getCell(j));
            columns.add(cellData);
        }
        //用来存放表中数据
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (int i = actualTitleRowNum + 1; i <= rownum; i++) {
            Map<String, String> map = new LinkedHashMap<String, String>();
            row = sheet.getRow(i);
            Boolean isEmpty = true;
            if (row != null) {
                for (int j = 0; j < colnum; j++) {
                    try{
                        cellData = (String) getCellFormatValue(row.getCell(j));
                    }catch (Exception ex){
                        throw new NoticeException(String.format("第%d行，第%d列，数据错误：%s",i+1,j+1,ex.getMessage()));
                    }
                    if (!StringUtils.isEmpty(cellData)) {
                        isEmpty = false;
                    }
                    map.put(columns.get(j), cellData);
                }
            }
            if (isEmpty) {
                //空行
                map.put("isEmpty", "true");
            }
            map.put("rowNum", String.valueOf(i + 1));
            list.add(map);
        }
        return BaseResponse.successData(list);
    }

    public static BaseResponse exportExcel(HttpServletResponse response, Workbook wb, String fileName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + com.sky.ddt.util.DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx");//默认Excel名称
            wb.write(outputStream);
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
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }
    }

    public static BaseResponse exportExcelXls(HttpServletResponse response, Workbook wb, String fileName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + com.sky.ddt.util.DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xls");//默认Excel名称
            wb.write(outputStream);
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
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }
    }
}
