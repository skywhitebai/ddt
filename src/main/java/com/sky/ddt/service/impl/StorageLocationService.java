package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.SkuConstant;
import com.sky.ddt.common.constant.TransportTypeConstant;
import com.sky.ddt.dao.custom.CustomStorageLocationMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.storageLocation.request.ListStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.request.SaveStorageLocationRequest;
import com.sky.ddt.dto.storageLocation.response.ListStorageLocationResponse;
import com.sky.ddt.dto.storageLocation.response.StorageLocationCmoboboxResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopService;
import com.sky.ddt.service.IStorageLocationService;
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
 * @author sky
 * @Description 库位管理
 * @date 2022/1/3 20:35
 */
@Service
public class StorageLocationService implements IStorageLocationService {
    @Autowired
    CustomStorageLocationMapper customStorageLocationMapper;
    @Autowired
    IShopService shopService;

    @Override
    public PageInfo<ListStorageLocationResponse> listStorageLocation(ListStorageLocationRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStorageLocationResponse> list = customStorageLocationMapper.listStorageLocation(params);
        PageInfo<ListStorageLocationResponse> page = new PageInfo<ListStorageLocationResponse>(list);
        return page;
    }

    @Override
    public BaseResponse saveStorageLocation(SaveStorageLocationRequest params, Integer dealUserId) {
        if (params.getId() != null) {
            StorageLocation storageLocation = customStorageLocationMapper.selectByPrimaryKey(params.getId());
            if (storageLocation == null) {
                return BaseResponse.failMessage("id不存在");
            }
            storageLocation.setLocationNo(params.getLocationNo());
            storageLocation.setShopId(params.getShopId());
            storageLocation.setRemark(params.getRemark());
            if (existLocationNo(storageLocation)) {
                return BaseResponse.failMessage("库位信息已存在");
            }
            storageLocation.setUpdateBy(dealUserId);
            storageLocation.setUpdateTime(new Date());
            customStorageLocationMapper.updateByPrimaryKey(storageLocation);
            return BaseResponse.success();
        }
        StorageLocation storageLocation = new StorageLocation();
        BeanUtils.copyProperties(params, storageLocation);
        if (existLocationNo(storageLocation)) {
            return BaseResponse.failMessage("库位信息已存在");
        }
        storageLocation.setCreateBy(dealUserId);
        storageLocation.setCreateTime(new Date());
        customStorageLocationMapper.insertSelective(storageLocation);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse importStorageLocation(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, Shop> shopMap = new HashMap<>();
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
            if (StringUtils.isEmpty(map.get("仓库"))) {
                sbErroItem.append(",").append("仓库不能为空");
            } else {
                Shop shop = getShop(shopMap, map.get("仓库"));
                if (shop == null) {
                    sbErroItem.append(",").append("仓库不存在");
                } else {
                    map.put("shopId", shop.getShopId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("库位编号"))) {
                sbErroItem.append(",").append("库位编号信息不能为空");
            }
            if (!StringUtils.isEmpty(map.get("备注")) && map.get("备注").length() > 200) {
                sbErroItem.append(",").append("备注不能超过200");
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

            StorageLocation storageLocation = new StorageLocation();
            storageLocation.setShopId(Integer.valueOf(map.get("shopId")));
            storageLocation.setRemark(map.get("备注"));
            storageLocation.setLocationNo(map.get("库位编号"));
            StorageLocation storageLocationOld = getStorageLocation(storageLocation);
            if (storageLocationOld != null) {
                storageLocation.setId(storageLocationOld.getId());
                storageLocation.setUpdateBy(dealUserId);
                storageLocation.setUpdateTime(new Date());
                customStorageLocationMapper.updateByPrimaryKeySelective(storageLocation);
            } else {
                storageLocation.setCreateBy(dealUserId);
                storageLocation.setCreateTime(new Date());
                customStorageLocationMapper.insertSelective(storageLocation);
            }
        }
        return BaseResponse.success();
    }

    @Override
    public StorageLocation getStorageLocation(Integer storageLocationId) {
        if (storageLocationId == null) {
            return null;
        }
        StorageLocation storageLocation = customStorageLocationMapper.selectByPrimaryKey(storageLocationId);
        return storageLocation;
    }

    @Override
    public List<StorageLocationCmoboboxResponse> comboboxlist() {
        return customStorageLocationMapper.comboboxlist();
    }

    private StorageLocation getStorageLocation(StorageLocation storageLocation) {
        StorageLocationExample example = new StorageLocationExample();
        StorageLocationExample.Criteria criteria = example.createCriteria();
        criteria.andLocationNoEqualTo(storageLocation.getLocationNo());
        criteria.andShopIdEqualTo(storageLocation.getShopId());
        List<StorageLocation> list = customStorageLocationMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    private Shop getShop(Map<String, Shop> shopMap, String shopName) {
        if (shopMap.containsKey(shopName)) {
            return shopMap.get(shopName);
        }
        Shop shop = shopService.getShopByShopName(shopName);
        shopMap.put(shopName, shop);
        return shop;
    }

    private boolean existLocationNo(StorageLocation storageLocation) {
        StorageLocationExample example = new StorageLocationExample();
        StorageLocationExample.Criteria criteria = example.createCriteria();
        criteria.andLocationNoEqualTo(storageLocation.getLocationNo());
        criteria.andShopIdEqualTo(storageLocation.getShopId());
        if (storageLocation.getId() != null) {
            criteria.andIdNotEqualTo(storageLocation.getId());
        }
        return customStorageLocationMapper.countByExample(example) > 0;
    }
}
