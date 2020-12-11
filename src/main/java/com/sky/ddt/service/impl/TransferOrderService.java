package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InventoryChangeRecordConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.common.constant.TransferOrderConstant;
import com.sky.ddt.dao.custom.CustomTransferOrderMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.UpdateShopSkuInventoryQuantityRequest;
import com.sky.ddt.dto.transferOrder.request.ListTransferOrderRequest;
import com.sky.ddt.dto.transferOrder.request.SaveTransferOrderRequest;
import com.sky.ddt.dto.transferOrder.response.ListTransferOrderResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.ITransferOrderService;
import com.sky.ddt.service.ITransferOrderShopSkuService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baixueping
 * @description 调拨单服务
 * @date 2020/8/28 16:21
 */
@Service
public class TransferOrderService implements ITransferOrderService {
    @Autowired
    CustomTransferOrderMapper customTransferOrderMapper;
    @Autowired
    IShopService shopService;
    @Autowired
    ITransferOrderShopSkuService transferOrderShopSkuService;
    @Autowired
    IShopSkuService shopSkuService;

    /**
     * @param params@return
     * @description 分页查询调拨单信息
     * @author baixueping
     * @date 2020/8/31 17:27
     */
    @Override
    public PageInfo<ListTransferOrderResponse> listTransferOrder(ListTransferOrderRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListTransferOrderResponse> list = customTransferOrderMapper.listTransferOrder(params);
        if (!CollectionUtils.isEmpty(list)) {
            for (ListTransferOrderResponse listTransferOrderResponse : list) {
                listTransferOrderResponse.setStatusName(TransferOrderConstant.StatusEnum.getStatusName(listTransferOrderResponse.getStatus()));
            }
        }
        PageInfo<ListTransferOrderResponse> page = new PageInfo<>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存调拨单
     * @author baixueping
     * @date 2020/8/31 19:08
     */
    @Override
    public BaseResponse saveTransferOrder(SaveTransferOrderRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        TransferOrder transferOrderOld = null;
        if (params.getId() != null) {
            transferOrderOld = customTransferOrderMapper.selectByPrimaryKey(params.getId());
            if (transferOrderOld == null) {
                sbErroEntity.append(TransferOrderConstant.ID_NOT_EXIST);
            } else if (!TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus().equals(transferOrderOld.getStatus())) {
                sbErroEntity.append(TransferOrderConstant.NOT_ALLOW_CHANGE);
            } else if ((!transferOrderOld.getShopIdFrom().equals(params.getShopIdFrom()) || !transferOrderOld.getShopIdTo().equals(params.getShopIdTo())) && transferOrderShopSkuService.existTransferOrderShopSku(params.getId())) {
                sbErroEntity.append(TransferOrderConstant.EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID);
            }
        }
        if (params.getShopIdFrom().equals(params.getShopIdTo())) {
            sbErroEntity.append(TransferOrderConstant.SHOP_ID_FROM_SHOP_ID_TO_NOT_ALLOW_SAME);
        }
        Shop shopFrom = shopService.getShop(params.getShopIdFrom());
        if (shopFrom == null) {
            sbErroEntity.append(TransferOrderConstant.SHOP_ID_FROM_NOT_EXISTS);
        }
        Shop shopTo = shopService.getShop(params.getShopIdTo());
        if (shopTo == null) {
            sbErroEntity.append(TransferOrderConstant.SHOP_ID_TO_NOT_EXISTS);
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        TransferOrder transferOrder = new TransferOrder();
        BeanUtils.copyProperties(params, transferOrder);
        transferOrder.setUpdateBy(dealUserId);
        transferOrder.setUpdateTime(new Date());
        if (params.getId() == null) {
            transferOrder.setBatchNumber(getBatchNumber());
            transferOrder.setStatus(TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus());
            transferOrder.setCreateBy(dealUserId);
            transferOrder.setCreateTime(new Date());
            customTransferOrderMapper.insertSelective(transferOrder);
        } else {
            customTransferOrderMapper.updateByPrimaryKeySelective(transferOrder);
        }
        return BaseResponse.success();
    }

    private String getBatchNumber() {
        String batchNumberFirst = "DKD" + DateUtil.getFormatStryyyyMMdd(new Date());
        TransferOrderExample example = new TransferOrderExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customTransferOrderMapper.countByExample(example);
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
        TransferOrderExample example = new TransferOrderExample();
        example.createCriteria().andBatchNumberEqualTo(batchNumber);
        return customTransferOrderMapper.countByExample(example) > 0;
    }

    /**
     * @param
     * @return
     * @description 通过id获取调拨单
     * @author baixueping
     * @date 2020/9/1 12:55
     */
    @Override
    public TransferOrder getTransferOrderById(Integer transferOrderId) {
        if(transferOrderId==null){
            return null;
        }
        return customTransferOrderMapper.selectByPrimaryKey(transferOrderId);
    }

    @Override
    public BaseResponse cancelTransferOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(TransferOrderConstant.ID_EMPTY);
        }
        TransferOrder transferOrder = getTransferOrderById(id);
        if (transferOrder == null) {
            return BaseResponse.failMessage(TransferOrderConstant.ID_NOT_EXIST);
        }
        if (!TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus().equals(transferOrder.getStatus())) {
            return BaseResponse.failMessage(TransferOrderConstant.NOT_ALLOW_CANCEL);
        }
        TransferOrder transferOrderCancel = new TransferOrder();
        transferOrderCancel.setId(id);
        transferOrderCancel.setStatus(TransferOrderConstant.StatusEnum.CANCEL.getStatus());
        transferOrderCancel.setUpdateBy(dealUserId);
        transferOrderCancel.setUpdateTime(new Date());
        customTransferOrderMapper.updateByPrimaryKeySelective(transferOrderCancel);
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 调拨
     * @author baixueping
     * @date 2020/9/1 14:55
     */
    @Override
    @Transactional
    public BaseResponse transfer(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(TransferOrderConstant.ID_EMPTY);
        }
        TransferOrder transferOrder=getTransferOrderById(id);
        if (transferOrder == null) {
            return BaseResponse.failMessage(TransferOrderConstant.ID_NOT_EXIST);
        }
        if(!TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus().equals(transferOrder.getStatus())){
            return BaseResponse.failMessage(TransferOrderConstant.ONLY_PENDING_TRANSFER_ALLOW_TRANSFER);
        }
        List<TransferOrderShopSku> transferOrderShopSkuList=transferOrderShopSkuService.listTransferOrderShopSku(id);
        if (CollectionUtils.isEmpty(transferOrderShopSkuList)) {
            return BaseResponse.failMessage(TransferOrderConstant.NOT_EXIST_SHOP_SKU_NOT_ALLOW_TRANSFER);
        }
        List<Integer> shopSkuIdFromList = transferOrderShopSkuList.stream().map(TransferOrderShopSku -> TransferOrderShopSku.getShopSkuIdFrom()).collect(Collectors.toList());
        //校验库存是否满足调拨条件
        SbErroEntity sbErroEntity = new SbErroEntity();
        List<UpdateShopSkuInventoryQuantityRequest> updateShopSkuInventoryQuantityRequestList = new ArrayList<>();
        for (TransferOrderShopSku transferOrderShopSku:
                transferOrderShopSkuList) {
            ShopSku shopSkuFrom =shopSkuService.getShopSku(transferOrderShopSku.getShopSkuIdFrom());;
            if (shopSkuFrom == null) {
                sbErroEntity.append("店铺skuId：" + transferOrderShopSku.getShopSkuIdFrom() + "不存在");
                continue;
            }
            Integer inventoryQuantityFrom = MathUtil.subtractInteger(shopSkuFrom.getInventoryQuantity(), transferOrderShopSku.getTransferQuantity());
            if (inventoryQuantityFrom < 0) {
                sbErroEntity.append(String.format("出库失败，店铺sku[%s]库存不足", shopSkuFrom.getShopSku()));
                continue;
            }
            ShopSku shopSkuTo= shopSkuService.getShopSku(transferOrderShopSku.getShopSkuIdTo());;
            if (shopSkuTo == null) {
                sbErroEntity.append("店铺skuId：" + transferOrderShopSku.getShopSkuIdTo() + "不存在");
                continue;
            }
            if (sbErroEntity.isFail()) {
                //如果有错误信息就不执行后面的操作了
                continue;
            }
            UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequestFrom = new UpdateShopSkuInventoryQuantityRequest();
            updateShopSkuInventoryQuantityRequestFrom.setChangeTypeEnum(InventoryChangeRecordConstant.ChangeTypeEnum.TRANSFER_FROM);
            updateShopSkuInventoryQuantityRequestFrom.setDealUserId(dealUserId);
            updateShopSkuInventoryQuantityRequestFrom.setQuantity(transferOrderShopSku.getTransferQuantity());
            updateShopSkuInventoryQuantityRequestFrom.setShopSkuId(transferOrderShopSku.getShopSkuIdFrom());
            updateShopSkuInventoryQuantityRequestFrom.setEntityId(transferOrderShopSku.getId());
            updateShopSkuInventoryQuantityRequestFrom.setMainEntityId(transferOrderShopSku.getTransferOrderId());
            updateShopSkuInventoryQuantityRequestFrom.setShopSkuInfo(shopSkuFrom);
            updateShopSkuInventoryQuantityRequestList.add(updateShopSkuInventoryQuantityRequestFrom);

            UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequestTo = new UpdateShopSkuInventoryQuantityRequest();
            updateShopSkuInventoryQuantityRequestTo.setChangeTypeEnum(InventoryChangeRecordConstant.ChangeTypeEnum.TRANSFER_TO);
            updateShopSkuInventoryQuantityRequestTo.setDealUserId(dealUserId);
            updateShopSkuInventoryQuantityRequestTo.setQuantity(transferOrderShopSku.getTransferQuantity());
            updateShopSkuInventoryQuantityRequestTo.setShopSkuId(transferOrderShopSku.getShopSkuIdTo());
            updateShopSkuInventoryQuantityRequestTo.setEntityId(transferOrderShopSku.getId());
            updateShopSkuInventoryQuantityRequestTo.setMainEntityId(transferOrderShopSku.getTransferOrderId());
            updateShopSkuInventoryQuantityRequestTo.setShopSkuInfo(shopSkuTo);
            updateShopSkuInventoryQuantityRequestList.add(updateShopSkuInventoryQuantityRequestTo);
        }
        if(sbErroEntity.isFail()){
            return sbErroEntity.getResponse();
        }
        for (UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequest :
                updateShopSkuInventoryQuantityRequestList) {
            shopSkuService.updateInventoryQuantity(updateShopSkuInventoryQuantityRequest);
        }
        //修改出库单状态为已出库
        updateTransferOrderTransfer(id, dealUserId);
        return BaseResponse.success();
    }

    private void updateTransferOrderTransfer(Integer id, Integer dealUserId) {
        TransferOrder transferOrder = new TransferOrder();
        transferOrder.setId(id);
        transferOrder.setStatus(TransferOrderConstant.StatusEnum.TRANSFER.getStatus());
        transferOrder.setTransferTime(new Date());
        transferOrder.setUpdateTime(new Date());
        transferOrder.setUpdateBy(dealUserId);
        customTransferOrderMapper.updateByPrimaryKeySelective(transferOrder);
    }
}
