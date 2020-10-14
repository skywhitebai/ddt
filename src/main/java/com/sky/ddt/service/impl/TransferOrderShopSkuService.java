package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.common.constant.TransferOrderConstant;
import com.sky.ddt.common.constant.TransferOrderShopSkuConstant;
import com.sky.ddt.dao.custom.CustomTransferOrderShopSkuMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transferOrderShopSku.request.ListTransferOrderShopSkuRequest;
import com.sky.ddt.dto.transferOrderShopSku.request.SaveTransferOrderShopSkuRequest;
import com.sky.ddt.dto.transferOrderShopSku.request.SaveTransferQuantityRequest;
import com.sky.ddt.dto.transferOrderShopSku.response.ListTransferOrderShopSkuResponse;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.TransferOrder;
import com.sky.ddt.entity.TransferOrderShopSku;
import com.sky.ddt.entity.TransferOrderShopSkuExample;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.ITransferOrderService;
import com.sky.ddt.service.ITransferOrderShopSkuService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author baixueping
 * @description 调拨服务
 * @date 2020/8/28 16:31
 */
@Service
public class TransferOrderShopSkuService implements ITransferOrderShopSkuService {
    @Autowired
    CustomTransferOrderShopSkuMapper customTransferOrderShopSkuMapper;
    @Autowired
    ITransferOrderService transferOrderService;
    @Autowired
    IShopSkuService shopSkuService;

    @Override
    public boolean existTransferOrderShopSku(Integer transferOrderId) {
        if (transferOrderId == null) {
            return false;
        }
        TransferOrderShopSkuExample example = new TransferOrderShopSkuExample();
        example.createCriteria().andTransferOrderIdEqualTo(transferOrderId);
        return customTransferOrderShopSkuMapper.countByExample(example) > 0;
    }

    /**
     * @param params@return
     * @description 分页查询调拨单店铺sku数据
     * @author baixueping
     * @date 2020/9/1 11:10
     */
    @Override
    public PageInfo<ListTransferOrderShopSkuResponse> listTransferOrderShopSku(ListTransferOrderShopSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListTransferOrderShopSkuResponse> list = customTransferOrderShopSkuMapper.listTransferOrderShopSku(params);
        PageInfo<ListTransferOrderShopSkuResponse> page = new PageInfo<>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存调拨单店铺sku
     * @author baixueping
     * @date 2020/9/1 12:50
     */
    @Override
    public BaseResponse saveTransferOrderShopSku(SaveTransferOrderShopSkuRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        TransferOrderShopSku transferOrderShopSkuOld = null;
        if (params.getId() != null) {
            transferOrderShopSkuOld = getTransferOrderShopSkuById(params.getId());
            if (transferOrderShopSkuOld == null) {
                sbErroEntity.append(TransferOrderShopSkuConstant.ID_NOT_EXIST);
            }
        }
        //判断调拨单id是否存在
        TransferOrder transferOrder = transferOrderService.getTransferOrderById(params.getTransferOrderId());
        if (transferOrder == null) {
            sbErroEntity.append(TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_NOT_EXIST);
        } else if (!TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus().equals(transferOrder.getStatus())) {
            sbErroEntity.append(TransferOrderShopSkuConstant.ONLY_PENDING_TRANSFER_ALLOW_SAVE_SHOP_SKU);
        } else if (transferOrderShopSkuOld != null) {
            if (!transferOrderShopSkuOld.getTransferOrderId().equals(params.getTransferOrderId())) {
                sbErroEntity.append(TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_NOT_ALLOW_CHANGE);
            }
        }
        ShopSku shopSkuFrom = null;
        ShopSku shopSkuTo = null;
        if (transferOrder != null) {
            shopSkuFrom = shopSkuService.getShopSkuByShopSku(params.getShopSkuFrom());
            if (shopSkuFrom == null) {
                sbErroEntity.append(TransferOrderShopSkuConstant.SHOP_SKU_FROM_NOT_EXIST);
            } else if (!transferOrder.getShopIdFrom().equals(shopSkuFrom.getShopId())) {
                sbErroEntity.append(TransferOrderShopSkuConstant.SHOP_SKU_FROM_SHOP_ERRO);
            }
            shopSkuTo = shopSkuService.getShopSkuByShopSku(params.getShopSkuTo());
            //判断调入店铺是否存在店铺sku
            if (shopSkuTo == null) {
                sbErroEntity.append(TransferOrderShopSkuConstant.SHOP_SKU_TO_NOT_EXIST);
            } else if (!transferOrder.getShopIdTo().equals(shopSkuTo.getShopId())) {
                sbErroEntity.append(TransferOrderShopSkuConstant.SHOP_SKU_TO_SHOP_ERRO);
            } else if (shopSkuFrom != null && !shopSkuFrom.getSkuId().equals(shopSkuTo.getSkuId())) {
                sbErroEntity.append(TransferOrderShopSkuConstant.SHOP_SKU_FROM_SHOP_SKU_TO_SKU_ID_NOT_SAME);
            }

            if (shopSkuFrom != null && shopSkuTo != null
                    && existTransferOrderShopSkuFromTo(params.getTransferOrderId(), params.getId(), shopSkuFrom.getShopSkuId(), shopSkuTo.getShopSkuId())) {
                sbErroEntity.append(TransferOrderShopSkuConstant.TRANSFER_ORDER_SHOP_SKU_FROM_EXIST);
            }
        }

        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        TransferOrderShopSku transferOrderShopSku = new TransferOrderShopSku();
        BeanUtils.copyProperties(params, transferOrderShopSku);
        transferOrderShopSku.setShopSkuIdFrom(shopSkuFrom.getShopSkuId());
        transferOrderShopSku.setShopSkuIdTo(shopSkuTo.getShopSkuId());
        transferOrderShopSku.setUpdateBy(dealUserId);
        transferOrderShopSku.setUpdateTime(new Date());
        if (params.getId() == null) {
            transferOrderShopSku.setCreateTime(new Date());
            transferOrderShopSku.setCreateBy(dealUserId);
            customTransferOrderShopSkuMapper.insertSelective(transferOrderShopSku);
        } else {
            customTransferOrderShopSkuMapper.updateByPrimaryKeySelective(transferOrderShopSku);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse deleteTransferOrderShopSku(Integer id) {
        //获取盘点单店铺sku信息
        if (id == null) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.ID_EMPTY);
        }
        TransferOrderShopSku transferOrderShopSku = customTransferOrderShopSkuMapper.selectByPrimaryKey(id);
        if (transferOrderShopSku == null) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.ID_NOT_EXIST);
        }
        TransferOrder transferOrder = transferOrderService.getTransferOrderById(transferOrderShopSku.getTransferOrderId());
        if (transferOrder == null) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_NOT_EXIST);
        }
        if (!TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus().equals(transferOrder.getStatus())) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.ONLY_PENDING_TRANSFER_ALLOW_DELETE_SHOP_SKU);
        }
        customTransferOrderShopSkuMapper.deleteByPrimaryKey(id);
        return BaseResponse.success();
    }

    /**
     * @param transferOrderId@return
     * @description 根据调拨单id查询调拨单店铺sku信息
     * @author baixueping
     * @date 2020/9/1 15:00
     */
    @Override
    public List<TransferOrderShopSku> listTransferOrderShopSku(Integer transferOrderId) {
        if (transferOrderId == null) {
            return null;
        }
        TransferOrderShopSkuExample example = new TransferOrderShopSkuExample();
        example.createCriteria().andTransferOrderIdEqualTo(transferOrderId);
        return customTransferOrderShopSkuMapper.selectByExample(example);
    }

    /**
     * @param file
     * @param transferOrderId
     * @param dealUserId      @return
     * @description 导入调拨单店铺sku
     * @author baixueping
     * @date 2020/9/1 15:54
     */
    @Override
    public BaseResponse importTransferOrderShopSku(MultipartFile file, Integer transferOrderId, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        TransferOrder transferOrder = transferOrderService.getTransferOrderById(transferOrderId);
        if (transferOrder == null) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_NOT_EXIST);
        } else if (!TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus().equals(transferOrder.getStatus())) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.ONLY_PENDING_TRANSFER_ALLOW_IMPORT_SHOP_SKU);
        }

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
            SbErroEntity sbErroItem = new SbErroEntity();
            ShopSku shopSkuFrom = null;
            ShopSku shopSkuTo = null;
            if (StringUtils.isEmpty(map.get("调出店铺sku"))) {
                sbErroItem.append(TransferOrderShopSkuConstant.SHOP_SKU_FROM_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                shopSkuFrom = shopSkuService.getShopSkuByShopSku(map.get("调出店铺sku"));
                if (shopSkuFrom == null) {
                    sbErroItem.append(TransferOrderShopSkuConstant.SHOP_SKU_FROM_EMPTY);
                } else if (!transferOrder.getShopIdFrom().equals(shopSkuFrom.getShopId())) {
                    sbErroItem.append(TransferOrderShopSkuConstant.SHOP_SKU_FROM_SHOP_ERRO);
                } else {
                    map.put("shopSkuIdFrom", shopSkuFrom.getShopSkuId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("调入店铺sku"))) {
                sbErroItem.append(TransferOrderShopSkuConstant.SHOP_SKU_TO_EMPTY);
            }else{
                shopSkuTo = shopSkuService.getShopSkuByShopSku(map.get("调入店铺sku"));
                //判断调入店铺是否存在店铺sku
                if (shopSkuTo == null) {
                    sbErroItem.append(TransferOrderShopSkuConstant.SHOP_SKU_TO_NOT_EXIST);
                } else if (!transferOrder.getShopIdTo().equals(shopSkuTo.getShopId())) {
                    sbErroItem.append(TransferOrderShopSkuConstant.SHOP_SKU_TO_SHOP_ERRO);
                } else if (shopSkuFrom != null && !shopSkuFrom.getSkuId().equals(shopSkuTo.getSkuId())) {
                    sbErroItem.append(TransferOrderShopSkuConstant.SHOP_SKU_FROM_SHOP_SKU_TO_SKU_ID_NOT_SAME);
                }else{
                    map.put("shopSkuIdTo", shopSkuTo.getShopSkuId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("调拨数量"))) {
                sbErroItem.append(",").append(TransferOrderShopSkuConstant.TRANSFER_QUANTITY_EMPTY);
            } else {
                Integer transferQuantity = MathUtil.strToInteger(map.get("调拨数量"));
                if (transferQuantity == null | transferQuantity <= 0) {
                    sbErroItem.append(",").append(TransferOrderShopSkuConstant.TRANSFER_QUANTITY_ERRO);
                }
            }
            if (sbErroItem.isFail()) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem.getMessage());
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
            Integer transferQuantity = MathUtil.strToInteger(map.get("调拨数量"));
            //判断入库单是否有此店铺sku
            Integer shopSkuIdFrom = MathUtil.strToInteger(map.get("shopSkuIdFrom"));
            Integer shopSkuIdTo = MathUtil.strToInteger(map.get("shopSkuIdTo"));
            TransferOrderShopSku transferOrderShopSkuOld = getTransferOrderShopSku(transferOrderId, shopSkuIdFrom,shopSkuIdTo);
            TransferOrderShopSku transferOrderShopSku = new TransferOrderShopSku();
            transferOrderShopSku.setTransferQuantity(transferQuantity);
            transferOrderShopSku.setShopSkuIdTo(shopSkuIdTo);
            transferOrderShopSku.setUpdateTime(new Date());
            transferOrderShopSku.setUpdateBy(dealUserId);
            if (transferOrderShopSkuOld != null) {
                transferOrderShopSku.setId(transferOrderShopSkuOld.getId());
                customTransferOrderShopSkuMapper.updateByPrimaryKeySelective(transferOrderShopSku);
            } else {
                transferOrderShopSku.setTransferOrderId(transferOrderId);
                transferOrderShopSku.setShopSkuIdFrom(shopSkuIdFrom);
                transferOrderShopSku.setCreateBy(dealUserId);
                transferOrderShopSku.setCreateTime(new Date());
                customTransferOrderShopSkuMapper.insertSelective(transferOrderShopSku);
            }
        }
        return BaseResponse.success();
    }

    @Override
    public List<ListTransferOrderShopSkuResponse> listTransferOrderShopSkuByTransferOrderId(Integer transferOrderId) {
        if (transferOrderId == null) {
            return new ArrayList<ListTransferOrderShopSkuResponse>();
        }
        ListTransferOrderShopSkuRequest listTransferOrderShopSkuRequest = new ListTransferOrderShopSkuRequest();
        listTransferOrderShopSkuRequest.setTransferOrderId(transferOrderId);
        return customTransferOrderShopSkuMapper.listTransferOrderShopSku(listTransferOrderShopSkuRequest);

    }

    @Override
    public BaseResponse saveTransferQuantity(SaveTransferQuantityRequest params, Integer dealUserId) {
        TransferOrderShopSku transferOrderShopSku = customTransferOrderShopSkuMapper.selectByPrimaryKey(params.getId());
        if (transferOrderShopSku == null) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.ID_NOT_EXIST);
        }
        TransferOrder transferOrder = transferOrderService.getTransferOrderById(transferOrderShopSku.getTransferOrderId());
        if (transferOrder == null) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_NOT_EXIST);
        } else if (!TransferOrderConstant.StatusEnum.PENDING_TRANSFER.getStatus().equals(transferOrder.getStatus())) {
            return BaseResponse.failMessage(TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_NOT_ALLOW_CHANGE);
        }
        TransferOrderShopSku transferOrderShopSkuUpdate = new TransferOrderShopSku();
        transferOrderShopSkuUpdate.setId(params.getId());
        transferOrderShopSkuUpdate.setTransferQuantity(params.getTransferQuantity());
        transferOrderShopSkuUpdate.setUpdateBy(dealUserId);
        transferOrderShopSkuUpdate.setUpdateTime(new Date());
        customTransferOrderShopSkuMapper.updateByPrimaryKeySelective(transferOrderShopSkuUpdate);
        return BaseResponse.success();
    }

    private TransferOrderShopSku getTransferOrderShopSku(Integer transferOrderId, Integer shopSkuIdFrom, Integer shopSkuIdTo) {
        if (transferOrderId == null || shopSkuIdFrom == null|| shopSkuIdTo == null) {
            return null;
        }
        TransferOrderShopSkuExample example = new TransferOrderShopSkuExample();
        example.createCriteria().andTransferOrderIdEqualTo(transferOrderId).andShopSkuIdFromEqualTo(shopSkuIdFrom).andShopSkuIdToEqualTo(shopSkuIdTo);
        List<TransferOrderShopSku> list = customTransferOrderShopSkuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    private boolean existTransferOrderShopSkuFromTo(Integer transferOrderId, Integer id, Integer shopSkuIdFrom, Integer shopSkuIdTo) {
        TransferOrderShopSkuExample example = new TransferOrderShopSkuExample();
        if (id == null) {
            example.createCriteria().andTransferOrderIdEqualTo(transferOrderId).andShopSkuIdFromEqualTo(shopSkuIdFrom).andShopSkuIdToEqualTo(shopSkuIdTo);
        } else {
            example.createCriteria().andTransferOrderIdEqualTo(transferOrderId).andShopSkuIdFromEqualTo(shopSkuIdFrom).andShopSkuIdToEqualTo(shopSkuIdTo).andIdNotEqualTo(id);
        }
        return customTransferOrderShopSkuMapper.countByExample(example) > 0;
    }

    private TransferOrderShopSku getTransferOrderShopSkuById(Integer id) {
        if (id == null) {
            return null;
        }
        return customTransferOrderShopSkuMapper.selectByPrimaryKey(id);
    }
}
