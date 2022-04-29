package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomFbaInventoryDistributionMapper;
import com.sky.ddt.dto.fbaInventoryDistribution.req.DownFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.req.ListFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.FbaInventoryDistributionExistInfo;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.FulfillmentCenterIdQuantity;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.ListFbaInventoryDistributionResp;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.SkuFulfillmentCenterIdQuantity;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.response.ShopSkuInfo;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IFbaInventoryDistributionService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sky
 * @Description fba库存分布
 * @date 2022/4/21 23:27
 */
@Service
public class FbaInventoryDistributionService implements IFbaInventoryDistributionService {
    @Autowired
    CustomFbaInventoryDistributionMapper customFbaInventoryDistributionMapper;
    @Autowired
    IShopSkuService shopSkuService;

    @Override
    public PageInfo<ListFbaInventoryDistributionResp> listFbaInventoryDistribution(ListFbaInventoryDistributionReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFbaInventoryDistributionResp> list = customFbaInventoryDistributionMapper.listFbaInventoryDistribution(params);
        PageInfo<ListFbaInventoryDistributionResp> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse importFbaInventoryDistribution(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            if (!StringUtils.isEmpty(map.get("sku")) && map.get("sku").contains("&amp;")) {
                map.put("sku", map.get("sku").replace("&amp;", "&"));
            }
        }
        Map<String, ShopSkuInfo> shopSkuMap = getShopSkuMap(list);
        Set<Date> snapshotDaySet = new HashSet<>();
        Map<String, Integer> skuInfoMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            //忽略空行
            Boolean isEmpty = true;
            for (String key : map.keySet()) {
                if (!StringUtils.isEmpty(map.get(key))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }
            StringBuilder sbErroItem = new StringBuilder();
            if (StringUtils.isEmpty(map.get("snapshot-date"))) {
                sbErroItem.append(",").append("snapshot-date不能为空");
            } else {
                if (map.get("snapshot-date").length() < 10) {
                    sbErroItem.append(",").append("snapshot-date格式错误，必须为日期");
                } else {
                    Date snapshotDay = DateUtil.strToDate(map.get("snapshot-date").substring(0, 10));
                    if (snapshotDay == null) {
                        sbErroItem.append(",").append("snapshot-date格式错误，必须为日期");
                    } else {
                        snapshotDaySet.add(snapshotDay);
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("fnsku"))) {
                sbErroItem.append(",").append("fnsku不能为空");
            }
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append("sku不能为空");
            } else if (shopSkuMap.get(map.get("sku")) == null) {
                sbErroItem.append(",").append("sku[" + map.get("sku") + "]不存在");
            }
            if (StringUtils.isEmpty(map.get("product-name"))) {
                sbErroItem.append(",").append("product-name不能为空");
            }
            if (StringUtils.isEmpty(map.get("quantity"))) {
                sbErroItem.append(",").append("quantity不能为空");
            } else {
                if (MathUtil.isNotInteger(map.get("quantity"))) {
                    sbErroItem.append(",").append("quantity必须位数字");
                }
            }
            if (StringUtils.isEmpty(map.get("fulfillment-center-id"))) {
                sbErroItem.append(",").append("fulfillment-center-id不能为空");
            }
            if (!StringUtils.isEmpty(map.get("sku"))
                    && !StringUtils.isEmpty(map.get("fulfillment-center-id"))
                    && !StringUtils.isEmpty(map.get("snapshot-date"))
                    && map.get("snapshot-date").length() >= 10) {
                String skuFullInfo = map.get("sku") + map.get("fulfillment-center-id") + map.get("detailed-disposition") + map.get("snapshot-date").substring(0, 10);
                if (skuInfoMap.containsKey(skuFullInfo)) {
                    sbErroItem.append(",").append(String.format("sku[%s]、fulfillment-center-id[%s]、detailed-disposition【%s】和第[%d]行重复", map.get("sku"), map.get("fulfillment-center-id"), map.get("detailed-disposition"), skuInfoMap.get(skuFullInfo)));
                } else {
                    skuInfoMap.put(skuFullInfo, i + 1);
                }
            }

            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        //获取历史数据
        List<FbaInventoryDistributionExistInfo> fbaInventoryDistributionExistInfoList = getFbaInventoryDistributionExistInfoList(snapshotDaySet, list);
        for (Map<String, String> map : list) {
            //忽略空行
            Boolean isEmpty = true;
            for (String key : map.keySet()) {
                if (!StringUtils.isEmpty(map.get(key))) {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                continue;
            }

            FbaInventoryDistribution fbaInventoryDistribution = new FbaInventoryDistribution();
            fbaInventoryDistribution.setSnapshotDay(DateUtil.strToDate(map.get("snapshot-date").substring(0, 10)));
            fbaInventoryDistribution.setSnapshotDate(map.get("snapshot-date"));
            fbaInventoryDistribution.setFnsku(map.get("fnsku"));
            fbaInventoryDistribution.setSku(map.get("sku"));
            fbaInventoryDistribution.setShopId(shopSkuMap.get(map.get("sku")).getShopId());
            fbaInventoryDistribution.setShopSkuId(shopSkuMap.get(map.get("sku")).getShopSkuId());
            fbaInventoryDistribution.setProductName(map.get("product-name"));
            fbaInventoryDistribution.setQuantity(MathUtil.strToInteger(map.get("quantity")));
            fbaInventoryDistribution.setFulfillmentCenterId(map.get("fulfillment-center-id"));
            fbaInventoryDistribution.setDetailedDisposition(map.get("detailed-disposition"));
            fbaInventoryDistribution.setCountry(map.get("country"));
            fbaInventoryDistribution.setId(getFbaInventoryDistributionId(fbaInventoryDistribution, fbaInventoryDistributionExistInfoList));
            if (fbaInventoryDistribution.getId() != null) {
                fbaInventoryDistribution.setUpdateBy(dealUserId);
                fbaInventoryDistribution.setUpdateTime(new Date());
                customFbaInventoryDistributionMapper.updateByPrimaryKeySelective(fbaInventoryDistribution);
            } else {
                fbaInventoryDistribution.setCreateBy(dealUserId);
                fbaInventoryDistribution.setCreateTime(new Date());
                customFbaInventoryDistributionMapper.insertSelective(fbaInventoryDistribution);
            }
        }
        return BaseResponse.success();
    }

    private Integer getFbaInventoryDistributionId(FbaInventoryDistribution fbaInventoryDistribution, List<FbaInventoryDistributionExistInfo> fbaInventoryDistributionExistInfoList) {
        if (CollectionUtils.isEmpty(fbaInventoryDistributionExistInfoList)) {
            return null;
        }
        Optional<FbaInventoryDistributionExistInfo> first = fbaInventoryDistributionExistInfoList.stream().filter(
                item -> item.getSku().equals(fbaInventoryDistribution.getSku())
                        && item.getDetailedDisposition().equals(fbaInventoryDistribution.getDetailedDisposition())
                        && item.getFulfillmentCenterId().equals(fbaInventoryDistribution.getFulfillmentCenterId())
                        && item.getSnapshotDay().equals(fbaInventoryDistribution.getSnapshotDay())).findFirst();
        if(first.isPresent()){
            return first.get().getId();
        }
        return null;
    }


    @Override
    public BaseResponse downFbaInventoryDistribution(DownFbaInventoryDistributionReq params, HttpServletResponse response) {
        if (params == null) {
            return BaseResponse.failMessage("日期不能为空");
        }
        ListFbaInventoryDistributionReq listFbaInventoryDistributionReq = buildListFbaInventoryDistributionReq(params);
        List<ListFbaInventoryDistributionResp> list = customFbaInventoryDistributionMapper.listFbaInventoryDistribution(listFbaInventoryDistributionReq);
        if (CollectionUtils.isEmpty(list)) {
            return BaseResponse.failMessage("库位分布信息不存在");
        }
        return exportFbaInventoryDistribution(list, response);
    }

    private ListFbaInventoryDistributionReq buildListFbaInventoryDistributionReq(DownFbaInventoryDistributionReq params) {
        ListFbaInventoryDistributionReq listFbaInventoryDistributionReq = new ListFbaInventoryDistributionReq();
        listFbaInventoryDistributionReq.setSnapshotDay(params.getSnapshotDay());
        listFbaInventoryDistributionReq.setShopId(params.getShopId());
        return listFbaInventoryDistributionReq;
    }

    private BaseResponse exportFbaInventoryDistribution(List<ListFbaInventoryDistributionResp> list, HttpServletResponse response) {
        //构建列数据
        Set<String> fulfillmentCenterIdSet = list.stream().map(item -> item.getFulfillmentCenterId()).collect(Collectors.toSet());
        //统计每个库位数量，按数量从多到少排序
        List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList = getFulfillmentCenterIdQuantityList(list);
        //构建sku及库位信息 Map<Sku,Map<String,Integer>> 排序 数量从多到少排序
        List<SkuFulfillmentCenterIdQuantity> skuFulfillmentCenterIdQuantityList = getSkuFulfillmentCenterIdQuantityList(list);
        //构建excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        String fileName = list.get(0).getShopName() + "-" + DateUtil.getFormatStryyyyMMdd(list.get(0).getSnapshotDay());
        String sheetName = fileName;
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        buildTitle(sheet, fulfillmentCenterIdQuantityList);
        buildContent(sheet, list, skuFulfillmentCenterIdQuantityList, fulfillmentCenterIdQuantityList);
        //导出
        return exportFbaInventoryDistribution(workbook, response, fileName);
    }

    private BaseResponse exportFbaInventoryDistribution(XSSFWorkbook workbook, HttpServletResponse response, String fileName) {
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + "-" + DateUtil.getFormatStryyyyMMddHHmmss(new Date()) + ".xlsx");//默认Excel名称
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

    private void buildContent(XSSFSheet sheet, List<ListFbaInventoryDistributionResp> list, List<SkuFulfillmentCenterIdQuantity> skuFulfillmentCenterIdQuantityList, List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList) {
        String shopName = list.get(0).getShopName();
        String snapshotDay = DateUtil.getFormatDateStrYMD(list.get(0).getSnapshotDay());
        Map<String, Integer> fulfillmentCenterIdColMap = buildFulfillmentCenterIdColMap(fulfillmentCenterIdQuantityList);
        for (int i = 0; i < skuFulfillmentCenterIdQuantityList.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(skuFulfillmentCenterIdQuantityList.get(i).getSku());
            row.createCell(1).setCellValue(shopName);
            row.createCell(2).setCellValue(snapshotDay);
            for (FulfillmentCenterIdQuantity fulfillmentCenterIdQuantity : skuFulfillmentCenterIdQuantityList.get(i).getFulfillmentCenterIdQuantityList()) {
                row.createCell(fulfillmentCenterIdColMap.get(fulfillmentCenterIdQuantity.getFulfillmentCenterId())).setCellValue(fulfillmentCenterIdQuantity.getQuantity());
            }
        }
    }

    private Map<String, Integer> buildFulfillmentCenterIdColMap(List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList) {
        Map<String, Integer> fulfillmentCenterIdColMap = new HashMap<>();
        for (int i = 0; i < fulfillmentCenterIdQuantityList.size(); i++) {
            fulfillmentCenterIdColMap.put(fulfillmentCenterIdQuantityList.get(i).getFulfillmentCenterId(), i + 3);
        }
        return fulfillmentCenterIdColMap;
    }

    private void buildTitle(XSSFSheet sheet, List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList) {
        XSSFRow row = sheet.createRow(0);
        //生成标题
        row.createCell(0).setCellValue("sku");
        row.createCell(1).setCellValue("店铺");
        row.createCell(2).setCellValue("日期");
        for (int i = 0; i < fulfillmentCenterIdQuantityList.size(); i++) {
            row.createCell(i + 3).setCellValue(fulfillmentCenterIdQuantityList.get(i).getFulfillmentCenterId());
        }
    }

    private List<SkuFulfillmentCenterIdQuantity> getSkuFulfillmentCenterIdQuantityList(List<ListFbaInventoryDistributionResp> list) {
        //先按sku分组，然后求出每组数量，然后排序返回
        Map<String, SkuFulfillmentCenterIdQuantity> map = new HashMap<>();
        for (FbaInventoryDistribution fbaInventoryDistribution :
                list) {
            SkuFulfillmentCenterIdQuantity skuFulfillmentCenterIdQuantity = map.get(fbaInventoryDistribution.getSku());
            if (skuFulfillmentCenterIdQuantity == null) {
                skuFulfillmentCenterIdQuantity = new SkuFulfillmentCenterIdQuantity();
                skuFulfillmentCenterIdQuantity.setFulfillmentCenterIdQuantityList(new ArrayList<>());
            }
            //设置总数
            skuFulfillmentCenterIdQuantity.setQuantity(MathUtil.addInteger(skuFulfillmentCenterIdQuantity.getQuantity(), fbaInventoryDistribution.getQuantity()));
            skuFulfillmentCenterIdQuantity.setSku(fbaInventoryDistribution.getSku());
            FulfillmentCenterIdQuantity fulfillmentCenterIdQuantity = getFulfillmentCenterIdQuantity(skuFulfillmentCenterIdQuantity.getFulfillmentCenterIdQuantityList(), fbaInventoryDistribution.getFulfillmentCenterId());
            if (fulfillmentCenterIdQuantity != null) {
                fulfillmentCenterIdQuantity.setQuantity(MathUtil.addInteger(fulfillmentCenterIdQuantity.getQuantity(), fbaInventoryDistribution.getQuantity()));
            } else {
                skuFulfillmentCenterIdQuantity.getFulfillmentCenterIdQuantityList().add(getFulfillmentCenterIdQuantity(fbaInventoryDistribution));
            }
            map.put(fbaInventoryDistribution.getSku(), skuFulfillmentCenterIdQuantity);
        }
        List<SkuFulfillmentCenterIdQuantity> skuFulfillmentCenterIdQuantityList = map.values().stream().sorted((a1, a2) -> {
            return a2.getQuantity() - a1.getQuantity();
        }).collect(Collectors.toList());
        return skuFulfillmentCenterIdQuantityList;
    }

    private FulfillmentCenterIdQuantity getFulfillmentCenterIdQuantity(List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList, String fulfillmentCenterId) {
        Optional<FulfillmentCenterIdQuantity> first = fulfillmentCenterIdQuantityList.stream().filter(item -> item.getFulfillmentCenterId().equals(fulfillmentCenterId)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }

    private FulfillmentCenterIdQuantity getFulfillmentCenterIdQuantity(FbaInventoryDistribution fbaInventoryDistribution) {
        FulfillmentCenterIdQuantity fulfillmentCenterIdQuantity = new FulfillmentCenterIdQuantity();
        fulfillmentCenterIdQuantity.setFulfillmentCenterId(fbaInventoryDistribution.getFulfillmentCenterId());
        fulfillmentCenterIdQuantity.setQuantity(fbaInventoryDistribution.getQuantity());
        return fulfillmentCenterIdQuantity;
    }

    private List<FulfillmentCenterIdQuantity> getFulfillmentCenterIdQuantityList(List<ListFbaInventoryDistributionResp> list) {
        Map<String, FulfillmentCenterIdQuantity> map = new HashMap<>();
        for (FbaInventoryDistribution fbaInventoryDistribution :
                list) {
            FulfillmentCenterIdQuantity fulfillmentCenterIdQuantity = map.getOrDefault(fbaInventoryDistribution.getFulfillmentCenterId(), new FulfillmentCenterIdQuantity());
            fulfillmentCenterIdQuantity.setQuantity(MathUtil.addInteger(fulfillmentCenterIdQuantity.getQuantity(), fbaInventoryDistribution.getQuantity()));
            fulfillmentCenterIdQuantity.setFulfillmentCenterId(fbaInventoryDistribution.getFulfillmentCenterId());
            map.put(fbaInventoryDistribution.getFulfillmentCenterId(), fulfillmentCenterIdQuantity);
        }
        List<FulfillmentCenterIdQuantity> fulfillmentCenterIdQuantityList = map.values().stream().sorted((a1, a2) -> {
            return a2.getQuantity() - a1.getQuantity();
        }).collect(Collectors.toList());
        return fulfillmentCenterIdQuantityList;
    }

    private List<FbaInventoryDistributionExistInfo> getFbaInventoryDistributionExistInfoList(Set<Date> snapshotDaySet, List<Map<String, String>> list) {
        List<String> shopSkuList = list.stream().map(item -> item.get("sku")).collect(Collectors.toList());
        return customFbaInventoryDistributionMapper.listFbaInventoryDistributionExist(snapshotDaySet, shopSkuList);
    }

    private Map<String, ShopSkuInfo> getShopSkuMap(List<Map<String, String>> list) {
        Map<String, ShopSkuInfo> shopSkuMap = new HashMap<>();
        List<String> shopSkuList = list.stream().map(item -> item.get("sku")).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(shopSkuList)) {
            return shopSkuMap;
        }
        shopSkuMap = shopSkuService.getShopSkuInfoMap(shopSkuList);
        return shopSkuMap;
    }
}
