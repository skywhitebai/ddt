package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.OutboundOrderConstant;
import com.sky.ddt.common.constant.OutboundOrderShopSkuConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.dao.custom.CustomOutboundOrderShopSkuMapper;
import com.sky.ddt.dto.outboundOrderShopSku.request.ListOutboundOrderShopSkuRequest;
import com.sky.ddt.dto.outboundOrderShopSku.request.SaveOutboundOrderShopSkuRequest;
import com.sky.ddt.dto.outboundOrderShopSku.request.SaveOutboundQuantityRequest;
import com.sky.ddt.dto.outboundOrderShopSku.response.ListOutboundOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.OutboundOrder;
import com.sky.ddt.entity.OutboundOrderShopSku;
import com.sky.ddt.entity.OutboundOrderShopSkuExample;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.IOutboundOrderService;
import com.sky.ddt.service.IOutboundOrderShopSkuService;
import com.sky.ddt.service.IShopSkuService;
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
 * @description 出库单店铺sku服务
 * @date 2020/5/12 9:54
 */
@Service
public class OutboundOrderShopSkuService implements IOutboundOrderShopSkuService {
    @Autowired
    CustomOutboundOrderShopSkuMapper customOutboundOrderShopSkuMapper;
    @Autowired
    IOutboundOrderService outboundOrderService;
    @Autowired
    IShopSkuService shopSkuService;

    /**
     * @param outboundOrderId@return
     * @description 判断出库单是否存在店铺sku
     * @author baixueping
     * @date 2020/5/12 11:09
     */
    @Override
    public boolean existOutboundOrderShopSku(Integer outboundOrderId) {
        if (outboundOrderId == null) {
            return false;
        }
        OutboundOrderShopSkuExample example = new OutboundOrderShopSkuExample();
        example.createCriteria().andOutboundOrderIdEqualTo(outboundOrderId);
        return customOutboundOrderShopSkuMapper.countByExample(example) > 0;

    }

    /**
     * @param outboundOrderId@return
     * @description 查询出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 11:40
     */
    @Override
    public List<OutboundOrderShopSku> listOutboundOrderShopSku(Integer outboundOrderId) {
        if(outboundOrderId==null){
            return null;
        }
        OutboundOrderShopSkuExample example=new OutboundOrderShopSkuExample();
        example.createCriteria().andOutboundOrderIdEqualTo(outboundOrderId);
        return customOutboundOrderShopSkuMapper.selectByExample(example);
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 13:05
     */
    @Override
    public BaseResponse saveOutboundOrderShopSku(SaveOutboundOrderShopSkuRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        OutboundOrderShopSku outboundOrderShopSkuOld = null;
        if (params.getId() != null) {
            outboundOrderShopSkuOld = getOutboundOrderShopSkuById(params.getId());
            if (outboundOrderShopSkuOld == null) {
                sbErroEntity.append(OutboundOrderShopSkuConstant.ID_NOT_EXIST);
            }
        }
        //判断盘点单id是否存在
        OutboundOrder outboundOrder = outboundOrderService.getOutboundOrderById(params.getOutboundOrderId());
        if (outboundOrder == null) {
            sbErroEntity.append(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_NOT_EXIST);
        } else if (!OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus().equals(outboundOrder.getStatus())) {
            sbErroEntity.append(OutboundOrderShopSkuConstant.ONLY_PENDING_OUTBOUND_ALLOW_SAVE_SHOP_SKU);
        } else if (outboundOrderShopSkuOld != null) {
            if (!outboundOrderShopSkuOld.getOutboundOrderId().equals(params.getOutboundOrderId())) {
                sbErroEntity.append(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_NOT_ALLOW_CHANGE);
            }
        }
        //判断shopSku是否存在
        ShopSku shopSku = shopSkuService.getShopSkuByShopSku(params.getShopSku());
        if (shopSku == null) {
            sbErroEntity.append(OutboundOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
        } else if (outboundOrder != null && !outboundOrder.getShopId().equals(shopSku.getShopId())) {
            sbErroEntity.append(OutboundOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
        } else if (existOutboundOrderShopSku(params.getOutboundOrderId(), params.getId(), shopSku.getShopSkuId())) {
            sbErroEntity.append(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_SHOP_SKU_EXIST);
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        OutboundOrderShopSku outboundOrderShopSku = new OutboundOrderShopSku();
        BeanUtils.copyProperties(params, outboundOrderShopSku);
        outboundOrderShopSku.setShopSkuId(shopSku.getShopSkuId());
        if (params.getId() == null) {
            outboundOrderShopSku.setCreateTime(new Date());
            outboundOrderShopSku.setCreateBy(dealUserId);
            customOutboundOrderShopSkuMapper.insertSelective(outboundOrderShopSku);
        } else {
            outboundOrderShopSku.setUpdateBy(dealUserId);
            outboundOrderShopSku.setUpdateTime(new Date());
            customOutboundOrderShopSkuMapper.updateByPrimaryKeySelective(outboundOrderShopSku);
        }
        return BaseResponse.success();
    }

    /**
     * @param id@return
     * @description 删除出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 13:16
     */
    @Override
    public BaseResponse deleteOutboundOrderShopSku(Integer id) {
        //获取盘点单店铺sku信息
        if (id == null) {
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.ID_EMPTY);
        }
        OutboundOrderShopSku outboundOrderShopSku = customOutboundOrderShopSkuMapper.selectByPrimaryKey(id);
        if (outboundOrderShopSku == null) {
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.ID_NOT_EXIST);
        }
        OutboundOrder outboundOrder = outboundOrderService.getOutboundOrderById(outboundOrderShopSku.getOutboundOrderId());
        if (outboundOrder == null) {
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_NOT_EXIST);
        }
        if (!OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus().equals(outboundOrder.getStatus())) {
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.ONLY_PENDING_OUTBOUND_ALLOW_DELETE_SHOP_SKU);
        }
        customOutboundOrderShopSkuMapper.deleteByPrimaryKey(id);
        return BaseResponse.success();
    }

    /**
     * @param file
     * @param outboundOrderId
     * @param dealUserId      @return
     * @description 导入出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 14:08
     */
    @Override
    public BaseResponse importOutboundOrderShopSku(MultipartFile file, Integer outboundOrderId, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        OutboundOrder outboundOrder=outboundOrderService.getOutboundOrderById(outboundOrderId);
        if(outboundOrder==null){
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_NOT_EXIST);
        }else if(!OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus().equals(outboundOrder.getStatus())){
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.ONLY_PENDING_OUTBOUND_ALLOW_IMPORT_SHOP_SKU);
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
            StringBuilder sbErroItem = new StringBuilder();
            if (StringUtils.isEmpty(map.get("店铺sku"))) {
                sbErroItem.append(",").append(OutboundOrderShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(OutboundOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    if (!shopSku.getShopId().equals(outboundOrder.getShopId())) {
                        sbErroItem.append(",").append(OutboundOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
                    } else {
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("出库数量"))) {
                sbErroItem.append(",").append(OutboundOrderShopSkuConstant.OUTBOUND_QUANTITY_EMPTY);
            } else {
                Integer outboundQuantity = MathUtil.strToInteger(map.get("出库数量"));
                if (outboundQuantity == null | outboundQuantity <= 0) {
                    sbErroItem.append(",").append(OutboundOrderShopSkuConstant.OUTBOUND_QUANTITY_ERRO);
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
            Integer outboundQuantity = MathUtil.strToInteger(map.get("出库数量"));
            //判断入库单是否有此店铺sku
            Integer shopSkuId = MathUtil.strToInteger(map.get("shopSkuId"));
            OutboundOrderShopSku outboundOrderShopSkuOld = getOutboundOrderShopSku(outboundOrderId, shopSkuId);
            OutboundOrderShopSku outboundOrderShopSku = new OutboundOrderShopSku();
            outboundOrderShopSku.setOutboundQuantity(outboundQuantity);
            if (outboundOrderShopSkuOld != null) {
                outboundOrderShopSku.setUpdateTime(new Date());
                outboundOrderShopSku.setUpdateBy(dealUserId);
                outboundOrderShopSku.setId(outboundOrderShopSkuOld.getId());
                customOutboundOrderShopSkuMapper.updateByPrimaryKeySelective(outboundOrderShopSku);
            } else {
                outboundOrderShopSku.setOutboundOrderId(outboundOrderId);
                outboundOrderShopSku.setShopSkuId(shopSkuId);
                outboundOrderShopSku.setCreateBy(dealUserId);
                outboundOrderShopSku.setCreateTime(new Date());
                customOutboundOrderShopSkuMapper.insertSelective(outboundOrderShopSku);
            }
        }
        return BaseResponse.success();
    }

    /**
     * @param outboundOrderId@return
     * @description 导出出库单店铺sku信息
     * @author baixueping
     * @date 2020/5/12 14:15
     */
    @Override
    public List<ListOutboundOrderShopSkuResponse> listOutboundOrderShopSkuByOutboundOrderId(Integer outboundOrderId) {
        if (outboundOrderId == null) {
            return new ArrayList<ListOutboundOrderShopSkuResponse>();
        }
        ListOutboundOrderShopSkuRequest listOutboundOrderShopSkuRequest = new ListOutboundOrderShopSkuRequest();
        listOutboundOrderShopSkuRequest.setOutboundOrderId(outboundOrderId);
        return customOutboundOrderShopSkuMapper.listOutboundOrderShopSku(listOutboundOrderShopSkuRequest);
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存出库数量
     * @author baixueping
     * @date 2020/7/17 11:14
     */
    @Override
    public BaseResponse saveOutboundQuantity(SaveOutboundQuantityRequest params, Integer dealUserId) {
        OutboundOrderShopSku outboundOrderShopSku=customOutboundOrderShopSkuMapper.selectByPrimaryKey(params.getId());
        if(outboundOrderShopSku==null){
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.ID_NOT_EXIST);
        }
        OutboundOrder outboundOrder=outboundOrderService.getOutboundOrderById(outboundOrderShopSku.getOutboundOrderId());
        if (outboundOrder == null) {
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_NOT_EXIST);
        } else if (!OutboundOrderConstant.StatusEnum.PENDING_OUTBOUND.getStatus().equals(outboundOrder.getStatus())) {
            return BaseResponse.failMessage(OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_NOT_ALLOW_CHANGE);
        }
        OutboundOrderShopSku outboundOrderShopSkuUpdate=new OutboundOrderShopSku();
        outboundOrderShopSkuUpdate.setId(params.getId());
        outboundOrderShopSkuUpdate.setOutboundQuantity(params.getOutboundQuantity());
        outboundOrderShopSkuUpdate.setUpdateBy(dealUserId);
        outboundOrderShopSkuUpdate.setUpdateTime(new Date());
        customOutboundOrderShopSkuMapper.updateByPrimaryKeySelective(outboundOrderShopSkuUpdate);
        return BaseResponse.success();
    }

    private OutboundOrderShopSku getOutboundOrderShopSku(Integer outboundOrderId, Integer shopSkuId) {
        if (outboundOrderId == null || shopSkuId == null) {
            return null;
        }
        OutboundOrderShopSkuExample example = new OutboundOrderShopSkuExample();
        example.createCriteria().andOutboundOrderIdEqualTo(outboundOrderId).andShopSkuIdEqualTo(shopSkuId);
        List<OutboundOrderShopSku> list = customOutboundOrderShopSkuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    private boolean existOutboundOrderShopSku(Integer outboundOrderId, Integer id, Integer shopSkuId) {
        OutboundOrderShopSkuExample example = new OutboundOrderShopSkuExample();
        if (id == null) {
            example.createCriteria().andOutboundOrderIdEqualTo(outboundOrderId).andShopSkuIdEqualTo(shopSkuId);
        } else {
            example.createCriteria().andOutboundOrderIdEqualTo(outboundOrderId).andShopSkuIdEqualTo(shopSkuId).andIdNotEqualTo(id);
        }
        return customOutboundOrderShopSkuMapper.countByExample(example) > 0;
    }

    private OutboundOrderShopSku getOutboundOrderShopSkuById(Integer id) {
        if (id == null) {
            return null;
        }
        return customOutboundOrderShopSkuMapper.selectByPrimaryKey(id);
    }

    /**
     * @param params@return
     * @description 分页查询出库单店铺sku
     * @author baixueping
     * @date 2020/5/12 12:53
     */
    @Override
    public PageInfo<ListOutboundOrderShopSkuResponse> listOutboundOrderShopSku(ListOutboundOrderShopSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListOutboundOrderShopSkuResponse> list = customOutboundOrderShopSkuMapper.listOutboundOrderShopSku(params);
        PageInfo<ListOutboundOrderShopSkuResponse> page = new PageInfo<ListOutboundOrderShopSkuResponse>(list);
        return page;
    }
}
