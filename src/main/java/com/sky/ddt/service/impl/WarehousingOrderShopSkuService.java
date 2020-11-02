package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.common.constant.WarehousingOrderConstant;
import com.sky.ddt.common.constant.WarehousingOrderShopSkuConstant;
import com.sky.ddt.dao.custom.CustomWarehousingOrderShopSkuMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrderShopSku.request.ListWarehousingOrderShopSkuRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.request.SaveWarehousingOrderShopSkuRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.request.SaveWarehousingQuantityRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.response.ListWarehousingOrderShopSkuResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IWarehousingOrderService;
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
 * @description 入库单店铺sku服务
 * @date 2020/4/23 16:13
 */
@Service
public class WarehousingOrderShopSkuService implements IWarehousingOrderShopSkuService {
    @Autowired
    CustomWarehousingOrderShopSkuMapper customWarehousingOrderShopSkuMapper;
    @Autowired
    IWarehousingOrderService warehousingOrderService;
    @Autowired
    IShopSkuService shopSkuService;

    /**
     * @param listWarehousingOrderShopSkuRequest@return
     * @description 列表查询入库单店铺sku
     * @author baixueping
     * @date 2020/4/23 17:06
     */
    @Override
    public PageInfo<ListWarehousingOrderShopSkuResponse> listWarehousingOrderShopSku(ListWarehousingOrderShopSkuRequest listWarehousingOrderShopSkuRequest) {
        PageHelper.startPage(listWarehousingOrderShopSkuRequest.getPage(), listWarehousingOrderShopSkuRequest.getRows(), true);
        List<ListWarehousingOrderShopSkuResponse> list = customWarehousingOrderShopSkuMapper.listWarehousingOrderShopSku(listWarehousingOrderShopSkuRequest);
        PageInfo<ListWarehousingOrderShopSkuResponse> page = new PageInfo<ListWarehousingOrderShopSkuResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存入库单店铺sku
     * @author baixueping
     * @date 2020/4/24 9:49
     */
    @Override
    public BaseResponse saveWarehousingOrderShopSku(SaveWarehousingOrderShopSkuRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        WarehousingOrderShopSku warehousingOrderShopSkuOld = null;
        if (params.getId() != null) {
            warehousingOrderShopSkuOld = getWarehousingOrderShopSkuById(params.getId());
            if (warehousingOrderShopSkuOld == null) {
                sbErroEntity.append(WarehousingOrderShopSkuConstant.ID_NOT_EXIST);
            }
        }
        //判断入库单id是否存在
        WarehousingOrder warehousingOrder = warehousingOrderService.getWarehousingOrderById(params.getWarehousingOrderId());
        if (warehousingOrder == null) {
            sbErroEntity.append(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_NOT_EXIST);
        } else if (!WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(warehousingOrder.getStatus())) {
            sbErroEntity.append(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_NOT_ALLOW_WAREHOUSING);
        } else if (warehousingOrderShopSkuOld != null) {
            if (!warehousingOrderShopSkuOld.getWarehousingOrderId().equals(params.getWarehousingOrderId())) {
                sbErroEntity.append(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_NOT_ALLOW_CHANGE);
            }
        }
        //判断shopSku是否存在
        ShopSku shopSku = shopSkuService.getShopSkuByShopSku(params.getShopSku());
        if (shopSku == null) {
            sbErroEntity.append(WarehousingOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
        } else if (warehousingOrder != null && !shopSku.getShopId().equals(warehousingOrder.getShopId())) {
            sbErroEntity.append(WarehousingOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
        } else {
            //判断生产单是否已经存在这个店铺sku
            if (existsShopSku(params.getWarehousingOrderId(), params.getId(), shopSku.getShopSkuId())) {
                sbErroEntity.append(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_SHOP_SKU_EXIST);
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        WarehousingOrderShopSku warehousingOrderShopSku = new WarehousingOrderShopSku();
        BeanUtils.copyProperties(params, warehousingOrderShopSku);
        warehousingOrderShopSku.setShopSkuId(shopSku.getShopSkuId());
        if (params.getId() == null) {
            warehousingOrderShopSku.setCreateTime(new Date());
            warehousingOrderShopSku.setCreateBy(dealUserId);
            customWarehousingOrderShopSkuMapper.insertSelective(warehousingOrderShopSku);
        } else {
            warehousingOrderShopSku.setUpdateBy(dealUserId);
            warehousingOrderShopSku.setUpdateTime(new Date());
            customWarehousingOrderShopSkuMapper.updateByPrimaryKeySelective(warehousingOrderShopSku);
        }
        return BaseResponse.success();
    }

    private WarehousingOrderShopSku getWarehousingOrderShopSkuById(Integer id) {
        if (id == null) {
            return null;
        }
        return customWarehousingOrderShopSkuMapper.selectByPrimaryKey(id);
    }

    /**
     * @param id@return
     * @description 删除入库单店铺sku
     * @author baixueping
     * @date 2020/4/24 9:50
     */
    @Override
    public BaseResponse deleteWarehousingOrderShopSku(Integer id) {
        //获取入库单店铺sku信息
        if (id == null) {
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.ID_EMPTY);
        }
        WarehousingOrderShopSku warehousingOrderShopSku=customWarehousingOrderShopSkuMapper.selectByPrimaryKey(id);
        if(warehousingOrderShopSku==null){
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.ID_NOT_EXIST);
        }
        WarehousingOrder warehousingOrder=warehousingOrderService.getWarehousingOrderById(warehousingOrderShopSku.getWarehousingOrderId());
        if(warehousingOrder==null){
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_NOT_EXIST);
        }
        if(!WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(warehousingOrder.getStatus())){
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.ONLY_PENDING_STORAGE_ALLOW_DELETE_SHOP_SKU);
        }
        customWarehousingOrderShopSkuMapper.deleteByPrimaryKey(id);
        return BaseResponse.success();
    }

    /**
     * @param produceOrderId
     * @param shopSkuId
     * @return
     * @description 判断入库单是否包含生产单店铺sku
     * @author baixueping
     * @date 2020/4/28 10:23
     */
    @Override
    public boolean existProduceOrderShopSku(Integer produceOrderId, Integer shopSkuId) {
        if (produceOrderId == null || shopSkuId==null) {
            return false;
        }
        return customWarehousingOrderShopSkuMapper.existProduceOrderShopSku(produceOrderId, shopSkuId);
    }

    /**
     * @param warehousingOrderId@return
     * @description 判断是否存在店铺sku
     * @author baixueping
     * @date 2020/4/29 17:30
     */
    @Override
    public boolean existWarehousingOrderShopSku(Integer warehousingOrderId) {
        if (warehousingOrderId == null) {
            return false;
        }
        WarehousingOrderShopSkuExample warehousingOrderShopSkuExample = new WarehousingOrderShopSkuExample();
        warehousingOrderShopSkuExample.createCriteria().andWarehousingOrderIdEqualTo(warehousingOrderId);
        return customWarehousingOrderShopSkuMapper.countByExample(warehousingOrderShopSkuExample) > 0;
    }

    /**
     * @param warehousingOrderId@return
     * @description 查询入库单店铺sku信息
     * @author baixueping
     * @date 2020/5/7 15:28
     */
    @Override
    public List<WarehousingOrderShopSku> listWarehousingOrderShopSku(Integer warehousingOrderId) {
        if (warehousingOrderId == null) {
            return null;
        }
        WarehousingOrderShopSkuExample warehousingOrderShopSkuExample = new WarehousingOrderShopSkuExample();
        warehousingOrderShopSkuExample.createCriteria().andWarehousingOrderIdEqualTo(warehousingOrderId);
        return customWarehousingOrderShopSkuMapper.selectByExample(warehousingOrderShopSkuExample);
    }

    /**
     * @param file
     * @param warehousingOrderId
     * @param dealUserId         @return
     * @description 导入入库单店铺sku信息
     * @author baixueping
     * @date 2020/5/9 15:43
     */
    @Override
    public BaseResponse importWarehousingOrderShopSku(MultipartFile file, Integer warehousingOrderId, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        if (warehousingOrderId == null) {
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_EMPTY);
        }
        WarehousingOrder warehousingOrder = warehousingOrderService.getWarehousingOrderById(warehousingOrderId);
        if (warehousingOrder == null) {
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_NOT_EXIST);
        } else if (!WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(warehousingOrder.getStatus())) {
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.ONLY_PENDING_STORAGE_ALLOW_IMPORT_SHOP_SKU);
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
                sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    if (!shopSku.getShopId().equals(warehousingOrder.getShopId())) {
                        sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
                    } else {
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("入库数量"))) {
                sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.WAREHOUSING_QUANTITY_EMPTY);
            } else {
                Integer warehousingQuantity = MathUtil.strToInteger(map.get("入库数量"));
                if (warehousingQuantity == null | warehousingQuantity <= 0) {
                    sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.WAREHOUSING_QUANTITY_ERRO);
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
            Integer warehousingQuantity = MathUtil.strToInteger(map.get("入库数量"));
            //判断入库单是否有此店铺sku
            Integer shopSkuId = MathUtil.strToInteger(map.get("shopSkuId"));
            WarehousingOrderShopSku warehousingOrderShopSkuOld = getWarehousingOrderShopSku(warehousingOrderId, shopSkuId);
            WarehousingOrderShopSku warehousingOrderShopSku = new WarehousingOrderShopSku();
            warehousingOrderShopSku.setWarehousingQuantity(warehousingQuantity);
            if (warehousingOrderShopSkuOld != null) {
                warehousingOrderShopSku.setUpdateTime(new Date());
                warehousingOrderShopSku.setUpdateBy(dealUserId);
                warehousingOrderShopSku.setId(warehousingOrderShopSkuOld.getId());
                customWarehousingOrderShopSkuMapper.updateByPrimaryKeySelective(warehousingOrderShopSku);
            } else {
                warehousingOrderShopSku.setWarehousingOrderId(warehousingOrderId);
                warehousingOrderShopSku.setShopSkuId(shopSkuId);
                warehousingOrderShopSku.setShopSku(map.get("店铺sku"));
                warehousingOrderShopSku.setCreateBy(dealUserId);
                warehousingOrderShopSku.setCreateTime(new Date());
                customWarehousingOrderShopSkuMapper.insertSelective(warehousingOrderShopSku);
            }
        }
        return BaseResponse.success();
    }

    /**
     * @param warehousingOrderId@return
     * @description 查询入库单店铺sku信息
     * @author baixueping
     * @date 2020/5/9 16:14
     */
    @Override
    public List<ListWarehousingOrderShopSkuResponse> listWarehousingOrderShopSkuByWarehousingOrderId(Integer warehousingOrderId) {
        if (warehousingOrderId == null) {
            return new ArrayList<ListWarehousingOrderShopSkuResponse>();
        }
        ListWarehousingOrderShopSkuRequest listWarehousingOrderShopSkuRequest = new ListWarehousingOrderShopSkuRequest();
        listWarehousingOrderShopSkuRequest.setWarehousingOrderId(warehousingOrderId);
        return customWarehousingOrderShopSkuMapper.listWarehousingOrderShopSku(listWarehousingOrderShopSkuRequest);
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存入库数量
     * @author baixueping
     * @date 2020/7/17 10:17
     */
    @Override
    public BaseResponse saveWarehousingQuantity(SaveWarehousingQuantityRequest params, Integer dealUserId) {
        WarehousingOrderShopSku warehousingOrderShopSku=customWarehousingOrderShopSkuMapper.selectByPrimaryKey(params.getId());
        if(warehousingOrderShopSku==null){
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.ID_NOT_EXIST);
        }
        WarehousingOrder warehousingOrder=warehousingOrderService.getWarehousingOrderById(warehousingOrderShopSku.getWarehousingOrderId());
        if(warehousingOrder==null){
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_NOT_EXIST);
        }else if (!WarehousingOrderConstant.StatusEnum.PENDING_STORAGE.getStatus().equals(warehousingOrder.getStatus())) {
            return BaseResponse.failMessage(WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_NOT_ALLOW_WAREHOUSING);
        }
        WarehousingOrderShopSku warehousingOrderShopSkuUpdate=new WarehousingOrderShopSku();
        warehousingOrderShopSkuUpdate.setId(params.getId());
        warehousingOrderShopSkuUpdate.setWarehousingQuantity(params.getWarehousingQuantity());
        warehousingOrderShopSkuUpdate.setUpdateBy(dealUserId);
        warehousingOrderShopSkuUpdate.setUpdateTime(new Date());
        customWarehousingOrderShopSkuMapper.updateByPrimaryKeySelective(warehousingOrderShopSkuUpdate);
        return BaseResponse.success();
    }

    private WarehousingOrderShopSku getWarehousingOrderShopSku(Integer warehousingOrderId, Integer shopSkuId) {
        if (warehousingOrderId == null || shopSkuId == null) {
            return null;
        }
        WarehousingOrderShopSkuExample example = new WarehousingOrderShopSkuExample();
        example.createCriteria().andWarehousingOrderIdEqualTo(warehousingOrderId).andShopSkuIdEqualTo(shopSkuId);
        List<WarehousingOrderShopSku> list = customWarehousingOrderShopSkuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    private boolean existsShopSku(Integer warehousingOrderId, Integer id, Integer shopSkuId) {
        WarehousingOrderShopSkuExample warehousingOrderShopSkuExample = new WarehousingOrderShopSkuExample();
        if (id == null) {
            warehousingOrderShopSkuExample.createCriteria().andWarehousingOrderIdEqualTo(warehousingOrderId).andShopSkuIdEqualTo(shopSkuId);
        } else {
            warehousingOrderShopSkuExample.createCriteria().andWarehousingOrderIdEqualTo(warehousingOrderId).andShopSkuIdEqualTo(shopSkuId).andIdNotEqualTo(id);
        }
        return customWarehousingOrderShopSkuMapper.countByExample(warehousingOrderShopSkuExample) > 0;
    }
}
