package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.*;
import com.sky.ddt.dao.custom.CustomOutboundOrderMapper;
import com.sky.ddt.dao.custom.CustomOutboundOrderShopSkuMapper;
import com.sky.ddt.dto.outboundOrder.request.SaveOutboundOrderRequest;
import com.sky.ddt.dto.outboundOrder.response.ListOutboundOrderResponse;
import com.sky.ddt.dto.outboundOrder.request.ListOutboundOrderRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.shopSku.request.ListOutboundShopSkuRequest;
import com.sky.ddt.dto.shopSku.request.UpdateShopSkuInventoryQuantityRequest;
import com.sky.ddt.dto.shopSku.response.ListOutboundShopSkuResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IOutboundOrderService;
import com.sky.ddt.service.IOutboundOrderShopSkuService;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.IShopSkuService;
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
 * @description 出库单服务
 * @date 2020/5/12 9:53
 */
@Service
public class OutboundOrderService implements IOutboundOrderService {
    @Autowired
    CustomOutboundOrderMapper customOutboundOrderMapper;
    @Autowired
    IOutboundOrderShopSkuService outboundOrderShopSkuService;
    @Autowired
    IShopService shopService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    CustomOutboundOrderShopSkuMapper customOutboundOrderShopSkuMapper;

    /**
     * @param params@return
     * @description 分页查询出库单信息
     * @author baixueping
     * @date 2020/5/12 10:08
     */
    @Override
    public PageInfo<ListOutboundOrderResponse> listOutboundOrder(ListOutboundOrderRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListOutboundOrderResponse> list = customOutboundOrderMapper.listOutboundOrder(params);
        if (!CollectionUtils.isEmpty(list)) {
            for (ListOutboundOrderResponse listOutboundOrderResponse : list) {
                listOutboundOrderResponse.setStatusName(OutboundOrderConstant.StatusEnum.getStatusName(listOutboundOrderResponse.getStatus()));
            }
        }
        PageInfo<ListOutboundOrderResponse> page = new PageInfo<ListOutboundOrderResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存出库单信息
     * @author baixueping
     * @date 2020/5/12 11:03
     */
    @Override
    public BaseResponse saveOutboundOrder(SaveOutboundOrderRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        OutboundOrder outboundOrderOld = null;
        if (params.getId() != null) {
            outboundOrderOld = customOutboundOrderMapper.selectByPrimaryKey(params.getId());
            if (outboundOrderOld == null) {
                sbErroEntity.append(OutboundOrderConstant.ID_NOT_EXIST);
            } else if (!OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus().equals(outboundOrderOld.getStatus())) {
                sbErroEntity.append(OutboundOrderConstant.NOT_ALLOW_CHANGE);
            } else if (!outboundOrderOld.getShopId().equals(params.getShopId()) && outboundOrderShopSkuService.existOutboundOrderShopSku(params.getId())) {
                sbErroEntity.append(OutboundOrderConstant.EXIST_SHOP_SKU_NOT_ALLOW_CHANGE_SHOP_ID);
            }
        }
        //判断店铺id是否存在
        Shop shop = shopService.getShop(params.getShopId());
        if (shop == null) {
            sbErroEntity.append(OutboundOrderConstant.SHOP_ID_NOT_EXIST);
        }
        Shop outboundShop = shopService.getShop(params.getOutboundShopId());
        if (outboundShop == null) {
            sbErroEntity.append(OutboundOrderConstant.OUTBOUND_SHOP_ID_NOT_EXIST);
        }else if(!ShopConstant.TypeEnum.WAREHOUSE.getType().equals(outboundShop.getType())){
            sbErroEntity.append(OutboundOrderConstant.OUTBOUND_SHOP_TYPE_ERRO);
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        OutboundOrder outboundOrder = new OutboundOrder();
        BeanUtils.copyProperties(params, outboundOrder);
        if (params.getId() == null) {
            outboundOrder.setBatchNumber(getBatchNumber());
            outboundOrder.setType(OutboundOrderConstant.TypeEnum.MANUAL_OUTBOUND.getType());
            outboundOrder.setStatus(OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus());
            outboundOrder.setCreateBy(dealUserId);
            outboundOrder.setCreateTime(new Date());
            customOutboundOrderMapper.insertSelective(outboundOrder);
        } else {
            outboundOrder.setUpdateBy(dealUserId);
            outboundOrder.setUpdateTime(new Date());
            customOutboundOrderMapper.updateByPrimaryKeySelective(outboundOrder);
        }
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 取消出库单
     * @author baixueping
     * @date 2020/5/12 11:22
     */
    @Override
    public BaseResponse cancelOutboundOrder(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(OutboundOrderConstant.ID_EMPTY);
        }
        OutboundOrder outboundOrder = getOutboundOrderById(id);
        if (outboundOrder == null) {
            return BaseResponse.failMessage(OutboundOrderConstant.ID_NOT_EXIST);
        }
        if (!OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus().equals(outboundOrder.getStatus())) {
            return BaseResponse.failMessage(OutboundOrderConstant.NOT_ALLOW_CANCEL);
        }
        OutboundOrder outboundOrderCancel = new OutboundOrder();
        outboundOrderCancel.setId(id);
        outboundOrderCancel.setStatus(OutboundOrderConstant.StatusEnum.CANCEL.getStatus());
        outboundOrderCancel.setUpdateBy(dealUserId);
        outboundOrderCancel.setUpdateTime(new Date());
        customOutboundOrderMapper.updateByPrimaryKeySelective(outboundOrderCancel);
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param dealUserId
     * @return
     * @description 出库
     * @author baixueping
     * @date 2020/5/12 11:29
     */
    @Override
    @Transactional
    public BaseResponse outbound(Integer id, Integer dealUserId) {
        if (id == null) {
            return BaseResponse.failMessage(OutboundOrderConstant.ID_EMPTY);
        }
        OutboundOrder outboundOrder = getOutboundOrderById(id);
        if (outboundOrder == null) {
            return BaseResponse.failMessage(OutboundOrderConstant.ID_NOT_EXIST);
        }
        if(outboundOrder.getOutboundShopId()==null){
            return BaseResponse.failMessage(OutboundOrderConstant.OUTBOUND_SHOP_ID_EMPTY);
        }
        if (!OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus().equals(outboundOrder.getStatus())) {
            return BaseResponse.failMessage(OutboundOrderConstant.ONLY_PENDING_OUTBOUND_ALLOW_OUTBOUND);
        }
        List<OutboundOrderShopSku> outboundOrderShopSkuList = outboundOrderShopSkuService.listOutboundOrderShopSku(id);
        if (CollectionUtils.isEmpty(outboundOrderShopSkuList)) {
            return BaseResponse.failMessage(OutboundOrderConstant.NOT_EXIST_SHOP_SKU_NOT_ALLOW_OUTBOUND);
        }
        List<Integer> shopSkuIdList = outboundOrderShopSkuList.stream().map(OutboundOrderShopSku -> OutboundOrderShopSku.getShopSkuId()).collect(Collectors.toList());
        ListOutboundShopSkuRequest listOutboundShopSkuRequest=new ListOutboundShopSkuRequest();
        listOutboundShopSkuRequest.setShopId(outboundOrder.getOutboundShopId());
        listOutboundShopSkuRequest.setShopSkuIdList(shopSkuIdList);
        List<ListOutboundShopSkuResponse> outboundShopSkuList = shopSkuService.listOutboundShopSku(listOutboundShopSkuRequest);
        //校验库存是否满足出库条件
        SbErroEntity sbErroEntity = new SbErroEntity();
        List<UpdateShopSkuInventoryQuantityRequest> updateShopSkuInventoryQuantityRequestList = new ArrayList<>();
        for (OutboundOrderShopSku outboundOrderShopSku :
                outboundOrderShopSkuList) {
            ListOutboundShopSkuResponse outboundShopSku = getShopSku(outboundOrderShopSku.getShopSkuId(), outboundShopSkuList);
            if (outboundShopSku == null) {
                sbErroEntity.append("店铺skuId：" + outboundOrderShopSku.getShopSkuId() + "对应的仓库sku不存在");
                continue;
            }
            Integer inventoryQuantity = MathUtil.subtractInteger(outboundShopSku.getInventoryQuantity(), outboundOrderShopSku.getOutboundQuantity());
            if (inventoryQuantity < 0) {
                sbErroEntity.append(String.format("出库失败，店铺sku[%s]对应的仓库sku[%s]库存不足", outboundShopSku.getShopSku(), outboundShopSku.getOutboundShopSku()));
                continue;
            }
            if (sbErroEntity.isFail()) {
                //如果有错误信息就不执行后面的操作了
                continue;
            }
            UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequest = new UpdateShopSkuInventoryQuantityRequest();
            updateShopSkuInventoryQuantityRequest.setChangeTypeEnum(InventoryChangeRecordConstant.ChangeTypeEnum.OUT_BOUND);
            updateShopSkuInventoryQuantityRequest.setDealUserId(dealUserId);
            updateShopSkuInventoryQuantityRequest.setQuantity(outboundOrderShopSku.getOutboundQuantity());
            updateShopSkuInventoryQuantityRequest.setShopSkuId(outboundShopSku.getOutboundShopSkuId());
            ShopSku shopSku=new ShopSku();
            shopSku.setShopSku(outboundShopSku.getOutboundShopSku());
            shopSku.setInventoryQuantity(outboundShopSku.getInventoryQuantity());
            //预扣库存 避免一个生产单对应多个仓库sku计算错误的问题
            updateOutboundShopSkuInventoryQuantity(inventoryQuantity,outboundShopSku.getOutboundShopSkuId(),outboundShopSkuList);
            updateShopSkuInventoryQuantityRequest.setShopSkuInfo(shopSku);
            updateShopSkuInventoryQuantityRequest.setEntityId(outboundOrderShopSku.getId());
            updateShopSkuInventoryQuantityRequest.setMainEntityId(outboundOrderShopSku.getOutboundOrderId());
            updateShopSkuInventoryQuantityRequestList.add(updateShopSkuInventoryQuantityRequest);
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        for (UpdateShopSkuInventoryQuantityRequest updateShopSkuInventoryQuantityRequest :
                updateShopSkuInventoryQuantityRequestList) {
            shopSkuService.updateInventoryQuantity(updateShopSkuInventoryQuantityRequest);
        }
        //修改出库单状态为已出库
        updateOutboundOrderOutbound(id, dealUserId);
        return BaseResponse.success();
    }

    private void updateOutboundShopSkuInventoryQuantity(Integer inventoryQuantity, Integer outboundShopSkuId, List<ListOutboundShopSkuResponse> outboundShopSkuList) {
        outboundShopSkuList.stream().filter(item->item.getOutboundShopSkuId().equals(outboundShopSkuId)).forEach(item->item.setInventoryQuantity(inventoryQuantity));
    }

    private ListOutboundShopSkuResponse getShopSku(Integer shopSkuId, List<ListOutboundShopSkuResponse> shopSkuList) {
        for (ListOutboundShopSkuResponse shopSku :
                shopSkuList) {
            if (shopSku.getShopSkuId().equals(shopSkuId)) {
                return shopSku;
            }
        }
        return null;
    }

    private void updateOutboundOrderOutbound(Integer id, Integer dealUserId) {
        OutboundOrder outboundOrder = new OutboundOrder();
        outboundOrder.setId(id);
        outboundOrder.setStatus(OutboundOrderConstant.StatusEnum.OUTBOUND.getStatus());
        outboundOrder.setOutboundTime(new Date());
        outboundOrder.setUpdateTime(new Date());
        outboundOrder.setUpdateBy(dealUserId);
        customOutboundOrderMapper.updateByPrimaryKeySelective(outboundOrder);
    }

    @Override
    public OutboundOrder getOutboundOrderById(Integer id) {
        if (id == null) {
            return null;
        }
        return customOutboundOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * @param fbaPackingList
     * @param outboundShopId
     * @param dealUserId
     * @return
     * @description fba装箱单生成出库单
     * @author baixueping
     * @date 2020/8/4 14:42
     */
    @Override
    public BaseResponse generateOutboundOrder(FbaPackingList fbaPackingList, Integer outboundShopId, Integer dealUserId) {
        if (existEnableOutboundOrderByFbaPackingListId(fbaPackingList.getId())) {
            return BaseResponse.failMessage(OutboundOrderConstant.FBA_PACKING_LIST_ID_EXIST);
        }
        //生成出库单
        OutboundOrder outboundOrder = new OutboundOrder();
        outboundOrder.setType(OutboundOrderConstant.TypeEnum.FBA_PACKING_LIST_OUTBOUND.getType());
        outboundOrder.setShopId(fbaPackingList.getShopId());
        outboundOrder.setOutboundShopId(outboundShopId);
        outboundOrder.setStatus(OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus());
        outboundOrder.setBatchNumber(getBatchNumber());
        outboundOrder.setCreateBy(dealUserId);
        outboundOrder.setCreateTime(outboundOrder.getOutboundTime());
        outboundOrder.setFbaNo(fbaPackingList.getShipmentId());
        outboundOrder.setFbaPackingListId(fbaPackingList.getId());
        customOutboundOrderMapper.insertSelective(outboundOrder);
        //生成出库单店铺sku
        customOutboundOrderShopSkuMapper.generateOutboundOrderShopSku(fbaPackingList.getId(), outboundOrder.getId(), dealUserId);
        return BaseResponse.success();
    }

    private boolean existEnableOutboundOrderByFbaPackingListId(Integer fbaPackingListId) {
        if (fbaPackingListId == null) {
            return false;
        }
        OutboundOrderExample example = new OutboundOrderExample();
        example.createCriteria().andFbaPackingListIdEqualTo(fbaPackingListId).andStatusNotEqualTo(OutboundOrderConstant.StatusEnum.CANCEL.getStatus());
        return customOutboundOrderMapper.countByExample(example) > 0;
    }

    private String getBatchNumber() {
        String batchNumberFirst = "CKD" + DateUtil.getFormatStryyyyMMdd(new Date());
        OutboundOrderExample example = new OutboundOrderExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customOutboundOrderMapper.countByExample(example);
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
        OutboundOrderExample example = new OutboundOrderExample();
        example.createCriteria().andBatchNumberEqualTo(batchNumber);
        return customOutboundOrderMapper.countByExample(example) > 0;
    }
}
