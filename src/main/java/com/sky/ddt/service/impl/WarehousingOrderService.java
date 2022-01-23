package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InventoryChangeRecordConstant;
import com.sky.ddt.common.constant.ProduceOrderConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.common.constant.WarehousingOrderConstant;
import com.sky.ddt.common.exception.NoticeException;
import com.sky.ddt.dao.custom.CustomWarehousingOrderMapper;
import com.sky.ddt.dao.custom.CustomWarehousingOrderShopSkuMapper;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.UpdateShopSkuInventoryQuantityRequest;
import com.sky.ddt.dto.warehousingOrder.request.ListWarehousingOrderRequest;
import com.sky.ddt.dto.warehousingOrder.request.SaveWarehousingOrderRequest;
import com.sky.ddt.dto.warehousingOrder.response.ExportWarehousingOrderResponse;
import com.sky.ddt.dto.warehousingOrder.response.ListWarehousingOrderResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.*;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 入库单管理
 * @date 2020/4/10 9:12
 */
@Service
public class WarehousingOrderService implements IWarehousingOrderService {
    @Autowired
    CustomWarehousingOrderMapper customWarehousingOrderMapper;
    @Autowired
    IProduceOrderService produceOrderService;
    @Autowired
    IShopService shopService;
    @Autowired
    IWarehousingOrderShopSkuService warehousingOrderShopSkuService;
    @Autowired
    IProduceOrderShopSkuService produceOrderShopSkuService;
    @Autowired
    CustomWarehousingOrderShopSkuMapper customWarehousingOrderShopSkuMapper;
    @Autowired
    IShopSkuService shopSkuService;

    /**
     * @param listWarehousingOrderRequest@return
     * @description 分页查询入库单信息
     * @author baixueping
     * @date 2020/4/10 16:05
     */
    @Override
    public PageInfo<ListWarehousingOrderResponse> listWarehousingOrder(ListWarehousingOrderRequest listWarehousingOrderRequest) {
        PageHelper.startPage(listWarehousingOrderRequest.getPage(), listWarehousingOrderRequest.getRows(), true);
        List<ListWarehousingOrderResponse> list = customWarehousingOrderMapper.listWarehousingOrder(listWarehousingOrderRequest);
        if (!CollectionUtils.isEmpty(list)) {
            for (ListWarehousingOrderResponse listWarehousingOrderResponse : list) {
                listWarehousingOrderResponse.setStatusName(WarehousingOrderConstant.StatusEnum.getStatusName(listWarehousingOrderResponse.getStatus()));
                listWarehousingOrderResponse.setTypeName(WarehousingOrderConstant.TypeEnum.getTypeName(listWarehousingOrderResponse.getType()));
            }
        }
        PageInfo<ListWarehousingOrderResponse> page = new PageInfo<ListWarehousingOrderResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存入库单信息
     * @author baixueping
     * @date 2020/4/17 16:44
     */
    @Override
    public BaseResponse saveWarehousingOrder(SaveWarehousingOrderRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        WarehousingOrder warehousingOrderOld = null;
        if (params.getId() != null) {
            warehousingOrderOld = customWarehousingOrderMapper.selectByPrimaryKey(params.getId());
            if (warehousingOrderOld == null) {
                sbErroEntity.append(WarehousingOrderConstant.ID_NOT_EXIST);
            } else if (!WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(warehousingOrderOld.getStatus())) {
                sbErroEntity.append(WarehousingOrderConstant.NOT_ALLOW_CHANGE);
            } else if (!warehousingOrderOld.getShopId().equals(params.getShopId())&&warehousingOrderShopSkuService.existWarehousingOrderShopSku(params.getId()) ) {
                sbErroEntity.append(WarehousingOrderConstant.EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID);
            }
        }
        ProduceOrder produceOrder = null;
        if (WarehousingOrderConstant.TypeEnum.PRODUCTION_ORDER_WAREHOUSING.getType().equals(params.getType())) {
            if (StringUtils.isEmpty(params.getProduceOrderBatchNumber())) {
                sbErroEntity.append(WarehousingOrderConstant.PRODUCE_ORDER_BATCH_NUMBER_EMPTY);
            } else {
                //判断生产单批次号是否存在 获取生产单id
                produceOrder = produceOrderService.getProduceOrderByBatchNumber(params.getProduceOrderBatchNumber());
                if (produceOrder == null) {
                    sbErroEntity.append(WarehousingOrderConstant.PRODUCE_ORDER_BATCH_NUMBER_NOT_EXIST);
                } else if (ProduceOrderConstant.StatusEnum.CANCEL.getStatus().equals(produceOrder.getStatus())
                        && params.getId() == null) {
                    sbErroEntity.append(WarehousingOrderConstant.PRODUCE_ORDER_CANCEL);
                } else if (!produceOrder.getShopId().equals(params.getShopId())) {
                    sbErroEntity.append(WarehousingOrderConstant.PRODUCE_ORDER_SHOP_ID_NOT_SAME);
                }
            }
        }
        //判断店铺id是否存在
        Shop shop = shopService.getShop(params.getShopId());
        if (shop == null) {
            sbErroEntity.append(WarehousingOrderConstant.SHOP_ID_NOT_EXIST);
        }

        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        //保存基本信息
        WarehousingOrder warehousingOrder = new WarehousingOrder();
        BeanUtils.copyProperties(params, warehousingOrder);
        if(produceOrder!=null){
            warehousingOrder.setProduceOrderId(produceOrder.getId());
        }
        if (params.getId() == null) {
            warehousingOrder.setBatchNumber(getBatchNumber());
            warehousingOrder.setWarehousingTime(new Date());
            warehousingOrder.setStatus(WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus());
            warehousingOrder.setCreateBy(dealUserId);
            warehousingOrder.setCreateTime(new Date());
            customWarehousingOrderMapper.insertSelective(warehousingOrder);
            if (WarehousingOrderConstant.TypeEnum.PRODUCTION_ORDER_WAREHOUSING.getType().equals(params.getType())) {
                addWarehousingOrderShopSku(warehousingOrder.getId(), warehousingOrder.getProduceOrderId(), dealUserId);
            }
        } else {
            if (WarehousingOrderConstant.TypeEnum.PRODUCTION_ORDER_WAREHOUSING.getType().equals(params.getType()) && !warehousingOrderShopSkuService.existWarehousingOrderShopSku(params.getId())) {
                addWarehousingOrderShopSku(warehousingOrder.getId(), warehousingOrder.getProduceOrderId(), dealUserId);
            }
            warehousingOrder.setUpdateBy(dealUserId);
            warehousingOrder.setUpdateTime(new Date());
            customWarehousingOrderMapper.updateByPrimaryKeySelective(warehousingOrder);
        }
        return BaseResponse.success();
    }

    //根据生产单添加入库单店铺sku 数量默认为0
    private void addWarehousingOrderShopSku(Integer warehousingOrderId, Integer produceOrderId, Integer dealUserId) {
        if (warehousingOrderId == null || produceOrderId == null) {
            return;
        }
        List<ListProduceOrderShopSkuResponse> produceOrderShopSkuList = produceOrderShopSkuService.listProduceOrderShopSkuByProduceOrderId(produceOrderId);
        for (ListProduceOrderShopSkuResponse listProduceOrderShopSkuResponse :
                produceOrderShopSkuList) {
            WarehousingOrderShopSku warehousingOrderShopSku = new WarehousingOrderShopSku();
            warehousingOrderShopSku.setWarehousingOrderId(warehousingOrderId);
            warehousingOrderShopSku.setShopSkuId(listProduceOrderShopSkuResponse.getShopSkuId());
            warehousingOrderShopSku.setShopSku(listProduceOrderShopSkuResponse.getShopSku());
            warehousingOrderShopSku.setWarehousingQuantity(0);
            warehousingOrderShopSku.setCreateBy(dealUserId);
            warehousingOrderShopSku.setCreateTime(new Date());
            customWarehousingOrderShopSkuMapper.insertSelective(warehousingOrderShopSku);
        }
    }

    private String getBatchNumber() {
        String batchNumberFirst = "RKD" + DateUtil.getFormatStryyyyMMdd(new Date());
        WarehousingOrderExample warehousingOrderExample = new WarehousingOrderExample();
        warehousingOrderExample.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customWarehousingOrderMapper.countByExample(warehousingOrderExample);
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
        WarehousingOrderExample warehousingOrderExample = new WarehousingOrderExample();
        warehousingOrderExample.createCriteria().andBatchNumberEqualTo(batchNumber);
        return customWarehousingOrderMapper.countByExample(warehousingOrderExample) > 0;
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 废除入库单
     * @author baixueping
     * @date 2020/4/23 11:12
     */
    @Override
    public BaseResponse cancelWarehousingOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(WarehousingOrderConstant.ID_EMPTY);
        }
        WarehousingOrder warehousingOrder = getWarehousingOrderById(id);
        if (warehousingOrder == null) {
            return BaseResponse.failMessage(WarehousingOrderConstant.ID_NOT_EXIST);
        }
        if (!WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(warehousingOrder.getStatus())) {
            return BaseResponse.failMessage(WarehousingOrderConstant.NOT_ALLOW_CANCEL);
        }
        WarehousingOrder warehousingOrderCancel = new WarehousingOrder();
        warehousingOrderCancel.setId(id);
        warehousingOrderCancel.setStatus(WarehousingOrderConstant.StatusEnum.CANCEL.getStatus());
        customWarehousingOrderMapper.updateByPrimaryKeySelective(warehousingOrderCancel);
        return BaseResponse.success();
    }

    @Override
    public WarehousingOrder getWarehousingOrderById(Integer id) {
        if (id == null) {
            return null;
        }
        return customWarehousingOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 入库操作
     * @author baixueping
     * @date 2020/5/7 10:49
     */
    @Override
    @Transactional
    public BaseResponse warehousing(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(WarehousingOrderConstant.ID_EMPTY);
        }
        WarehousingOrder warehousingOrder = getWarehousingOrderById(id);
        if (warehousingOrder == null) {
            return BaseResponse.failMessage(WarehousingOrderConstant.ID_NOT_EXIST);
        }
        if (!WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(warehousingOrder.getStatus())) {
            return BaseResponse.failMessage(WarehousingOrderConstant.ONLY_PENDING_STORAGE_ALLOW_WAREHOUSING);
        }
        //如果是生产单入库，则判断是生产单状态是否允许入库
        ProduceOrder produceOrder = null;
        if (WarehousingOrderConstant.TypeEnum.PRODUCTION_ORDER_WAREHOUSING.getType().equals(warehousingOrder.getType())) {
            produceOrder = produceOrderService.getProduceOrderById(warehousingOrder.getProduceOrderId());
            if (produceOrder == null) {
                //正常逻辑走不到这里
                return BaseResponse.failMessage(WarehousingOrderConstant.PRODUCE_ORDER_NOT_EXIST);
            }
            if (!ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(produceOrder.getStatus())
                    && !ProduceOrderConstant.StatusEnum.PARTIAL_STORAGE.getStatus().equals(produceOrder.getStatus())) {
                //正常逻辑走不到这里
                return BaseResponse.failMessage(WarehousingOrderConstant.PRODUCE_ORDER_STATUS_NOT_ALLOW_WAREHOUSING);
            }
        }
        //获取生产单店铺sku信息
        List<WarehousingOrderShopSku> warehousingOrderShopSkuList = warehousingOrderShopSkuService.listWarehousingOrderShopSku(id);
        if (CollectionUtils.isEmpty(warehousingOrderShopSkuList)) {
            return BaseResponse.failMessage(WarehousingOrderConstant.NOT_EXIST_SHOP_SKU_NOT_ALLOW_WAREHOUSING);
        }
        Integer quantity = 0;
        for (WarehousingOrderShopSku warehousingOrderShopSku :
                warehousingOrderShopSkuList) {
            quantity += warehousingOrderShopSku.getWarehousingQuantity();
        }
        if (quantity == 0) {
            return BaseResponse.failMessage(WarehousingOrderConstant.SHOP_SKU_QUANTITY_ZERO_NOT_ALLOW_WAREHOUSING);
        }
        //修改店铺sku库存&添加sku库存变更记录
        for (WarehousingOrderShopSku warehousingOrderShopSku :
                warehousingOrderShopSkuList) {
            if (warehousingOrderShopSku.getWarehousingQuantity() == 0) {
                continue;
            }
            UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequest = new UpdateShopSkuInventoryQuantityRequest();
            updateShopSkuInventoryQuantityRequest.setChangeTypeEnum(InventoryChangeRecordConstant.ChangeTypeEnum.WAREHOUSING);
            updateShopSkuInventoryQuantityRequest.setDealUserId(dealUserId);
            updateShopSkuInventoryQuantityRequest.setQuantity(warehousingOrderShopSku.getWarehousingQuantity());
            updateShopSkuInventoryQuantityRequest.setShopSkuId(warehousingOrderShopSku.getShopSkuId());
            updateShopSkuInventoryQuantityRequest.setEntityId(warehousingOrderShopSku.getId());
            updateShopSkuInventoryQuantityRequest.setMainEntityId(warehousingOrderShopSku.getWarehousingOrderId());
            shopSkuService.updateInventoryQuantity(updateShopSkuInventoryQuantityRequest);
        }
        //修改入库单状态为已入库
        updateWarehousingOrderWarehousing(id, dealUserId);
        //修改生产单的状态为部分入库
        if (WarehousingOrderConstant.TypeEnum.PRODUCTION_ORDER_WAREHOUSING.getType().equals(warehousingOrder.getType())) {
            produceOrderService.updateProduceOrderPartialStorage(warehousingOrder.getProduceOrderId(), dealUserId);
        }
        //修改仓库sku的库位信息
        customWarehousingOrderMapper.insertShopSkuStorageLocationByWarehousingOrder(id,dealUserId);
        return BaseResponse.success();
    }

    /**
     * @param produceOrderId@return
     * @description 判断是否存在待入库订单数量
     * @author baixueping
     * @date 2020/5/8 16:31
     */
    @Override
    public boolean existPendingStoragewarehousingOrder(Integer produceOrderId) {
        if(produceOrderId==null){
            return false;
        }
        WarehousingOrderExample warehousingOrderExample=new WarehousingOrderExample();
        warehousingOrderExample.createCriteria().andProduceOrderIdEqualTo(produceOrderId)
                .andTypeEqualTo(WarehousingOrderConstant.TypeEnum.PRODUCTION_ORDER_WAREHOUSING.getType())
                .andStatusEqualTo(WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus());
        return customWarehousingOrderMapper.countByExample(warehousingOrderExample)>0;
    }

    /**
     * @param params@return
     * @description 查询导出的入库单信息
     * @author baixueping
     * @date 2020/11/5 14:19
     */
    @Override
    public List<ExportWarehousingOrderResponse> listExportWarehousingOrder(ListWarehousingOrderRequest params) {
        List<ExportWarehousingOrderResponse> list=customWarehousingOrderMapper.listExportWarehousingOrder(params);
        if (!CollectionUtils.isEmpty(list)) {
            for (ExportWarehousingOrderResponse exportWarehousingOrderResponse : list) {
                exportWarehousingOrderResponse.setStatusName(WarehousingOrderConstant.StatusEnum.getStatusName(exportWarehousingOrderResponse.getStatus()));
                exportWarehousingOrderResponse.setTypeName(WarehousingOrderConstant.TypeEnum.getTypeName(exportWarehousingOrderResponse.getType()));
            }
        }
        return list;
    }

    private void updateWarehousingOrderWarehousing(Integer id, Integer dealUserId) {
        WarehousingOrder warehousingOrder = new WarehousingOrder();
        warehousingOrder.setId(id);
        warehousingOrder.setStatus(WarehousingOrderConstant.StatusEnum.WAREHOUSING.getStatus());
        warehousingOrder.setUpdateTime(new Date());
        warehousingOrder.setUpdateBy(dealUserId);
        customWarehousingOrderMapper.updateByPrimaryKeySelective(warehousingOrder);
    }
}
