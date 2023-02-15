package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sky.ddt.common.constant.ShopSkuConstant;
import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.common.constant.StockRecordConstant;
import com.sky.ddt.dao.custom.CustomShopSkuMapper;
import com.sky.ddt.dao.custom.CustomStockCartMapper;
import com.sky.ddt.dao.custom.CustomStockRemarkMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.request.*;
import com.sky.ddt.dto.stock.response.ListSendQuantityResp;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.dto.stock.response.SendQuantityDto;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IImgService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.service.IStockCartService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 备货购物车
 * @date 2019/8/21 8:48
 */
@Service
public class StockCartService implements IStockCartService {
    @Autowired
    CustomStockCartMapper customStockCartMapper;
    @Autowired
    CustomShopSkuMapper customShopSkuMapper;
    @Autowired
    IShopUserService shopUserService;
    @Autowired
    IImgService imgService;
    @Autowired
    CustomStockRemarkMapper customStockRemarkMapper;
    @Autowired
    IShopSkuService shopSkuService;

    /**
     * @param params
     * @return
     * @description 查询备货信息
     * @author baixueping
     * @date 2019/8/21 12:33
     */
    @Override
    public PageInfo<ListStockResponse> listStock(ListStockRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockResponse> list = getListStock(params);
        for (ListStockResponse listStockResponse :
                list) {
            String imgUrl = imgService.getImgUrlBySkuId(listStockResponse.getSkuId());
            if (!StringUtils.isEmpty(imgUrl)) {
                listStockResponse.setImgUrl(imgUrl);
            }
            /*Integer inventoryQuantity = shopSkuService.getSkuInventoryQuantity(skuListResponse.getSkuId());
            skuListResponse.setInventoryQuantity(inventoryQuantity);*/
        }
        PageInfo<ListStockResponse> page = new PageInfo<ListStockResponse>(list);
        return page;
    }

    private void setStockRemark(List<ListStockResponse> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<Integer> shopSkuIdList = list.stream().map(item -> MathUtil.strToInteger(item.getShopSkuId())).collect(Collectors.toList());
        List<List<Integer>> shopSkuIdListPartition = Lists.partition(shopSkuIdList, 1000);
        List<StockRemark> stockRemarkList = new ArrayList<>();
        for (List<Integer> shopSkuIdListItem : shopSkuIdListPartition) {
            StockRemarkExample example = new StockRemarkExample();
            example.createCriteria().andShopSkuIdIn(shopSkuIdListItem).andStatusEqualTo(1);
            List<StockRemark> stockRemarkListItem = customStockRemarkMapper.selectByExample(example);
            stockRemarkList.addAll(stockRemarkListItem);
        }
        for (ListStockResponse listStockResponse :
                list) {
            Optional<StockRemark> stockRemarkOptional = stockRemarkList.stream().filter(item -> item.getShopSkuId().equals(Integer.valueOf(listStockResponse.getShopSkuId()))).findFirst();
            if (stockRemarkOptional.isPresent()) {
                listStockResponse.setStockRemark(stockRemarkOptional.get().getRemark());
            } else {
                listStockResponse.setStockRemark("");
            }
        }
    }

    /**
     * 设置发送中数量
     *
     * @param list
     */
    private void setSendQuantity(List<ListStockResponse> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<Integer> shopSkuIdList = list.stream().map(item -> MathUtil.strToInteger(item.getShopSkuId())).collect(Collectors.toList());
        List<List<Integer>> shopSkuIdListPartition = Lists.partition(shopSkuIdList, 1000);
        List<SendQuantityDto> sendQuantityDtoList = new ArrayList<>();
        for (List<Integer> shopSkuIdListItem : shopSkuIdListPartition) {
            List<SendQuantityDto> sendQuantityDtoListItem = customStockCartMapper.listSendQuantity(shopSkuIdListItem, list.get(0).getShopId());
            sendQuantityDtoList.addAll(sendQuantityDtoListItem);
        }
        for (ListStockResponse listStockResponse :
                list) {
            Optional<SendQuantityDto> sendQuantityDtoOptional = sendQuantityDtoList.stream().filter(item -> item.getShopSkuId().equals(listStockResponse.getShopSkuId())).findFirst();
            if (sendQuantityDtoOptional.isPresent()) {
                listStockResponse.setSendQuantity(sendQuantityDtoOptional.get().getSendQuantity());
            } else {
                listStockResponse.setSendQuantity(0);
            }
        }
    }

    @Override
    public PageInfo<ListStockResponse> listWarehouseStock(ListStockRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockResponse> list = customStockCartMapper.listWarehouseStock(params);
        if (!CollectionUtils.isEmpty(list)) {
            List<Integer> ids = list.stream().map(ListStockResponse::getSkuId).collect(Collectors.toList());
            List<ListStockResponse> listInfo = customStockCartMapper.listWarehouseStockOtherInfo(ids);
            setOtherInfo(list, listInfo);
            setListStock(list);
            setStockRemark(list);
            for (ListStockResponse listStockResponse :
                    list) {
                String imgUrl = imgService.getImgUrlBySkuId(listStockResponse.getSkuId());
                if (!StringUtils.isEmpty(imgUrl)) {
                    listStockResponse.setImgUrl(imgUrl);
                }
            }
        }

        PageInfo<ListStockResponse> page = new PageInfo<ListStockResponse>(list);
        return page;
    }

    @Override
    public PageInfo<ListSendQuantityResp> listSendQuantity(ListSendQuntityReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListSendQuantityResp> list = customStockCartMapper.listPageSendQuantity(params);
        PageInfo<ListSendQuantityResp> page = new PageInfo<ListSendQuantityResp>(list);
        return page;
    }

    @Override
    public List<ListStockResponse> listExportStock(ListStockRequest params) {
        return getListStock(params);
    }

    @Override
    public List<ListStockResponse> listExportWarehouseStock(ListStockRequest params) {
        return getListExportWarehouseStock(params);
    }

    @Override
    public BaseResponse importStockQuantity(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
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
            if (StringUtils.isEmpty(map.get("店铺sku"))) {
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    if (!shopUserService.exisShopUser(shopSku.getShopId(), dealUserId)) {
                        sbErroItem.append(",").append(StockRecordConstant.USER_NO_SHOP_RIGHT);
                    }
                }
            }

            if (!StringUtils.isEmpty(map.get("空运补货"))) {
                if (!MathUtil.checkIntGreaterOrEqual(map.get("空运补货"), 0)) {
                    sbErroItem.append(",").append(StockRecordConstant.STOCK_QUANTITY_KY_ERROR);
                }
            }
            if (!StringUtils.isEmpty(map.get("空派补货"))) {
                if (!MathUtil.checkIntGreaterOrEqual(map.get("空派补货"), 0)) {
                    sbErroItem.append(",").append(StockRecordConstant.STOCK_QUANTITY_KP_ERROR);
                }
            }
            if (!StringUtils.isEmpty(map.get("海运补货"))) {
                if (!MathUtil.checkIntGreaterOrEqual(map.get("海运补货"), 0)) {
                    sbErroItem.append(",").append(StockRecordConstant.STOCK_QUANTITY_HY_ERROR);
                }
            }
            if (!StringUtils.isEmpty(map.get("实际生产数量"))) {
                if (!MathUtil.checkIntGreaterOrEqual(map.get("实际生产数量"), 0)) {
                    sbErroItem.append(",").append(StockRecordConstant.PRODUCTION_QUANTITY_ERROR);
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }
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
            SaveStockQuantityDto saveStockQuantityDto = new SaveStockQuantityDto();
            saveStockQuantityDto.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            saveStockQuantityDto.setStockQuantityKy(MathUtil.strToInteger(map.get("空运补货")));
            saveStockQuantityDto.setStockQuantityKp(MathUtil.strToInteger(map.get("空派补货")));
            saveStockQuantityDto.setStockQuantityHy(MathUtil.strToInteger(map.get("海运补货")));
            saveStockQuantityDeal(saveStockQuantityDto, dealUserId, false);
            SaveProductionQuantityRequest saveProductionQuantityRequest = new SaveProductionQuantityRequest();
            saveProductionQuantityRequest.setProductionQuantity(MathUtil.strToInteger(map.get("实际生产数量")));
            saveProductionQuantityRequest.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            saveProductionQuantityDeal(saveProductionQuantityRequest, dealUserId, false);
        }
        return BaseResponse.success();
    }

    private BaseResponse saveProductionQuantityDeal(SaveProductionQuantityRequest params, Integer currentUserId, boolean checkUserRight) {
        ShopSku shopSku = customShopSkuMapper.selectByPrimaryKey(params.getShopSkuId());
        if (shopSku == null) {
            return BaseResponse.failMessage(StockConsatnt.SHOP_SKU_ID_NOT_EXIST);
        }
        if (checkUserRight && !shopUserService.exisShopUser(shopSku.getShopId(), currentUserId)) {
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        StockCart stockCart = getStockCartByShopSkuId(params.getShopSkuId(), StockConsatnt.TypeEnum.FACTORY_PRODUCTION.getType());
        if (stockCart == null) {
            if (params.getProductionQuantity() == 0) {
                return BaseResponse.success();
            }
            stockCart = new StockCart();
            stockCart.setCreateBy(currentUserId);
            stockCart.setCreateTime(new Date());
            stockCart.setType(StockConsatnt.TypeEnum.FACTORY_PRODUCTION.getType());
            stockCart.setShopId(shopSku.getShopId());
            stockCart.setShopSkuId(params.getShopSkuId());
            stockCart.setProductionQuantity(params.getProductionQuantity());
            customStockCartMapper.insertSelective(stockCart);
        } else {
            stockCart.setUpdateBy(currentUserId);
            stockCart.setUpdateTime(new Date());
            stockCart.setProductionQuantity(params.getProductionQuantity());
            if (stockCart.getProductionQuantity() == 0) {
                customStockCartMapper.deleteByPrimaryKey(stockCart.getId());
            } else {
                customStockCartMapper.updateByPrimaryKeySelective(stockCart);
            }
        }
        return BaseResponse.success();
    }

    private BaseResponse saveStockQuantityDeal(SaveStockQuantityDto saveStockQuantityDto, Integer currentUserId, boolean checkUserRight) {
        Boolean checkStatus = false;
        if (saveStockQuantityDto.getStockQuantityKy() != null) {
            checkStatus = true;
        }
        if (saveStockQuantityDto.getStockQuantityKp() != null) {
            checkStatus = true;
        }
        if (saveStockQuantityDto.getStockQuantityHy() != null) {
            checkStatus = true;
        }
        if (!checkStatus) {
            return BaseResponse.success();
        }
        ShopSku shopSku = customShopSkuMapper.selectByPrimaryKey(saveStockQuantityDto.getShopSkuId());
        if (shopSku == null) {
            return BaseResponse.failMessage(StockConsatnt.SHOP_SKU_ID_NOT_EXIST);
        }
        if (checkUserRight && !shopUserService.exisShopUser(shopSku.getShopId(), currentUserId)) {
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        StockCart stockCart = getStockCartByShopSkuId(saveStockQuantityDto.getShopSkuId(), StockConsatnt.TypeEnum.REPLENISHMENT.getType());
        if (stockCart == null) {
            stockCart = new StockCart();
            Integer stockQuantity = 0;
            if (saveStockQuantityDto.getStockQuantityKy() != null) {
                stockCart.setStockQuantityKy(saveStockQuantityDto.getStockQuantityKy());
                stockQuantity += saveStockQuantityDto.getStockQuantityKy();
            }
            if (saveStockQuantityDto.getStockQuantityKp() != null) {
                stockQuantity += saveStockQuantityDto.getStockQuantityKp();
                stockCart.setStockQuantityKp(saveStockQuantityDto.getStockQuantityKp());
            }
            if (saveStockQuantityDto.getStockQuantityHy() != null) {
                stockQuantity += saveStockQuantityDto.getStockQuantityHy();
                stockCart.setStockQuantityHy(saveStockQuantityDto.getStockQuantityHy());
            }
            stockCart.setCreateBy(currentUserId);
            stockCart.setType(StockConsatnt.TypeEnum.REPLENISHMENT.getType());
            stockCart.setCreateTime(new Date());
            stockCart.setShopId(shopSku.getShopId());
            stockCart.setShopSkuId(saveStockQuantityDto.getShopSkuId());
            stockCart.setStockQuantity(stockQuantity);
            customStockCartMapper.insertSelective(stockCart);
        } else {
            stockCart.setUpdateBy(currentUserId);
            stockCart.setUpdateTime(new Date());
            if (saveStockQuantityDto.getStockQuantityKy() != null) {
                stockCart.setStockQuantityKy(saveStockQuantityDto.getStockQuantityKy());
            }
            if (saveStockQuantityDto.getStockQuantityKp() != null) {
                stockCart.setStockQuantityKp(saveStockQuantityDto.getStockQuantityKp());
            }
            if (saveStockQuantityDto.getStockQuantityHy() != null) {
                stockCart.setStockQuantityHy(saveStockQuantityDto.getStockQuantityHy());
            }
            stockCart.setStockQuantity(stockCart.getStockQuantityKy() + stockCart.getStockQuantityKp() + stockCart.getStockQuantityHy());
            if (stockCart.getStockQuantity() == 0) {
                customStockCartMapper.deleteByPrimaryKey(stockCart.getId());
            } else {
                customStockCartMapper.updateByPrimaryKeySelective(stockCart);
            }
        }
        return BaseResponse.success();
    }


    private List<ListStockResponse> getListExportWarehouseStock(ListStockRequest params) {
        List<ListStockResponse> list = customStockCartMapper.listWarehouseStock(params);
        if (!CollectionUtils.isEmpty(list)) {
            List<Integer> ids = list.stream().map(ListStockResponse::getSkuId).collect(Collectors.toList());
            List<ListStockResponse> listInfo = customStockCartMapper.listWarehouseStockOtherInfo(ids);
            setOtherInfo(list, listInfo);
            setListStock(list);
            setStockRemark(list);
        }
        return list;
    }

    List<ListStockResponse> getListStock(ListStockRequest params) {
        List<ListStockResponse> list = customStockCartMapper.listStock(params);
        setListStock(list);
        setSendQuantity(list);
        setStockRemark(list);
        return list;
    }

    private void setOtherInfo(List<ListStockResponse> list, List<ListStockResponse> listInfo) {
        for (ListStockResponse listStockResponse :
                list) {
            Optional<ListStockResponse> infoFirst = listInfo.stream().filter(item -> item.getSkuId().equals(listStockResponse.getSkuId())).findFirst();
            if (infoFirst.isPresent()) {
                ListStockResponse info = infoFirst.get();
                listStockResponse.setAfnFulfillableQuantity(info.getAfnFulfillableQuantity());
                listStockResponse.setOnTheWayQuantity(info.getOnTheWayQuantity());
                listStockResponse.setAfnReservedQuantity(info.getAfnReservedQuantity());
                listStockResponse.setAfnInboundWorkingQuantity(info.getAfnInboundWorkingQuantity());
                listStockResponse.setAfnInboundShippedQuantity(info.getAfnInboundShippedQuantity());
                listStockResponse.setAfnInboundReceivingQuantity(info.getAfnInboundReceivingQuantity());
                listStockResponse.setFbaTotalCanSaleQuantity(info.getFbaTotalCanSaleQuantity());
                listStockResponse.setSaleShopNames(info.getSaleShopNames());
                listStockResponse.setSalesForTheLast7Days(info.getSalesForTheLast7Days());
                listStockResponse.setSalesForTheLast14Days(info.getSalesForTheLast14Days());
                listStockResponse.setSalesForTheLast21Days(info.getSalesForTheLast21Days());
                listStockResponse.setSalesForTheLast28Days(info.getSalesForTheLast28Days());
                listStockResponse.setSalesForTheLast35Days(info.getSalesForTheLast35Days());
                listStockResponse.setSalesForTheLastYear30Days(info.getSalesForTheLastYear30Days());
                listStockResponse.setSalesForTheLastYear60Days(info.getSalesForTheLastYear60Days());
                listStockResponse.setSalesForTheLastYear90Days(info.getSalesForTheLastYear90Days());
                listStockResponse.setSalesForTheLastYear120Days(info.getSalesForTheLastYear120Days());
                listStockResponse.setSalesForTheLastYear180Days(info.getSalesForTheLastYear180Days());
                listStockResponse.setSalesForTheLastYear365Days(info.getSalesForTheLastYear365Days());

                listStockResponse.setItemPrice30(info.getItemPrice30());
            } else {
                listStockResponse.setAfnFulfillableQuantity(0);
                listStockResponse.setOnTheWayQuantity(0);
                listStockResponse.setAfnReservedQuantity(0);
                listStockResponse.setAfnInboundWorkingQuantity(0);
                listStockResponse.setAfnInboundShippedQuantity(0);
                listStockResponse.setAfnInboundReceivingQuantity(0);
                listStockResponse.setFbaTotalCanSaleQuantity(0);

                listStockResponse.setSalesForTheLast7Days(0);
                listStockResponse.setSalesForTheLast14Days(0);
                listStockResponse.setSalesForTheLast21Days(0);
                listStockResponse.setSalesForTheLast28Days(0);
                listStockResponse.setSalesForTheLast35Days(0);
                listStockResponse.setSalesForTheLastYear30Days(0);
                listStockResponse.setSalesForTheLastYear60Days(0);
                listStockResponse.setSalesForTheLastYear90Days(0);
                listStockResponse.setSalesForTheLastYear120Days(0);
                listStockResponse.setSalesForTheLastYear180Days(0);
                listStockResponse.setSalesForTheLastYear365Days(0);
                listStockResponse.setItemPrice30(BigDecimal.ZERO);
            }
        }
    }

    /**
     * @param params
     * @param currentUserId
     * @return
     * @description 保存补货数据
     * @author baixueping
     * @date 2019/8/22 14:58
     */
    @Override
    public BaseResponse saveStockQuantity(SaveStockQuantityRequest params, Integer currentUserId) {
        if (!StockConsatnt.StockQuantityTypeEnum.KY.getType().equals(params.getType())
                && !StockConsatnt.StockQuantityTypeEnum.KP.getType().equals(params.getType())
                && !StockConsatnt.StockQuantityTypeEnum.HY.getType().equals(params.getType())) {
            return BaseResponse.failMessage(StockConsatnt.TYPE_EERO);
        }
        SaveStockQuantityDto saveStockQuantityDto = new SaveStockQuantityDto();
        saveStockQuantityDto.setShopSkuId(params.getShopSkuId());
        if (StockConsatnt.StockQuantityTypeEnum.KY.getType().equals(params.getType())) {
            saveStockQuantityDto.setStockQuantityKy(params.getStockQuantity());
        } else if (StockConsatnt.StockQuantityTypeEnum.KP.getType().equals(params.getType())) {
            saveStockQuantityDto.setStockQuantityKp(params.getStockQuantity());
        } else if (StockConsatnt.StockQuantityTypeEnum.HY.getType().equals(params.getType())) {
            saveStockQuantityDto.setStockQuantityHy(params.getStockQuantity());
        }
        return saveStockQuantityDeal(saveStockQuantityDto, currentUserId, true);
    }

    /**
     * @param params
     * @param currentUserId
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2019/9/3 10:36
     */
    @Override
    public BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer currentUserId) {
        return saveProductionQuantityDeal(params, currentUserId, true);
    }


    private StockCart getStockCartByShopSkuId(Integer shopSkuId, Integer type) {
        StockCartExample example = new StockCartExample();
        example.createCriteria().andShopSkuIdEqualTo(shopSkuId).andTypeEqualTo(type);
        List<StockCart> list = customStockCartMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public void setListStock(List<ListStockResponse> listStock) {
        if (CollectionUtils.isEmpty(listStock)) {
            return;
        }
        for (ListStockResponse listStockResponse : listStock) {
            Double estimateAverageDailySales = MathUtil.setScale((listStockResponse.getSalesForTheLast7Days() / 7.00
                    + listStockResponse.getSalesForTheLast14Days() / 14.00
                    + listStockResponse.getSalesForTheLast21Days() / 21.00
                    + listStockResponse.getSalesForTheLast28Days() / 28.00
                    + listStockResponse.getSalesForTheLast35Days() / 35.00) / 5, 2);
            listStockResponse.setEstimateAverageDailySales(estimateAverageDailySales);
            Integer estimateSales14Days = MathUtil.setScale(estimateAverageDailySales * 14, 0).intValue();
            Integer estimateSales28Days = MathUtil.setScale(estimateAverageDailySales * 28, 0).intValue();
            Integer estimateSales42Days = MathUtil.setScale(estimateAverageDailySales * 42, 0).intValue();
            Integer estimateSales56Days = MathUtil.setScale(estimateAverageDailySales * 56, 0).intValue();
            Integer estimateSales90Days = MathUtil.setScale(estimateAverageDailySales * 90, 0).intValue();
            listStockResponse.setEstimateSales14Days(estimateSales14Days);
            listStockResponse.setEstimateSales28Days(estimateSales28Days);
            listStockResponse.setEstimateSales42Days(estimateSales42Days);
            listStockResponse.setEstimateSales56Days(estimateSales56Days);
            listStockResponse.setEstimateSales90Days(estimateSales90Days);
            listStockResponse.setEstimateCanSaleDay(getCanSaleDay(listStockResponse.getFbaTotalCanSaleQuantity(), estimateAverageDailySales));
            Integer replenishQuantity28Days = estimateSales28Days - listStockResponse.getFbaTotalCanSaleQuantity();
            Integer replenishQuantity42Days = estimateSales42Days - listStockResponse.getFbaTotalCanSaleQuantity();
            Integer replenishQuantity56Days = estimateSales56Days - listStockResponse.getFbaTotalCanSaleQuantity();
            Integer replenishQuantity90Days = estimateSales90Days - listStockResponse.getFbaTotalCanSaleQuantity();
            //建议生产数量=去年60天销量-本地仓库-fba总可售库存
            Integer recommendedProductionQuantity60Days = MathUtil.subtractInteger(MathUtil.subtractInteger(MathUtil.subtractInteger(listStockResponse.getSalesForTheLastYear60Days(), listStockResponse.getInventoryQuantity()), listStockResponse.getInventoryQuantityWarehouse()), listStockResponse.getFbaTotalCanSaleQuantity());
            listStockResponse.setRecommendedProductionQuantity60Days(recommendedProductionQuantity60Days);
            listStockResponse.setReplenishQuantity28Days(replenishQuantity28Days);
            listStockResponse.setReplenishQuantity42Days(replenishQuantity42Days);
            listStockResponse.setReplenishQuantity56Days(replenishQuantity56Days);
            listStockResponse.setReplenishQuantity90Days(replenishQuantity90Days);
            listStockResponse.setAbleCanSaleDay(getCanSaleDay(listStockResponse.getAfnFulfillableQuantity(), estimateAverageDailySales));
            listStockResponse.setOnTheWayQuantityCanSaleDay(getCanSaleDay(listStockResponse.getOnTheWayQuantity(), estimateAverageDailySales));
            listStockResponse.setStockQuantityCanSaleDay(getCanSaleDay(listStockResponse.getStockQuantity(), estimateAverageDailySales));
            listStockResponse.setEstimateProductionQuantity(listStockResponse.getStockQuantity() - listStockResponse.getInventoryQuantity());
            listStockResponse.setInventoryQuantityTotal(MathUtil.add(MathUtil.add(listStockResponse.getInventoryQuantity(), listStockResponse.getInventoryQuantityOtherShop()), listStockResponse.getInventoryQuantityWarehouse()));
            listStockResponse.setProduceOrderShopSkuProductionQuantityTotal(MathUtil.add(MathUtil.add(listStockResponse.getProduceOrderShopSkuProductionQuantity(), listStockResponse.getProduceOrderShopSkuProductionQuantityOtherShop()), listStockResponse.getProduceOrderShopSkuProductionQuantityWarehouse()));
        }
    }

    /**
     * @param
     * @return
     * @description 获取可以销售天数
     * @author baixueping
     * @date 2019/8/27 9:52
     */
    Double getCanSaleDay(Integer quantity, Double estimateAverageDailySales) {
        Double canSaleDay = null;
        if (estimateAverageDailySales == 0) {
            if (quantity > 0) {
                canSaleDay = 365.00;
            } else {
                canSaleDay = 0.00;
            }
        } else {
            canSaleDay = MathUtil.setScale((quantity / estimateAverageDailySales), 2);
        }
        return canSaleDay;
    }
}
