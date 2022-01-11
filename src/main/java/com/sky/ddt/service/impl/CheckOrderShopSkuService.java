package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.CheckOrderConstant;
import com.sky.ddt.common.constant.CheckOrderShopSkuConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.common.constant.WarehousingOrderShopSkuConstant;
import com.sky.ddt.dao.custom.CustomCheckOrderShopSkuMapper;
import com.sky.ddt.dto.CheckOrderShopSkuStorageLocation.request.BatchSaveCheckOrderShopSkuStorageLocationRequest;
import com.sky.ddt.dto.checkOrderShopSku.request.ListCheckOrderShopSkuRequest;
import com.sky.ddt.dto.checkOrderShopSku.request.SaveCheckOrderShopSkuRequest;
import com.sky.ddt.dto.checkOrderShopSku.request.SaveInventoryQuantityNewRequest;
import com.sky.ddt.dto.checkOrderShopSku.response.ListCheckOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrderShopSkuStorageLocation.request.BatchSaveWarehousingOrderShopSkuStorageLocationRequest;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.*;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author baixueping
 * @description 盘点单店铺sku
 * @date 2020/5/11 10:47
 */
@Service
public class CheckOrderShopSkuService implements ICheckOrderShopSkuService {
    @Autowired
    CustomCheckOrderShopSkuMapper customCheckOrderShopSkuMapper;
    @Autowired
    ICheckOrderService checkOrderService;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    IStorageLocationService storageLocationService;
    @Autowired
    ICheckOrderShopSkuStorageLocationService checkOrderShopSkuStorageLocationService;

    @Override
    public boolean existCheckOrderShopSku(Integer checkOrderId) {
        if (checkOrderId == null) {
            return false;
        }
        CheckOrderShopSkuExample checkOrderShopSkuExample = new CheckOrderShopSkuExample();
        checkOrderShopSkuExample.createCriteria().andCheckOrderIdEqualTo(checkOrderId);
        return customCheckOrderShopSkuMapper.countByExample(checkOrderShopSkuExample) > 0;
    }

    /**
     * @param params@return
     * @description 分页查询盘点单店铺sku信息
     * @author baixueping
     * @date 2020/5/11 15:02
     */
    @Override
    public PageInfo<ListCheckOrderShopSkuResponse> listCheckOrderShopSku(ListCheckOrderShopSkuRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListCheckOrderShopSkuResponse> list = customCheckOrderShopSkuMapper.listCheckOrderShopSku(params);
        PageInfo<ListCheckOrderShopSkuResponse> page = new PageInfo<ListCheckOrderShopSkuResponse>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 15:24
     */
    @Override
    public BaseResponse saveCheckOrderShopSku(SaveCheckOrderShopSkuRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        CheckOrderShopSku checkOrderShopSkuOld = null;
        if (params.getId() != null) {
            checkOrderShopSkuOld = getCheckOrderShopSkuById(params.getId());
            if (checkOrderShopSkuOld == null) {
                sbErroEntity.append(CheckOrderShopSkuConstant.ID_NOT_EXIST);
            }
        }
        //判断盘点单id是否存在
        CheckOrder checkOrder = checkOrderService.getCheckOrderById(params.getCheckOrderId());
        if (checkOrder == null) {
            sbErroEntity.append(CheckOrderShopSkuConstant.CHECK_ORDER_ID_NOT_EXIST);
        } else if (!CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(checkOrder.getStatus())) {
            sbErroEntity.append(CheckOrderShopSkuConstant.ONLY_PENDING_CONFIRM_ALLOW_SAVE_SHOP_SKU);
        } else if (checkOrderShopSkuOld != null) {
            if (!checkOrderShopSkuOld.getCheckOrderId().equals(params.getCheckOrderId())) {
                sbErroEntity.append(CheckOrderShopSkuConstant.CHECK_ORDER_ID_NOT_ALLOW_CHANGE);
            }
        }
        //判断shopSku是否存在
        ShopSku shopSku = shopSkuService.getShopSkuByShopSku(params.getShopSku());
        if (shopSku == null) {
            sbErroEntity.append(CheckOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
        } else if (checkOrder != null && !checkOrder.getShopId().equals(shopSku.getShopId())) {
            sbErroEntity.append(CheckOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
        } else if (existCheckOrderShopSku(params.getCheckOrderId(), params.getId(), shopSku.getShopSkuId())) {
            sbErroEntity.append(CheckOrderShopSkuConstant.CHECK_ORDER_SHOP_SKU_EXIST);
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        CheckOrderShopSku checkOrderShopSku = new CheckOrderShopSku();
        BeanUtils.copyProperties(params, checkOrderShopSku);
        checkOrderShopSku.setShopSkuId(shopSku.getShopSkuId());
        if (params.getId() == null) {
            checkOrderShopSku.setCreateTime(new Date());
            checkOrderShopSku.setCreateBy(dealUserId);
            customCheckOrderShopSkuMapper.insertSelective(checkOrderShopSku);
        } else {
            checkOrderShopSku.setUpdateBy(dealUserId);
            checkOrderShopSku.setUpdateTime(new Date());
            customCheckOrderShopSkuMapper.updateByPrimaryKeySelective(checkOrderShopSku);
        }
        return BaseResponse.success();
    }

    /**
     * @param id@return
     * @description 删除盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 15:52
     */
    @Override
    public BaseResponse deleteCheckOrderShopSku(Integer id) {
        //获取盘点单店铺sku信息
        if (id == null) {
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.ID_EMPTY);
        }
        CheckOrderShopSku checkOrderShopSku = customCheckOrderShopSkuMapper.selectByPrimaryKey(id);
        if (checkOrderShopSku == null) {
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.ID_NOT_EXIST);
        }
        CheckOrder checkOrder = checkOrderService.getCheckOrderById(checkOrderShopSku.getCheckOrderId());
        if (checkOrder == null) {
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.CHECK_ORDER_ID_NOT_EXIST);
        }
        if (!CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(checkOrder.getStatus())) {
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.ONLY_PENDING_CONFIRM_ALLOW_DELETE_SHOP_SKU);
        }
        customCheckOrderShopSkuMapper.deleteByPrimaryKey(id);
        return BaseResponse.success();
    }

    /**
     * @param file
     * @param checkOrderId
     * @param dealUserId   @return
     * @description 导入盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 16:44
     */
    @Override
    public BaseResponse importCheckOrderShopSku(MultipartFile file, Integer checkOrderId, Integer dealUserId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        CheckOrder checkOrder=checkOrderService.getCheckOrderById(checkOrderId);
        if(checkOrder==null){
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.CHECK_ORDER_ID_NOT_EXIST);
        }else if(!CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(checkOrder.getStatus())){
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.ONLY_PENDING_CONFIRM_ALLOW_IMPORT_SHOP_SKU);
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, List<Integer>> locationMap = new HashMap<>();
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
                sbErroItem.append(",").append(CheckOrderShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(CheckOrderShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    if (!shopSku.getShopId().equals(checkOrder.getShopId())) {
                        sbErroItem.append(",").append(CheckOrderShopSkuConstant.SHOP_SKU_SHOP_ERRO);
                    } else {
                        map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    }
                }
            }
            if (StringUtils.isEmpty(map.get("最新库存数量"))) {
                sbErroItem.append(",").append(CheckOrderShopSkuConstant.INVENTORY_QUANTITY_NEW_EMPTY);
            } else {
                Integer inventoryQuantityNew = MathUtil.strToInteger(map.get("最新库存数量"));
                if (inventoryQuantityNew == null | inventoryQuantityNew < 0) {
                    sbErroItem.append(",").append(CheckOrderShopSkuConstant.INVENTORY_QUANTITY_NEW_ERRO);
                }
            }
            if (!StringUtils.isEmpty(map.get("库位"))) {
                List<Integer> locationIdList = new ArrayList<>();
                String locationNos = map.get("库位").replace("，", ",");
                List<String> locationNoList = Arrays.asList(locationNos.split(","));
                List<StorageLocation> storageLocationList = storageLocationService.listStorageLocationByLocationNoList(locationNoList);
                for (String locationNo : locationNoList) {
                    Optional<StorageLocation> optionalStorageLocation = storageLocationList.stream().filter(item -> item.getLocationNo().equals(locationNo)).findFirst();
                    if (optionalStorageLocation.isPresent()) {
                        locationIdList.add(optionalStorageLocation.get().getId());
                    } else {
                        sbErroItem.append(",").append(WarehousingOrderShopSkuConstant.LOCATION_NO_NOT_EXIST);
                        break;
                    }

                }
                locationMap.put(map.get("店铺sku"),locationIdList);
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
            Integer inventoryQuantityNew = MathUtil.strToInteger(map.get("最新库存数量"));
            //判断入库单是否有此店铺sku
            Integer shopSkuId = MathUtil.strToInteger(map.get("shopSkuId"));
            CheckOrderShopSku checkOrderShopSkuOld = getCheckOrderShopSku(checkOrderId, shopSkuId);
            CheckOrderShopSku checkOrderShopSku = new CheckOrderShopSku();
            checkOrderShopSku.setInventoryQuantityNew(inventoryQuantityNew);
            if (checkOrderShopSkuOld != null) {
                checkOrderShopSku.setUpdateTime(new Date());
                checkOrderShopSku.setUpdateBy(dealUserId);
                checkOrderShopSku.setId(checkOrderShopSkuOld.getId());
                customCheckOrderShopSkuMapper.updateByPrimaryKeySelective(checkOrderShopSku);
            } else {
                checkOrderShopSku.setCheckOrderId(checkOrderId);
                checkOrderShopSku.setShopSkuId(shopSkuId);
                checkOrderShopSku.setShopSku(map.get("店铺sku"));
                checkOrderShopSku.setCreateBy(dealUserId);
                checkOrderShopSku.setCreateTime(new Date());
                customCheckOrderShopSkuMapper.insertSelective(checkOrderShopSku);
            }
            List<Integer> storageLocationList=locationMap.get(map.get("店铺sku"));
            if(!CollectionUtils.isEmpty(storageLocationList)){
                BatchSaveCheckOrderShopSkuStorageLocationRequest batchSaveWarehousingOrderShopSkuStorageLocationRequest=new BatchSaveCheckOrderShopSkuStorageLocationRequest();
                batchSaveWarehousingOrderShopSkuStorageLocationRequest.setCheckOrderShopSkuId(checkOrderShopSku.getId());
                batchSaveWarehousingOrderShopSkuStorageLocationRequest.setStorageLocationIdList(storageLocationList);
                batchSaveWarehousingOrderShopSkuStorageLocationRequest.setCreateBy(dealUserId);
                //更新库位信息
                checkOrderShopSkuStorageLocationService.batchSaveCheckOrderShopSkuStorageLocation(batchSaveWarehousingOrderShopSkuStorageLocationRequest);
            }

        }
        return BaseResponse.success();
    }

    /**
     * @param checkOrderId@return
     * @description 查询盘点单所有店铺sku
     * @author baixueping
     * @date 2020/5/11 17:26
     */
    @Override
    public List<ListCheckOrderShopSkuResponse> listCheckOrderShopSkuByCheckOrderId(Integer checkOrderId) {
        if (checkOrderId == null) {
            return new ArrayList<ListCheckOrderShopSkuResponse>();
        }
        ListCheckOrderShopSkuRequest listCheckOrderShopSkuRequest = new ListCheckOrderShopSkuRequest();
        listCheckOrderShopSkuRequest.setCheckOrderId(checkOrderId);
        return customCheckOrderShopSkuMapper.listCheckOrderShopSku(listCheckOrderShopSkuRequest);

    }

    /**
     * @param checkOrderId@return
     * @description 获取盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 17:36
     */
    @Override
    public List<CheckOrderShopSku> listCheckOrderShopSku(Integer checkOrderId) {
        if(checkOrderId==null){
            return null;
        }
        CheckOrderShopSkuExample example=new CheckOrderShopSkuExample();
        example.createCriteria().andCheckOrderIdEqualTo(checkOrderId);
        return customCheckOrderShopSkuMapper.selectByExample(example);
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存最新库存数量
     * @author baixueping
     * @date 2020/7/17 11:06
     */
    @Override
    public BaseResponse saveInventoryQuantityNew(SaveInventoryQuantityNewRequest params, Integer dealUserId) {
        CheckOrderShopSku checkOrderShopSku=customCheckOrderShopSkuMapper.selectByPrimaryKey(params.getId());
        if(checkOrderShopSku==null){
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.ID_NOT_EXIST);
        }
        CheckOrder checkOrder=checkOrderService.getCheckOrderById(checkOrderShopSku.getCheckOrderId());
        if(checkOrder==null){
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.CHECK_ORDER_ID_NOT_EXIST);
        } else if (!CheckOrderConstant.StatusEnum.PENDING_CONFIRM.getStatus().equals(checkOrder.getStatus())) {
            return BaseResponse.failMessage(CheckOrderShopSkuConstant.ONLY_PENDING_CONFIRM_ALLOW_SAVE_SHOP_SKU);
        }
        CheckOrderShopSku checkOrderShopSkuUpdate=new CheckOrderShopSku();
        checkOrderShopSkuUpdate.setId(params.getId());
        checkOrderShopSkuUpdate.setInventoryQuantityNew(params.getInventoryQuantityNew());
        checkOrderShopSkuUpdate.setUpdateBy(dealUserId);
        checkOrderShopSkuUpdate.setUpdateTime(new Date());
        customCheckOrderShopSkuMapper.updateByPrimaryKeySelective(checkOrderShopSkuUpdate);
        return BaseResponse.success();
    }

    @Override
    public CheckOrderShopSku getById(Integer checkOrderShopSkuId) {
        if(checkOrderShopSkuId==null){
            return null;
        }
        return customCheckOrderShopSkuMapper.selectByPrimaryKey(checkOrderShopSkuId);
    }

    private CheckOrderShopSku getCheckOrderShopSku(Integer checkOrderId, Integer shopSkuId) {
        if (checkOrderId == null || shopSkuId == null) {
            return null;
        }
        CheckOrderShopSkuExample example = new CheckOrderShopSkuExample();
        example.createCriteria().andCheckOrderIdEqualTo(checkOrderId).andShopSkuIdEqualTo(shopSkuId);
        List<CheckOrderShopSku> list = customCheckOrderShopSkuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }


    private boolean existCheckOrderShopSku(Integer checkOrderId, Integer id, Integer shopSkuId) {
        CheckOrderShopSkuExample example = new CheckOrderShopSkuExample();
        if (id == null) {
            example.createCriteria().andCheckOrderIdEqualTo(checkOrderId).andShopSkuIdEqualTo(shopSkuId);
        } else {
            example.createCriteria().andCheckOrderIdEqualTo(checkOrderId).andShopSkuIdEqualTo(shopSkuId).andIdNotEqualTo(id);
        }
        return customCheckOrderShopSkuMapper.countByExample(example) > 0;

    }

    private CheckOrderShopSku getCheckOrderShopSkuById(Integer id) {
        if (id == null) {
            return null;
        }
        return customCheckOrderShopSkuMapper.selectByPrimaryKey(id);
    }
}
