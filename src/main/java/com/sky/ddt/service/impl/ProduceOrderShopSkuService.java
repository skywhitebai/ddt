package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ProduceOrderConstant;
import com.sky.ddt.common.constant.ProduceOrderShopSkuConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.dao.custom.CustomLabelPrintShopSkuMapper;
import com.sky.ddt.dao.custom.CustomProduceOrderShopSkuMapper;
import com.sky.ddt.dto.produceOrderShopSku.request.*;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuProductionQuantityResponse;
import com.sky.ddt.dto.produceOrderShopSku.response.ListProduceOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.ProduceOrder;
import com.sky.ddt.entity.ProduceOrderShopSku;
import com.sky.ddt.entity.ProduceOrderShopSkuExample;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.IProduceOrderService;
import com.sky.ddt.service.IProduceOrderShopSkuService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IWarehousingOrderShopSkuService;
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
 * @description 生产单店铺sku服务
 * @date 2020/4/1 11:22
 */
@Service
public class ProduceOrderShopSkuService implements IProduceOrderShopSkuService {
    @Autowired
    CustomProduceOrderShopSkuMapper customProduceOrderShopSkuMapper;
    @Autowired
    IProduceOrderService produceOrderService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IWarehousingOrderShopSkuService warehousingOrderShopSkuService;

    /**
     * @param produceOrderId@return
     * @description 判断生产单是否包含店铺sku
     * @author baixueping
     * @date 2020/4/1 11:29
     */
    @Override
    public boolean existProduceOrderShopSku(Integer produceOrderId) {
        if (produceOrderId == null) {
            return false;
        }
        ProduceOrderShopSkuExample produceOrderShopSkuExample = new ProduceOrderShopSkuExample();
        produceOrderShopSkuExample.createCriteria().andProduceOrderIdEqualTo(produceOrderId);
        return customProduceOrderShopSkuMapper.countByExample(produceOrderShopSkuExample) > 0;
    }

    /**
     * @param listProduceOrderShopSkuRequest@return
     * @description 查询生产单店铺sku
     * @author baixueping
     * @date 2020/4/1 15:36
     */
    @Override
    public PageInfo<ListProduceOrderShopSkuResponse> listProduceOrderShopSku(ListProduceOrderShopSkuRequest listProduceOrderShopSkuRequest) {
        PageHelper.startPage(listProduceOrderShopSkuRequest.getPage(), listProduceOrderShopSkuRequest.getRows(), true);
        List<ListProduceOrderShopSkuResponse> list = customProduceOrderShopSkuMapper.listProduceOrderShopSku(listProduceOrderShopSkuRequest);
        PageInfo<ListProduceOrderShopSkuResponse> page = new PageInfo<ListProduceOrderShopSkuResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存生产单店铺sku
     * @author baixueping
     * @date 2020/4/2 11:40
     */
    @Override
    public BaseResponse saveProduceOrderShopSku(SaveProduceOrderShopSkuRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        //如果是更新，则判断id是否存在
        ProduceOrderShopSku produceOrderShopSkuOld = null;
        if (params.getId() != null) {
            produceOrderShopSkuOld = getProduceOrderShopSkuById(params.getId());
            if (produceOrderShopSkuOld == null) {
                sbErroEntity.append(ProduceOrderShopSkuConstant.ID_NOT_EXIST);
            }
        }
        //判断生产单id是否存在
        ProduceOrder produceOrder = produceOrderService.getProduceOrderById(params.getProduceOrderId());
        if (produceOrder == null) {
            sbErroEntity.append(ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_NOT_EXIST);
        } else if (!ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(produceOrder.getStatus())) {
            sbErroEntity.append(ProduceOrderShopSkuConstant.PRODUCE_ORDER_NOT_ALLOW_WAREHOUSING);

        } else if (produceOrderShopSkuOld != null) {
            if (!produceOrderShopSkuOld.getProduceOrderId().equals(params.getProduceOrderId())) {
                sbErroEntity.append(ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_NOT_ALLOW_CHANGE);
            }
        }
        //判断shopSku是否存在
        ShopSku shopSku = shopSkuService.getShopSkuByShopSku(params.getShopSku());
        if (shopSku == null) {
            sbErroEntity.append(ProduceOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
        } else if (produceOrder != null && !shopSku.getShopId().equals(produceOrder.getShopId())) {
            sbErroEntity.append(ProduceOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
        } else {
            //判断生产单是否已经存在这个店铺sku
            if (existsShopSku(params.getProduceOrderId(),params.getId(), shopSku.getShopSkuId())) {
                sbErroEntity.append(ProduceOrderShopSkuConstant.PRODUCE_ORDER_SHOP_SKU_EXIST);
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        ProduceOrderShopSku produceOrderShopSku = new ProduceOrderShopSku();
        BeanUtils.copyProperties(params, produceOrderShopSku);
        produceOrderShopSku.setShopSkuId(shopSku.getShopSkuId());
        if (params.getId() == null) {
            produceOrderShopSku.setCreateTime(new Date());
            produceOrderShopSku.setCreateBy(dealUserId);
            customProduceOrderShopSkuMapper.insertSelective(produceOrderShopSku);
        } else {
            produceOrderShopSku.setUpdateBy(dealUserId);
            produceOrderShopSku.setUpdateTime(new Date());
            customProduceOrderShopSkuMapper.updateByPrimaryKeySelective(produceOrderShopSku);
        }
        return BaseResponse.success();
    }

    /**
     * @param id@return
     * @description 删除生产单店铺sku
     * @author baixueping
     * @date 2020/4/7 10:26
     */
    @Override
    public BaseResponse deleteProduceOrderShopSku(Integer id) {
        //只有待入库 且没有入库单的店铺sku允许删除
        if (id == null) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.ID_EMPTY);
        }
        ProduceOrderShopSku produceOrderShopSku = customProduceOrderShopSkuMapper.selectByPrimaryKey(id);
        if (produceOrderShopSku == null) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.ID_NOT_EXIST);
        }
        ProduceOrder produceOrder = produceOrderService.getProduceOrderById(produceOrderShopSku.getProduceOrderId());
        if (produceOrder != null) {
            if (!ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(produceOrder.getStatus())) {
                return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_SHOP_SKU_STATUS_NOT_ALLOW_DELETE);
            }
        }
        //判断入库单是否有此生产单的店铺sku
        if (warehousingOrderShopSkuService.existProduceOrderShopSku(produceOrderShopSku.getProduceOrderId(), produceOrderShopSku.getShopSkuId())) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_SHOP_SKU_WAREHOUSING_NOT_ALLOW_DELETE);
        }
        customProduceOrderShopSkuMapper.deleteByPrimaryKey(id);
        return BaseResponse.success();
    }

    /**
     * @param file
     * @param produceOrderId
     * @param dealUserId     @return
     * @description 导入生产单店铺sku
     * @author baixueping
     * @date 2020/4/26 16:10
     */
    @Override
    public BaseResponse importProduceOrderShopSku(MultipartFile file, Integer produceOrderId, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        if (produceOrderId == null) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_EMPTY);
        }
        ProduceOrder produceOrder = produceOrderService.getProduceOrderById(produceOrderId);
        if (produceOrder == null) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_NOT_EXIST);
        } else if (!ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(produceOrder.getStatus())) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_NOT_ALLOW_WAREHOUSING);
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
                sbErroItem.append(",").append(ProduceOrderShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(ProduceOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    if (!shopSku.getShopId().equals(produceOrder.getShopId())) {
                        sbErroItem.append(",").append(ProduceOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
                    } else {
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("生产数量"))) {
                sbErroItem.append(",").append(ProduceOrderShopSkuConstant.PRODUCTION_QUANTITY_EMPTY);
            } else {
                Integer produceQuantity = MathUtil.strToInteger(map.get("生产数量"));
                if (produceQuantity == null | produceQuantity <= 0) {
                    sbErroItem.append(",").append(ProduceOrderShopSkuConstant.PRODUCTION_QUANTITY_ERRO);
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
            Integer productionQuantity = MathUtil.strToInteger(map.get("生产数量"));
            //判断生产单是否有此店铺sku
            Integer shopSkuId = MathUtil.strToInteger(map.get("shopSkuId"));
            ProduceOrderShopSku produceOrderShopSkuOld = getProduceOrderShopSku(produceOrderId, shopSkuId);
            ProduceOrderShopSku produceOrderShopSku = new ProduceOrderShopSku();
            produceOrderShopSku.setProductionQuantity(productionQuantity);
            if (produceOrderShopSkuOld != null) {
                produceOrderShopSku.setUpdateTime(new Date());
                produceOrderShopSku.setUpdateBy(dealUserId);
                produceOrderShopSku.setId(produceOrderShopSkuOld.getId());
                customProduceOrderShopSkuMapper.updateByPrimaryKeySelective(produceOrderShopSku);
            } else {
                produceOrderShopSku.setProduceOrderId(produceOrderId);
                produceOrderShopSku.setShopSkuId(shopSkuId);
                produceOrderShopSku.setCreateBy(dealUserId);
                produceOrderShopSku.setCreateTime(new Date());
                customProduceOrderShopSkuMapper.insertSelective(produceOrderShopSku);
            }
        }
        return BaseResponse.success();
    }

    /**
     * @param produceOrderId@return
     * @description 查询生产单所有店铺
     * @author baixueping
     * @date 2020/4/27 15:56
     */
    @Override
    public List<ListProduceOrderShopSkuResponse> listProduceOrderShopSkuByProduceOrderId(Integer produceOrderId) {
        if (produceOrderId == null) {
            return new ArrayList<ListProduceOrderShopSkuResponse>();
        }
        ListProduceOrderShopSkuRequest listProduceOrderShopSkuRequest = new ListProduceOrderShopSkuRequest();
        listProduceOrderShopSkuRequest.setProduceOrderId(produceOrderId);
        return customProduceOrderShopSkuMapper.listProduceOrderShopSku(listProduceOrderShopSkuRequest);
    }

    /**
     * @param params
     * @param currentUserId
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2020/7/9 12:53
     */
    @Override
    public BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer currentUserId) {
        ProduceOrderShopSku produceOrderShopSku=customProduceOrderShopSkuMapper.selectByPrimaryKey(params.getId());
        if(produceOrderShopSku==null){
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.ID_NOT_EXIST);
        }
        ProduceOrder produceOrder=produceOrderService.getProduceOrderById(produceOrderShopSku.getProduceOrderId());
        if (produceOrder == null) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_NOT_EXIST);
        } else if (!ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(produceOrder.getStatus())) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_NOT_ALLOW_WAREHOUSING);
        }
        ProduceOrderShopSku produceOrderShopSkuUpdate=new ProduceOrderShopSku();
        produceOrderShopSkuUpdate.setId(params.getId());
        produceOrderShopSkuUpdate.setProductionQuantity(params.getProductionQuantity());
        produceOrderShopSkuUpdate.setUpdateBy(currentUserId);
        produceOrderShopSkuUpdate.setUpdateTime(new Date());
        customProduceOrderShopSkuMapper.updateByPrimaryKeySelective(produceOrderShopSkuUpdate);
        return BaseResponse.success();
    }

    @Override
    public PageInfo<ListProduceOrderShopSkuProductionQuantityResponse> listProduceOrderShopSkuProductionQuantity(ListProduceOrderShopSkuProductionQuantityRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListProduceOrderShopSkuProductionQuantityResponse> list = customProduceOrderShopSkuMapper.listProduceOrderShopSkuProductionQuantity(params);
        PageInfo<ListProduceOrderShopSkuProductionQuantityResponse> page = new PageInfo<ListProduceOrderShopSkuProductionQuantityResponse>(list);
        return page;
    }

    @Override
    public BaseResponse savePreWarehousingQuantity(SavePreWarehousingQuantityRequest params, Integer currentUserId) {
        ProduceOrderShopSku produceOrderShopSku=customProduceOrderShopSkuMapper.selectByPrimaryKey(params.getId());
        if(produceOrderShopSku==null){
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.ID_NOT_EXIST);
        }
        ProduceOrder produceOrder=produceOrderService.getProduceOrderById(produceOrderShopSku.getProduceOrderId());
        if (produceOrder == null) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_NOT_EXIST);
        } else if (!ProduceOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(produceOrder.getStatus())) {
            return BaseResponse.failMessage(ProduceOrderShopSkuConstant.PRODUCE_ORDER_NOT_ALLOW_WAREHOUSING);
        }
        ProduceOrderShopSku produceOrderShopSkuUpdate=new ProduceOrderShopSku();
        produceOrderShopSkuUpdate.setId(params.getId());
        produceOrderShopSkuUpdate.setPreWarehousingQuantity(params.getPreWarehousingQuantity());
        produceOrderShopSkuUpdate.setUpdateBy(currentUserId);
        produceOrderShopSkuUpdate.setUpdateTime(new Date());
        customProduceOrderShopSkuMapper.updateByPrimaryKeySelective(produceOrderShopSkuUpdate);
        return BaseResponse.success();
    }

    private ProduceOrderShopSku getProduceOrderShopSku(Integer produceOrderId, Integer shopSkuId) {
        if (produceOrderId == null || shopSkuId == null) {
            return null;
        }
        ProduceOrderShopSkuExample produceOrderShopSkuExample = new ProduceOrderShopSkuExample();
        produceOrderShopSkuExample.createCriteria().andProduceOrderIdEqualTo(produceOrderId).andShopSkuIdEqualTo(shopSkuId);
        List<ProduceOrderShopSku> list = customProduceOrderShopSkuMapper.selectByExample(produceOrderShopSkuExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    private boolean existsShopSku(Integer produceOrderId, Integer id, Integer shopSkuId) {
        ProduceOrderShopSkuExample produceOrderShopSkuExample = new ProduceOrderShopSkuExample();
        if (id == null) {
            produceOrderShopSkuExample.createCriteria().andShopSkuIdEqualTo(shopSkuId).andProduceOrderIdEqualTo(produceOrderId);
        } else {
            produceOrderShopSkuExample.createCriteria().andShopSkuIdEqualTo(shopSkuId).andIdNotEqualTo(id).andProduceOrderIdEqualTo(produceOrderId);
        }
        return customProduceOrderShopSkuMapper.countByExample(produceOrderShopSkuExample) > 0;
    }

    private ProduceOrderShopSku getProduceOrderShopSkuById(Integer id) {
        if (id == null) {
            return null;
        }
        return customProduceOrderShopSkuMapper.selectByPrimaryKey(id);
    }
}
