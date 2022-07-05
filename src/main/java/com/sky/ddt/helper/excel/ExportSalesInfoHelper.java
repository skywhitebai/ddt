package com.sky.ddt.helper.excel;

import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.SalesCountRequest;
import com.sky.ddt.dto.shopSku.response.SalesCountDayResponse;
import com.sky.ddt.dto.shopSku.response.SalesCountResponse;
import com.sky.ddt.util.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author sky
 * @Description
 * @date 2022/7/6 0:04
 */
public class ExportSalesInfoHelper {
    public static BaseResponse exportSalesInfo(HttpServletResponse response, List<SalesCountResponse> list, List<SalesCountDayResponse> salesCountDayResponseList, SalesCountRequest req) throws IOException {
        String sheetName = "店铺sku销售数据";
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(sheetName, "UTF-8") + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx");//默认Excel名称
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        //标题行
        XSSFRow row = sheet.createRow(0);
        //生成基础标题
        setBaseTitle(row);
        //生成日期标题并获取日期和列的对照关系
        Map<String, Integer> dayColumnIndexMap = setDayTitleAndReturnMap(req, row);
        //减少遍历次数,将salesCountDayResponseList转换为map
        setSkuSaleInfo(list, salesCountDayResponseList, req, sheet, dayColumnIndexMap);
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
    }
    private static void setSkuSaleInfo2(List<SalesCountResponse> list, List<SalesCountDayResponse> salesCountDayResponseList, SalesCountRequest req, XSSFSheet sheet, Map<String, Integer> dayColumnIndexMap) {
        //遍历sku
        int rowIndex = 1;
        if ("shopParentSku".equals(req.getSearchType())) {
            Map<String, List<SalesCountDayResponse>> salesCountDayResponseMap = getSalesCountDayResponseMapByShopParentSku(salesCountDayResponseList);
            for (SalesCountResponse salesCountResponse : list) {
                XSSFRow rowData = sheet.createRow(rowIndex);
                rowIndex++;
                setBaseRowData(rowData, salesCountResponse);
                List<SalesCountDayResponse> salesCountDayResponses = new ArrayList<>();
                salesCountDayResponses = salesCountDayResponseMap.get(salesCountResponse.getShopParentSku());
                int total = 0;
                for (SalesCountDayResponse salesCountDayResponse :
                        salesCountDayResponses) {
                    setRowValue(rowData, dayColumnIndexMap.get(salesCountDayResponse.getPurchaseDate()), salesCountDayResponse.getQuantity());
                    total = total + salesCountDayResponse.getQuantity();
                }
                setRowValue(rowData, dayColumnIndexMap.get("合计"), total);
            }
        } else {
            Map<Integer, List<SalesCountDayResponse>> salesCountDayResponseMap = getSalesCountDayResponseMapByShopSkuId(salesCountDayResponseList);
            for (SalesCountResponse salesCountResponse : list) {
                XSSFRow rowData = sheet.createRow(rowIndex);
                rowIndex++;
                setBaseRowData(rowData, salesCountResponse);
                List<SalesCountDayResponse> salesCountDayResponses = new ArrayList<>();
                salesCountDayResponses = salesCountDayResponseMap.get(salesCountResponse.getShopSkuId());
                int total = 0;
                for (SalesCountDayResponse salesCountDayResponse :
                        salesCountDayResponses) {
                    setRowValue(rowData, dayColumnIndexMap.get(salesCountDayResponse.getPurchaseDate()), salesCountDayResponse.getQuantity());
                    total = total + salesCountDayResponse.getQuantity();
                }
                setRowValue(rowData, dayColumnIndexMap.get("合计"), total);
            }
        }
    }
    private static void setSkuSaleInfo(List<SalesCountResponse> list, List<SalesCountDayResponse> salesCountDayResponseList, SalesCountRequest req, XSSFSheet sheet, Map<String, Integer> dayColumnIndexMap) {
        //遍历sku
        int rowIndex = 1;
        Map<Object, List<SalesCountDayResponse>> salesCountDayResponseMap = getSalesCountDayResponseMap(salesCountDayResponseList,req.getSearchType());
        for (SalesCountResponse salesCountResponse : list) {
            XSSFRow rowData = sheet.createRow(rowIndex);
            rowIndex++;
            setBaseRowData(rowData, salesCountResponse);
            List<SalesCountDayResponse> salesCountDayResponses = new ArrayList<>();
            if ("shopParentSku".equals(req.getSearchType())) {
                salesCountDayResponses = salesCountDayResponseMap.get(salesCountResponse.getShopParentSku());
            }else{
                salesCountDayResponses = salesCountDayResponseMap.get(salesCountResponse.getShopSkuId());
            }
            int total = 0;
            if(CollectionUtils.isEmpty(salesCountDayResponses)){
                setRowValue(rowData, dayColumnIndexMap.get("合计"), total);
                continue;
            }
            for (SalesCountDayResponse salesCountDayResponse :
                    salesCountDayResponses) {
                setRowValue(rowData, dayColumnIndexMap.get(salesCountDayResponse.getPurchaseDate()), salesCountDayResponse.getQuantity());
                total = total + salesCountDayResponse.getQuantity();
            }
            setRowValue(rowData, dayColumnIndexMap.get("合计"), total);
        }
    }

    private static Map<String, List<SalesCountDayResponse>> getSalesCountDayResponseMapByShopParentSku(List<SalesCountDayResponse> salesCountDayResponseList) {
        Map<String, List<SalesCountDayResponse>> salesCountDayResponseMap = new HashMap<>();
        for (SalesCountDayResponse item :
                salesCountDayResponseList) {
            List<SalesCountDayResponse> list = salesCountDayResponseMap.getOrDefault(item.getShopParentSku(), new ArrayList<>());
            list.add(item);
            salesCountDayResponseMap.put(item.getShopParentSku(), list);
        }
        return salesCountDayResponseMap;
    }

    private static Map<Integer, List<SalesCountDayResponse>> getSalesCountDayResponseMapByShopSkuId(List<SalesCountDayResponse> salesCountDayResponseList) {
        Map<Integer, List<SalesCountDayResponse>> salesCountDayResponseMap = new HashMap<>();
        for (SalesCountDayResponse item :
                salesCountDayResponseList) {
            List<SalesCountDayResponse> list = salesCountDayResponseMap.getOrDefault(item.getShopSkuId(), new ArrayList<>());
            list.add(item);
            salesCountDayResponseMap.put(item.getShopSkuId(), list);
        }
        return salesCountDayResponseMap;
    }

    private static Map<Object, List<SalesCountDayResponse>> getSalesCountDayResponseMap(List<SalesCountDayResponse> salesCountDayResponseList, String searchType) {
        Map<Object, List<SalesCountDayResponse>> salesCountDayResponseMap = new HashMap<>();
        if ("shopParentSku".equals(searchType)) {
            for (SalesCountDayResponse item :
                    salesCountDayResponseList) {
                List<SalesCountDayResponse> list = salesCountDayResponseMap.getOrDefault(item.getShopParentSku(), new ArrayList<>());
                list.add(item);
                salesCountDayResponseMap.put(item.getShopParentSku(), list);
            }
        } else {
            for (SalesCountDayResponse item :
                    salesCountDayResponseList) {
                List<SalesCountDayResponse> list = salesCountDayResponseMap.getOrDefault(item.getShopSkuId(), new ArrayList<>());
                list.add(item);
                salesCountDayResponseMap.put(item.getShopSkuId(), list);
            }
        }
        return salesCountDayResponseMap;
    }


    private static Map<String, Integer> setDayTitleAndReturnMap(SalesCountRequest req, XSSFRow row) {
        Map<String, Integer> dayColumnIndexMap = new HashMap<>();
        Date nowDay = req.getPurchaseDateStart();
        int dayColumnIndex = 5;
        while (!nowDay.after(req.getPurchaseDateEnd())) {
            String nowDayStr = DateUtil.getFormatDateStrYMD(nowDay);
            dayColumnIndexMap.put(nowDayStr, dayColumnIndex);
            setRowValue(row, dayColumnIndex, nowDayStr);
            dayColumnIndex++;
            nowDay = DateUtil.plusDay(1, nowDay);
        }
        setRowValue(row, dayColumnIndex, "合计");
        dayColumnIndexMap.put("合计", dayColumnIndex);
        return dayColumnIndexMap;
    }

    private static void setBaseRowData(XSSFRow rowData, SalesCountResponse salesCountResponse) {
        setRowValue(rowData, 0, salesCountResponse.getShopName());
        setRowValue(rowData, 1, salesCountResponse.getShopSku());
        setRowValue(rowData, 2, salesCountResponse.getShopParentSku());
        setRowValue(rowData, 3, salesCountResponse.getProductCode());
        setRowValue(rowData, 4, salesCountResponse.getProductName());
    }

    private static void setBaseTitle(XSSFRow row) {
        setRowValue(row, 0, "店铺名");
        setRowValue(row, 1, "店铺sku");
        setRowValue(row, 2, "店铺父sku");
        setRowValue(row, 3, "产品编码");
        setRowValue(row, 4, "产品名");
    }

    private static void setRowValue(XSSFRow row, int columnIndex, String value) {
        row.createCell(columnIndex).setCellValue(value);
    }

    private static void setRowValue(XSSFRow row, int columnIndex, Integer value) {
        row.createCell(columnIndex).setCellValue(value);
    }
}
