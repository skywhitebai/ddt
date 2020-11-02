package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProduceOrderConstant;
import com.sky.ddt.common.constant.ProduceOrderShopSkuConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.dao.custom.CustomProduceOrderMapper;
import com.sky.ddt.dao.custom.CustomProduceOrderShopSkuMapper;
import com.sky.ddt.dto.produceOrder.request.ListProduceOrderRequest;
import com.sky.ddt.dto.produceOrder.request.SaveProduceOrderRequest;
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
import java.util.List;
import java.util.Map;

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
     * @param dealUserId
     * @return
     * @description 通过工厂生产单创建生产单
     * @author baixueping
     * @date 2020/11/2 9:16
     */
    @Override
    public void createProduceOrder(FactoryProductionOrder factoryProductionOrder, Integer dealUserId) {
        ProduceOrder produceOrder=new ProduceOrder();
        produceOrder.setShopId(factoryProductionOrder.getShopId());
        produceOrder.setEntityId(factoryProductionOrder.getId());
        produceOrder.setBatchNumber(getBatchNumber());
        produceOrder.setProductionTime(new Date());
        produceOrder.setStatus(ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus());
        produceOrder.setCreateBy(dealUserId);
        produceOrder.setCreateTime(new Date());
        produceOrder.setType(ProduceOrderConstant.TypeEnum.FACTORY_PRODUCTION_ORDER.getType());
        customProduceOrderMapper.insertSelective(produceOrder);
        List<FactoryProductionOrderShopSku> factoryProductionOrderShopSkuList=factoryProductionOrderShopSkuService.listFactoryProductionOrderShopSku(factoryProductionOrder.getId());
        //添加生产单店铺sku
        for (FactoryProductionOrderShopSku factoryProductionOrderShopSku :
                factoryProductionOrderShopSkuList) {
            ProduceOrderShopSku produceOrderShopSku = new ProduceOrderShopSku();
            produceOrderShopSku.setProduceOrderId(produceOrder.getId());
            produceOrderShopSku.setShopSkuId(factoryProductionOrderShopSku.getShopSkuId());
            produceOrderShopSku.setProductionQuantity(factoryProductionOrderShopSku.getProductionQuantity());
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
