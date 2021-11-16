package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProduceOrderConstant;
import com.sky.ddt.common.constant.ProduceOrderShopSkuConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.dao.custom.CustomProduceOrderMapper;
import com.sky.ddt.dao.custom.CustomProduceOrderShopSkuMapper;
import com.sky.ddt.dto.factoryProductionOrderShopSku.response.ListFactoryProductionOrderShopSkuResponse;
import com.sky.ddt.dto.produceOrder.request.*;
import com.sky.ddt.dto.produceOrder.response.ListProduceOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.*;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 生产单服务
 * @date 2020/3/25 11:21
 */
@Service
public class ProduceOrderService implements IProduceOrderService {
    @Autowired
    CustomProduceOrderMapper customProduceOrderMapper;
    @Autowired
    IProduceOrderShopSkuService produceOrderShopSkuService;
    @Autowired
    IShopService shopService;
    @Autowired
    IWarehousingOrderService warehousingOrderService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    CustomProduceOrderShopSkuMapper customProduceOrderShopSkuMapper;
    @Autowired
    IFactoryProductionOrderShopSkuService factoryProductionOrderShopSkuService;

    /**
     * @param listProduceOrderRequest@return
     * @description 分页查询生产单
     * @author baixueping
     * @date 2020/3/27 11:10
     */
    @Override
    public PageInfo<ListProduceOrderResponse> listProduceOrder(ListProduceOrderRequest listProduceOrderRequest) {
        PageHelper.startPage(listProduceOrderRequest.getPage(), listProduceOrderRequest.getRows(), true);
        List<ListProduceOrderResponse> list = customProduceOrderMapper.listProduceOrder(listProduceOrderRequest);
        if (!CollectionUtils.isEmpty(list)) {
            for (ListProduceOrderResponse listProduceOrderResponse : list) {
                listProduceOrderResponse.setStatusName(ProduceOrderConstant.StatusEnum.getStatusName(listProduceOrderResponse.getStatus()));
            }
        }
        PageInfo<ListProduceOrderResponse> page = new PageInfo<ListProduceOrderResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存生产单基本信息
     * @author baixueping
     * @date 2020/3/30 16:23
     */
    @Override
    public BaseResponse saveProduceOrder(SaveProduceOrderRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        //如果是更新，则判断id是否存在
        if (params.getId() != null) {
            ProduceOrder produceOrder = getProduceOrderById(params.getId());
            if (produceOrder == null) {
                sbErroEntity.append(ProduceOrderConstant.ID_NOT_EXIST);
            } else {
                //判断是否修改了店铺id
                if (!produceOrder.getShopId().equals(params.getShopId())) {
                    if (produceOrderShopSkuService.existProduceOrderShopSku(params.getId())) {
                        sbErroEntity.append(ProduceOrderConstant.NOT_ALLOW_CHANGE_SHOP_ID);
                    }
                }
            }
        }
        //判断店铺id是否存在
        if (params.getShopId() != null) {
            Shop shop = shopService.getShop(params.getShopId());
            if (shop == null) {
                sbErroEntity.append(ProduceOrderConstant.SHOP_ID_NOT_EXIST);
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        ProduceOrder produceOrder = new ProduceOrder();
        BeanUtils.copyProperties(params, produceOrder);
        if (params.getId() == null) {
            produceOrder.setBatchNumber(getBatchNumber());
            produceOrder.setProductionTime(new Date());
            produceOrder.setStatus(ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus());
            produceOrder.setType(ProduceOrderConstant.TypeEnum.MANUAL.getType());
            produceOrder.setCostStatus(ProduceOrderConstant.CostStatusEnum.NOT_CALCULATED.getStatus());
            produceOrder.setCreateBy(dealUserId);
            produceOrder.setCreateTime(new Date());
            customProduceOrderMapper.insertSelective(produceOrder);
        } else {
            produceOrder.setUpdateBy(dealUserId);
            produceOrder.setUpdateTime(new Date());
            customProduceOrderMapper.updateByPrimaryKeySelective(produceOrder);
        }
        return BaseResponse.success();
    }

    private String getBatchNumber() {
        String batchNumberFirst = "SCD" + DateUtil.getFormatStryyyyMMdd(new Date());
        ProduceOrderExample produceOrderExample = new ProduceOrderExample();
        produceOrderExample.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customProduceOrderMapper.countByExample(produceOrderExample);
        String batchNumber = "";
        do {
            count++;
            if (count >= 10) {
                batchNumber = batchNumberFirst + count.toString();
            } else {
                batchNumber = batchNumberFirst + "0" + count.toString();
            }
        }
        while (existBatchNumber(batchNumber));
        return batchNumber;
    }

    private boolean existBatchNumber(String batchNumber) {
        ProduceOrderExample produceOrderExample = new ProduceOrderExample();
        produceOrderExample.createCriteria().andBatchNumberEqualTo(batchNumber);
        return customProduceOrderMapper.countByExample(produceOrderExample) > 0;
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 作废生产单
     * @author baixueping
     * @date 2020/4/1 10:35
     */
    @Override
    public BaseResponse cancelProduceOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(ProduceOrderConstant.ID_EMPTY);
        }
        ProduceOrder produceOrder = getProduceOrderById(id);
        if (produceOrder == null) {
            return BaseResponse.failMessage(ProduceOrderConstant.ID_NOT_EXIST);
        }
        if (!ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(produceOrder.getStatus())) {
            return BaseResponse.failMessage(ProduceOrderConstant.NOT_ALLOW_CANCEL);
        }
        ProduceOrder produceOrderCancel = new ProduceOrder();
        produceOrderCancel.setId(id);
        produceOrderCancel.setStatus(ProduceOrderConstant.StatusEnum.CANCEL.getStatus());
        customProduceOrderMapper.updateByPrimaryKeySelective(produceOrderCancel);
        return BaseResponse.success();
    }

    @Override
    public ProduceOrder getProduceOrderById(Integer id) {
        if (id == null) {
            return null;
        }
        return customProduceOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * @param batchNumber@return
     * @description 根据批次号获取生产单
     * @author baixueping
     * @date 2020/4/17 17:29
     */
    @Override
    public ProduceOrder getProduceOrderByBatchNumber(String batchNumber) {
        if (StringUtils.isEmpty(batchNumber)) {
            return null;
        }
        ProduceOrderExample produceOrderExample = new ProduceOrderExample();
        produceOrderExample.createCriteria().andBatchNumberEqualTo(batchNumber);
        List<ProduceOrder> list = customProduceOrderMapper.selectByExample(produceOrderExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    /**
     * @param produceOrderId
     * @param dealUserId
     * @return
     * @description 修改生产单为部分入库 要做好前置校验
     * @author baixueping
     * @date 2020/5/8 10:38
     */
    @Override
    public void updateProduceOrderPartialStorage(Integer produceOrderId, Integer dealUserId) {
        ProduceOrder produceOrder = new ProduceOrder();
        produceOrder.setId(produceOrderId);
        produceOrder.setUpdateBy(dealUserId);
        produceOrder.setUpdateTime(new Date());
        produceOrder.setStatus(ProduceOrderConstant.StatusEnum.PARTIAL_STORAGE.getStatus());
        customProduceOrderMapper.updateByPrimaryKeySelective(produceOrder);
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 设置生产单为生产完毕
     * @author baixueping
     * @date 2020/5/8 15:29
     */
    @Override
    public BaseResponse finishedProduction(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(ProduceOrderConstant.ID_EMPTY);
        }
        ProduceOrder produceOrder = getProduceOrderById(id);
        if (produceOrder == null) {
            return BaseResponse.failMessage(ProduceOrderConstant.ID_NOT_EXIST);
        }
        if (!ProduceOrderConstant.StatusEnum.PARTIAL_STORAGE.getStatus().equals(produceOrder.getStatus())) {
            return BaseResponse.failMessage(ProduceOrderConstant.ONLY_PARTIAL_STORAGE_ALLOW_FINISHED_PRODUCTION);
        }
        //查询是否有待入库的入库单，如果有则不允许生产完毕
        if (warehousingOrderService.existPendingStoragewarehousingOrder(id)) {
            return BaseResponse.failMessage(ProduceOrderConstant.EXIST_PENDING_STORAGE_WAREHOUSING_ORDER_NOT_ALLOW_FINISHED_PRODUCTION);
        }
        ProduceOrder produceOrderUpdate = new ProduceOrder();
        produceOrderUpdate.setId(id);
        produceOrderUpdate.setStatus(ProduceOrderConstant.StatusEnum.FINISHED_PRODUCTION.getStatus());
        produceOrderUpdate.setCompletionTime(new Date());
        produceOrderUpdate.setUpdateTime(new Date());
        produceOrderUpdate.setUpdateBy(dealUserId);
        customProduceOrderMapper.updateByPrimaryKeySelective(produceOrderUpdate);
        return BaseResponse.success();
    }

    /**
     * @param file
     * @param dealUserId
     * @return
     * @description 导入生产单
     * @author baixueping
     * @date 2020/7/9 10:53
     */
    @Override
    public BaseResponse importProduceOrder(MultipartFile file, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        Integer shopId = null;
        SbErroEntity sbErro = new SbErroEntity(";");
        Integer emptyCount = 0;
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            if (map.containsKey("isEmpty")) {
                emptyCount++;
                continue;
            }
            SbErroEntity sbErroItem = new SbErroEntity();
            String shopSkuStr = map.get("店铺sku");
            if (StringUtils.isEmpty(shopSkuStr)) {
                sbErroItem.append(ProduceOrderShopSkuConstant.SHOP_SKU_EMPTY);
            } else if (repeatShopSku(shopSkuStr, list)) {
                sbErroItem.append(ProduceOrderShopSkuConstant.SHOP_SKU_REPEAT);
            } else {
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(shopSkuStr);
                if (shopSku == null) {
                    sbErroItem.append(ProduceOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    if (shopId == null) {
                        shopId = shopSku.getShopId();
                    } else if (!shopId.equals(shopSku.getShopId())) {
                        sbErroItem.append(ProduceOrderShopSkuConstant.SHOP_SKU_SHOP_ID_NOT_SAME);
                    }
                }
            }
            String productionQuantityStr = map.get("生产数量");
            if (StringUtils.isEmpty(productionQuantityStr)) {
                sbErroItem.append(ProduceOrderShopSkuConstant.PRODUCTION_QUANTITY_EMPTY);
            } else {
                Integer productionQuantity = MathUtil.strToInteger(productionQuantityStr);
                if (productionQuantity == null || productionQuantity <= 0) {
                    sbErroItem.append(ProduceOrderShopSkuConstant.PRODUCTION_QUANTITY_ERRO);
                }
            }
            String remark = map.get("备注");
            if (!StringUtils.isEmpty(remark) && remark.length() > ProduceOrderShopSkuConstant.REMARK_LENGTH) {
                sbErroItem.append(ProduceOrderShopSkuConstant.REMARK_TOO_LONG);
            }
            if (sbErroItem.isFail()) {
                sbErro.append("第" + (i + 2) + "行：" + sbErroItem.getMessage());
            }
        }
        if (sbErro.isFail()) {
            return sbErro.getResponse();
        }
        if (list.size() == emptyCount) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //添加生产单
        ProduceOrder produceOrder = new ProduceOrder();
        produceOrder.setBatchNumber(getBatchNumber());
        produceOrder.setProductionTime(new Date());
        produceOrder.setStatus(ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus());
        produceOrder.setCreateBy(dealUserId);
        produceOrder.setCreateTime(new Date());
        produceOrder.setShopId(shopId);
        customProduceOrderMapper.insertSelective(produceOrder);
        //添加生产单店铺sku
        for (Map<String, String> map :
                list) {
            ProduceOrderShopSku produceOrderShopSku = new ProduceOrderShopSku();
            produceOrderShopSku.setProduceOrderId(produceOrder.getId());
            produceOrderShopSku.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            produceOrderShopSku.setProductionQuantity(MathUtil.strToInteger(map.get("生产数量")));
            produceOrderShopSku.setRemark(map.get("备注"));
            produceOrderShopSku.setCreateTime(new Date());
            produceOrderShopSku.setCreateBy(dealUserId);
            customProduceOrderShopSkuMapper.insertSelective(produceOrderShopSku);
        }
        return BaseResponse.success();
    }

    /**
     * @param factoryProductionOrder
     * @param dealUserId             @return
     * @description 通过工厂生产单创建生产单
     * @author baixueping
     * @date 2020/11/2 9:16
     */
    @Override
    public void createProduceOrder(FactoryProductionOrder factoryProductionOrder, Integer dealUserId) {
        List<ListFactoryProductionOrderShopSkuResponse> list = factoryProductionOrderShopSkuService.listFactoryProductionOrderShopSku(factoryProductionOrder.getId());
        Map<String, List<ListFactoryProductionOrderShopSkuResponse>> collect = list.stream()
                .collect(Collectors.groupingBy(ListFactoryProductionOrderShopSkuResponse::getShopParentSku));
        collect.forEach((key, value) -> {
            createProduceOrder(factoryProductionOrder, value, dealUserId);
        });
    }

    @Override
    public BaseResponse saveProduceOrderCostRemark(SaveProduceOrderCostRemarkRequest params) {
        ProduceOrder produceOrder = customProduceOrderMapper.selectByPrimaryKey(params.getId());
        if (produceOrder == null) {
            return BaseResponse.failMessage("id不存在");
        }
        if (ProduceOrderConstant.CostStatusEnum.CALCULATED.getStatus().equals(produceOrder.getCostStatus())) {
            return BaseResponse.failMessage("成本已核算不允许修改");
        }
        ProduceOrder produceOrderNew = new ProduceOrder();
        produceOrderNew.setId(params.getId());
        produceOrderNew.setCostRemark(params.getCostRemark());
        produceOrderNew.setUpdateTime(new Date());
        customProduceOrderMapper.updateByPrimaryKeySelective(produceOrderNew);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse saveFabricCost(SaveProduceOrderFabricCostRequest params) {
        ProduceOrder produceOrder = customProduceOrderMapper.selectByPrimaryKey(params.getId());
        if (produceOrder == null) {
            return BaseResponse.failMessage("id不存在");
        }
        if (ProduceOrderConstant.CostStatusEnum.CALCULATED.getStatus().equals(produceOrder.getCostStatus())) {
            return BaseResponse.failMessage("成本已核算不允许修改");
        }
        ProduceOrder produceOrderNew = new ProduceOrder();
        produceOrderNew.setId(params.getId());
        produceOrderNew.setFabricCost(params.getFabricCost());
        produceOrderNew.setUpdateTime(new Date());
        customProduceOrderMapper.updateByPrimaryKeySelective(produceOrderNew);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse saveAuxiliaryMaterialCost(SaveProduceOrderAuxiliaryMaterialCostRequest params) {
        ProduceOrder produceOrder = customProduceOrderMapper.selectByPrimaryKey(params.getId());
        if (produceOrder == null) {
            return BaseResponse.failMessage("id不存在");
        }
        if (ProduceOrderConstant.CostStatusEnum.CALCULATED.getStatus().equals(produceOrder.getCostStatus())) {
            return BaseResponse.failMessage("成本已核算不允许修改");
        }
        ProduceOrder produceOrderNew = new ProduceOrder();
        produceOrderNew.setId(params.getId());
        produceOrderNew.setAuxiliaryMaterialCost(params.getAuxiliaryMaterialCost());
        produceOrderNew.setUpdateTime(new Date());
        customProduceOrderMapper.updateByPrimaryKeySelective(produceOrderNew);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse generationCost(GenerationCostRequest params) {
        //校验参数
        if (!StringUtils.isEmpty(params.getMonth())) {
            String monthStr = params.getMonth() + "-01";
            Date monthDate = DateUtil.strToDate(monthStr);
            if (monthDate != null) {
                params.setMonthDate(monthDate);
            } else {
                return BaseResponse.failMessage("月份错误");
            }
        }
        //校验当月已完成未核算生产单是否有未填写成本的
        List<ProduceOrder> notCostProduceOrderList = customProduceOrderMapper.listNotCostProductOrder(params);
        if (!CollectionUtils.isEmpty(notCostProduceOrderList)) {
            String produceOrderBatchNumberS = notCostProduceOrderList.stream().map(item -> item.getBatchNumber()).collect(Collectors.joining(","));
            return BaseResponse.failMessage("存在没有布料成本的生产单:" + produceOrderBatchNumberS);
        }
        //校验需要生成的产品sku是否有成本大于等于999的或者没有工价的
        List<String> notCostSkuList = customProduceOrderMapper.listNotCostSku(params);
        if (!CollectionUtils.isEmpty(notCostSkuList)) {
            String skus = notCostSkuList.stream().collect(Collectors.joining(","));
            return BaseResponse.failMessage("产品sku成本价错误:" + skus);
        }
        List<String> notLabourCostProductList = customProduceOrderMapper.listNotLabourCostProduct(params);
        if (!CollectionUtils.isEmpty(notLabourCostProductList)) {
            String productCodes = notLabourCostProductList.stream().collect(Collectors.joining(","));
            return BaseResponse.failMessage("产品工价不存在:" + productCodes);
        }
        //查询当月已完成未核算生产单
        List<ProduceOrder> produceOrders = getGenerationProduceOrders(params);
        if (CollectionUtils.isEmpty(produceOrders)) {
            return BaseResponse.failMessage("没有未核算的生产单");
        }
        //查询当月生产单和产品sku数量对照关系
        List<ProduceOrderSkuInfo> produceOrderSkuInfos=customProduceOrderMapper.listProduceOrderSkuInfo(params);
        //查询当月已完成未核算生产单对应的产品sku
        List<SkuCostPriceInfo> skuCostPriceInfos =customProduceOrderMapper.listSkuCostPriceInfo(params);
        //计算每个sku对应的成本价
        Map<Integer, GenerationCostInfo> map = new HashMap<>();
        for (ProduceOrder produceOrder :
                produceOrders) {
            List<ProduceOrderSkuInfo> produceOrderShopSkuList = produceOrderSkuInfos.stream().filter(item -> item.getProduceOrderId().equals(produceOrder.getId())).collect(Collectors.toList());

            //BigDecimal
        }
        return null;
    }

    private List<ProduceOrderShopSku> getGenerationProduceOrderShopSkus(List<Integer> produceOrderIds) {
        ProduceOrderShopSkuExample example = new ProduceOrderShopSkuExample();
        example.createCriteria().andProduceOrderIdIn(produceOrderIds);
        return customProduceOrderShopSkuMapper.selectByExample(example);
    }

    private List<ProduceOrder> getGenerationProduceOrders(GenerationCostRequest params) {
        ProduceOrderExample produceOrderExample = new ProduceOrderExample();
        produceOrderExample.createCriteria().andStatusEqualTo(ProduceOrderConstant.StatusEnum.FINISHED_PRODUCTION.getStatus())
                .andCostStatusEqualTo(ProduceOrderConstant.CostStatusEnum.NOT_CALCULATED.getStatus())
                .andCompletionTimeGreaterThanOrEqualTo(params.getMonthDate())
                .andCompletionTimeLessThan(DateUtil.plusMonth(1, params.getMonthDate()));
        return customProduceOrderMapper.selectByExample(produceOrderExample);
    }


    private void createProduceOrder(FactoryProductionOrder factoryProductionOrder, List<ListFactoryProductionOrderShopSkuResponse> listFactoryProductionOrderShopSkuResponseList, Integer dealUserId) {
        ProduceOrder produceOrder = new ProduceOrder();
        produceOrder.setShopId(factoryProductionOrder.getShopId());
        produceOrder.setEntityId(factoryProductionOrder.getId());
        produceOrder.setBatchNumber(getBatchNumber());
        produceOrder.setProductionTime(new Date());
        produceOrder.setStatus(ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus());
        produceOrder.setCreateBy(dealUserId);
        produceOrder.setCreateTime(new Date());
        produceOrder.setType(ProduceOrderConstant.TypeEnum.FACTORY_PRODUCTION_ORDER.getType());
        customProduceOrderMapper.insertSelective(produceOrder);//添加生产单店铺sku
        for (ListFactoryProductionOrderShopSkuResponse listFactoryProductionOrderShopSkuResponse :
                listFactoryProductionOrderShopSkuResponseList) {
            ProduceOrderShopSku produceOrderShopSku = new ProduceOrderShopSku();
            produceOrderShopSku.setProduceOrderId(produceOrder.getId());
            produceOrderShopSku.setShopSkuId(listFactoryProductionOrderShopSkuResponse.getShopSkuId());
            produceOrderShopSku.setProductionQuantity(listFactoryProductionOrderShopSkuResponse.getProductionQuantity());
            produceOrderShopSku.setCreateTime(new Date());
            produceOrderShopSku.setCreateBy(dealUserId);
            customProduceOrderShopSkuMapper.insertSelective(produceOrderShopSku);
        }
    }

    private boolean repeatShopSku(String shopSkuStr, List<Map<String, String>> list) {
        Integer count = 0;
        for (Map<String, String> map :
                list) {
            if (shopSkuStr.equals(map.get("店铺sku"))) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
