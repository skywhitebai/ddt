package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.CheckOrderConstant;
import com.sky.ddt.common.constant.InventoryChangeRecordConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.dao.custom.CustomCheckOrderMapper;
import com.sky.ddt.dto.checkOrder.request.ListCheckOrderRequest;
import com.sky.ddt.dto.checkOrder.request.SaveCheckOrderRequest;
import com.sky.ddt.dto.checkOrder.response.ListCheckOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.UpdateShopSkuInventoryQuantityRequest;
import com.sky.ddt.entity.CheckOrder;
import com.sky.ddt.entity.CheckOrderExample;
import com.sky.ddt.entity.CheckOrderShopSku;
import com.sky.ddt.entity.Shop;
import com.sky.ddt.service.ICheckOrderService;
import com.sky.ddt.service.ICheckOrderShopSkuService;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 盘点单
 * @date 2020/5/9 10:51
 */
@Service
public class CheckOrderService implements ICheckOrderService {
    @Autowired
    CustomCheckOrderMapper customCheckOrderMapper;
    @Autowired
    ICheckOrderShopSkuService checkOrderShopSkuService;
    @Autowired
    IShopService shopService;
    @Autowired
    IShopSkuService shopSkuService;

    /**
     * @param params@return
     * @description 分页查询入库单列表
     * @author baixueping
     * @date 2020/5/9 17:37
     */
    @Override
    public PageInfo<ListCheckOrderResponse> listCheckOrder(ListCheckOrderRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListCheckOrderResponse> list = customCheckOrderMapper.listCheckOrder(params);
        if (!CollectionUtils.isEmpty(list)) {
            for (ListCheckOrderResponse listCheckOrderResponse : list) {
                listCheckOrderResponse.setStatusName(CheckOrderConstant.StatusEnum.getStatusName(listCheckOrderResponse.getStatus()));
            }
        }
        PageInfo<ListCheckOrderResponse> page = new PageInfo<ListCheckOrderResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存盘点单
     * @author baixueping
     * @date 2020/5/11 10:19
     */
    @Override
    public BaseResponse saveCheckOrder(SaveCheckOrderRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        CheckOrder checkOrderOld = null;
        if (params.getId() != null) {
            checkOrderOld = customCheckOrderMapper.selectByPrimaryKey(params.getId());
            if (checkOrderOld == null) {
                sbErroEntity.append(CheckOrderConstant.ID_NOT_EXIST);
            } else if (!CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(checkOrderOld.getStatus())) {
                sbErroEntity.append(CheckOrderConstant.NOT_ALLOW_CHANGE);
            } else if (!checkOrderOld.getShopId().equals(params.getShopId()) && checkOrderShopSkuService.existCheckOrderShopSku(params.getId())) {
                sbErroEntity.append(CheckOrderConstant.EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID);
            }
        }
        //判断店铺id是否存在
        Shop shop = shopService.getShop(params.getShopId());
        if (shop == null) {
            sbErroEntity.append(CheckOrderConstant.SHOP_ID_NOT_EXIST);
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        CheckOrder checkOrder = new CheckOrder();
        BeanUtils.copyProperties(params, checkOrder);
        if (params.getId() == null) {
            checkOrder.setBatchNumber(getBatchNumber());
            checkOrder.setCheckTime(new Date());
            checkOrder.setStatus(CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus());
            checkOrder.setCreateBy(dealUserId);
            checkOrder.setCreateTime(new Date());
            customCheckOrderMapper.insertSelective(checkOrder);
        } else {
            checkOrder.setUpdateBy(dealUserId);
            checkOrder.setUpdateTime(new Date());
            customCheckOrderMapper.updateByPrimaryKeySelective(checkOrder);
        }
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 取消盘点单
     * @author baixueping
     * @date 2020/5/11 11:24
     */
    @Override
    public BaseResponse cancelCheckOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(CheckOrderConstant.ID_EMPTY);
        }
        CheckOrder checkOrder = getCheckOrderById(id);
        if (checkOrder == null) {
            return BaseResponse.failMessage(CheckOrderConstant.ID_NOT_EXIST);
        }
        if (!CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(checkOrder.getStatus())) {
            return BaseResponse.failMessage(CheckOrderConstant.NOT_ALLOW_CANCEL);
        }
        CheckOrder checkOrderCancel = new CheckOrder();
        checkOrderCancel.setId(id);
        checkOrderCancel.setStatus(CheckOrderConstant.StatusEnum.CANCEL.getStatus());
        customCheckOrderMapper.updateByPrimaryKeySelective(checkOrderCancel);
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 盘点单确认
     * @author baixueping
     * @date 2020/5/11 11:28
     */
    @Override
    @Transactional
    public BaseResponse confirmCheckOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(CheckOrderConstant.ID_EMPTY);
        }
        CheckOrder checkOrder = getCheckOrderById(id);
        if (checkOrder == null) {
            return BaseResponse.failMessage(CheckOrderConstant.ID_NOT_EXIST);
        }
        if (!CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(checkOrder.getStatus())) {
            return BaseResponse.failMessage(CheckOrderConstant.ONLY_PENDING_CONFIRM_ALLOW_CONFIRM);
        }
        //获取盘点单店铺sku信息
        List<CheckOrderShopSku> checkOrderShopSkuList=checkOrderShopSkuService.listCheckOrderShopSku(id);
        if(CollectionUtils.isEmpty(checkOrderShopSkuList)){
            return BaseResponse.failMessage(CheckOrderConstant.NOT_EXIST_SHOP_SKU_NOT_ALLOW_CONFIRM);
        }
        for(CheckOrderShopSku checkOrderShopSku:checkOrderShopSkuList){
            UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequest = new UpdateShopSkuInventoryQuantityRequest();
            updateShopSkuInventoryQuantityRequest.setChangeTypeEnum(InventoryChangeRecordConstant.ChangeTypeEnum.CHECK);
            updateShopSkuInventoryQuantityRequest.setDealUserId(dealUserId);
            updateShopSkuInventoryQuantityRequest.setQuantity(checkOrderShopSku.getInventoryQuantityNew());
            updateShopSkuInventoryQuantityRequest.setShopSku(checkOrderShopSku.getShopSku());
            updateShopSkuInventoryQuantityRequest.setShopSkuId(checkOrderShopSku.getShopSkuId());
            updateShopSkuInventoryQuantityRequest.setEntityId(checkOrderShopSku.getId());
            updateShopSkuInventoryQuantityRequest.setMainEntityId(checkOrderShopSku.getCheckOrderId());
            shopSkuService.updateInventoryQuantity(updateShopSkuInventoryQuantityRequest);
        }
        //修改盘点单状态为已确认
        updateCheckOrderConfirm(id, dealUserId);
        return BaseResponse.success();
    }

    private void updateCheckOrderConfirm(Integer id, Integer dealUserId) {
        CheckOrder checkOrder = new CheckOrder();
        checkOrder.setId(id);
        checkOrder.setStatus(CheckOrderConstant.StatusEnum.CONFIRM.getStatus());
        checkOrder.setUpdateTime(new Date());
        checkOrder.setUpdateBy(dealUserId);
        customCheckOrderMapper.updateByPrimaryKeySelective(checkOrder);
    }

    @Override
    public CheckOrder getCheckOrderById(Integer id) {
        if (id == null) {
            return null;
        }
        return customCheckOrderMapper.selectByPrimaryKey(id);
    }

    private String getBatchNumber() {
        String batchNumberFirst = "PDD" + DateUtil.getFormatStryyyyMMdd(new Date());
        CheckOrderExample example = new CheckOrderExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customCheckOrderMapper.countByExample(example);
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
        CheckOrderExample example = new CheckOrderExample();
        example.createCriteria().andBatchNumberEqualTo(batchNumber);
        return customCheckOrderMapper.countByExample(example) > 0;
    }
}
