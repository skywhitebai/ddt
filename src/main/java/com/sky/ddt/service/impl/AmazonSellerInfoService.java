package com.sky.ddt.service.impl;

import com.sky.ddt.dto.amazon.response.OrderExport;
import com.sky.ddt.dto.amazon.response.SellerInfoExportAll;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.IAmazonSellerInfoService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 亚马逊销售数据统计
 *
 * @author baixueping
 * @date 2018/12/26
 */
@Service
public class AmazonSellerInfoService implements IAmazonSellerInfoService {
    @Override
    public BaseResponse countSellerInfoAll(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        if (file == null || file.isEmpty()) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        ;
        if (!ExcelUtil.isExcel(file)) {
            return BaseResponse.failMessage("文件格式错误，必须上传excel");
        }
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("文件不能为空");
        }
        Map<String, SellerInfoExportAll> orderMap = new HashMap<>();
        for (Map<String, String> map : list) {
            StringBuilder typeName = new StringBuilder();
            String transaction_type = map.get("transaction-type");
            String price_type = map.get("price-type");
            String item_related_fee_type = map.get("item-related-fee-type");
            String promotion_type = map.get("promotion-type");
            String direct_payment_type = map.get("direct-payment-type");
            typeName.append("transaction-type");
            if (!StringUtils.isEmpty(transaction_type)) {
                typeName.append(transaction_type);
            }
            typeName.append("price-type");
            if (!StringUtils.isEmpty(price_type)) {
                typeName.append(price_type);
            }
            typeName.append("item_related_fee_type");
            if (!StringUtils.isEmpty(item_related_fee_type)) {
                typeName.append(item_related_fee_type);
            }
            typeName.append("promotion_type");
            if (!StringUtils.isEmpty(promotion_type)) {
                typeName.append(promotion_type);
            }
            typeName.append("direct_payment_type");
            if (!StringUtils.isEmpty(direct_payment_type)) {
                typeName.append(direct_payment_type);
            }
            SellerInfoExportAll orderExportAll = orderMap.get(typeName.toString());
            if (orderExportAll == null) {
                orderExportAll = new SellerInfoExportAll();
                orderExportAll.setTransaction_type(transaction_type);
                orderExportAll.setPrice_type(price_type);
                orderExportAll.setItem_related_fee_type(item_related_fee_type);
                orderExportAll.setPromotion_type(promotion_type);
                orderExportAll.setDirect_payment_type(direct_payment_type);
                orderMap.put(typeName.toString(), orderExportAll);
            }
            BigDecimal amount = orderExportAll.getAmount();
            amount = MathUtil.addBigDecimal(amount, MathUtil.strToBigDecimal(map.get("price-amount")));
            amount = MathUtil.addBigDecimal(amount, MathUtil.strToBigDecimal(map.get("item-related-fee-amount")));
            amount = MathUtil.addBigDecimal(amount, MathUtil.strToBigDecimal(map.get("misc-fee-amount")));
            amount = MathUtil.addBigDecimal(amount, MathUtil.strToBigDecimal(map.get("other-fee-amount")));
            amount = MathUtil.addBigDecimal(amount, MathUtil.strToBigDecimal(map.get("promotion-amount")));
            amount = MathUtil.addBigDecimal(amount, MathUtil.strToBigDecimal(map.get("direct-payment-amount")));
            amount = MathUtil.addBigDecimal(amount, MathUtil.strToBigDecimal(map.get("other-amount")));
            orderExportAll.setAmount(amount);
        }
        List<Object> orderExportAllList = new ArrayList<>();
        for (String key : orderMap.keySet()) {
            orderExportAllList.add(orderMap.get(key));
        }
        Collections.sort(orderExportAllList, new Comparator<Object>() {
            @Override
            public int compare(Object a, Object b) {
                SellerInfoExportAll aa=(SellerInfoExportAll)a;
                SellerInfoExportAll bb=(SellerInfoExportAll)b;
                int res=aa.getTransaction_type().compareTo(bb.getTransaction_type());
                if(res!=0){
                    return  res;
                }
                res=aa.getPrice_type().compareTo(bb.getPrice_type());
                if(res!=0){
                    return  res;
                }
                res=aa.getItem_related_fee_type().compareTo(bb.getItem_related_fee_type());
                if(res!=0){
                    return  res;
                }
                res=aa.getPromotion_type().compareTo(bb.getPromotion_type());
                if(res!=0){
                    return  res;
                }
                res=aa.getDirect_payment_type().compareTo(bb.getDirect_payment_type());
                return  res;
            }
        });
        response.setContentType("application/octet-stream");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName = "销售统计信息" + sdf.format(new Date());
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");//默认Excel名称
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            ServletOutputStream out = response.getOutputStream();
            //导出数据
            String[] headers = {"transaction-type", "price-type", "item-related-fee-type", "promotion-type", "direct-payment-type", "amount"};
            BaseResponse baseResponse = exportExcel(out, headers, orderExportAllList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BaseResponse.success();
    }

    /**
     * 订单数据下载
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @Override
    public BaseResponse orderExport(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        if (file == null || file.isEmpty()) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        ;
        if (!ExcelUtil.isExcel(file)) {
            return BaseResponse.failMessage("文件格式错误，必须上传excel");
        }
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("文件不能为空");
        }
        Map<String, OrderExport> orderMap = new HashMap<>();
        for (Map<String, String> map : list) {
            String transactionType = map.get("transaction-type");
            String sku = map.get("sku");
            String quantityPurchasedStr = map.get("quantity-purchased");
            String priceType = map.get("price-type");
            BigDecimal priceAmount = null;
            Integer quantityPurchased = null;
            if ("Principal".equals(priceType)) {
                priceAmount = MathUtil.strToBigDecimal(map.get("price-amount"));
            }
            if (StringUtils.isEmpty(sku)
                    || StringUtils.isEmpty(transactionType)
                    || !transactionType.equals("Order")) {
                continue;
            }
            if (!StringUtils.isEmpty(quantityPurchasedStr)) {
                quantityPurchased = MathUtil.strToInteger(quantityPurchasedStr);
            }
            if (quantityPurchased == null && priceAmount == null) {
                continue;
            }
            OrderExport orderExport = orderMap.get(sku);
            if (orderExport == null) {
                orderExport = new OrderExport();
            }
            orderExport.setSku(sku);
            if (quantityPurchased != null) {
                orderExport.setQuantityPurchased(MathUtil.addInteger(orderExport.getQuantityPurchased(), quantityPurchased));
            }
            if (priceAmount != null) {
                orderExport.setPriceAmount(MathUtil.addBigDecimal(orderExport.getPriceAmount(), priceAmount));
            }
            orderMap.put(sku, orderExport);
        }
        List<Object> exportList = new ArrayList<>();
        for (String key : orderMap.keySet()) {
            exportList.add(orderMap.get(key));
        }
        response.setContentType("application/octet-stream");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName = "订单信息" + sdf.format(new Date());
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");//默认Excel名称
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            ServletOutputStream out = response.getOutputStream();
            //导出数据
            String[] headers = {"sku", "quantity-purchased", "price-amount"};
            BaseResponse baseResponse = exportExcel(out, headers, exportList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BaseResponse.success();
    }

    public BaseResponse exportExcel(ServletOutputStream out, String[] headers,
                                    List<Object> dataset) {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = "订单价格";
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
            Iterator<Object> it = dataset.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                Object t = (Object) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                if (fields.length != headers.length) {
                    return BaseResponse.fail();
                }
                for (short i = 0; i < headers.length; i++) {
                    XSSFCell cell = row.createCell(i);
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

                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value.getClass().equals(BigDecimal.class)
                            || value.getClass().equals(Integer.class)
                            || value.getClass().equals(Double.class)) {
                        cell.setCellValue(new Double(value.toString()));
                    } else if (value.getClass().equals(new Date().getClass())) {
                        textValue = DateUtil.getFormatDateStr((Date) value);
                    } else {
                        textValue = value.toString();
                    }
                    if (textValue != null) {
                        cell.setCellValue(textValue);
                    }
                }
            }
            workbook.write(out);
            out.flush();
            out.close();
            return BaseResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail();
        }
    }

}
