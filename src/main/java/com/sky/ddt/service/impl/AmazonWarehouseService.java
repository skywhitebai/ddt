package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomAmazonWarehouseMapper;
import com.sky.ddt.dto.amazonWarehouse.req.ListAmazonWarehouseReq;
import com.sky.ddt.dto.amazonWarehouse.req.SaveAmazonWarehouseReq;
import com.sky.ddt.dto.amazonWarehouse.resp.AmazonWarehouseComboxResp;
import com.sky.ddt.dto.amazonWarehouse.resp.ListAmazonWarehouseResp;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.AmazonWarehouse;
import com.sky.ddt.entity.AmazonWarehouseExample;
import com.sky.ddt.entity.Shop;
import com.sky.ddt.entity.StorageLocation;
import com.sky.ddt.service.IAmazonWarehouseService;
import com.sky.ddt.util.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sky
 * @Description
 * @date 2022/4/17 23:36
 */
@Service
public class AmazonWarehouseService implements IAmazonWarehouseService {
    @Autowired
    CustomAmazonWarehouseMapper customAmazonWarehouseMapper;

    @Override
    public PageInfo<ListAmazonWarehouseResp> listAmazonWarehouse(ListAmazonWarehouseReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListAmazonWarehouseResp> list = customAmazonWarehouseMapper.listAmazonWarehouse(params);
        PageInfo<ListAmazonWarehouseResp> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public BaseResponse saveAmazonWarehouse(SaveAmazonWarehouseReq params, Integer dealUserId) {
        AmazonWarehouse amazonWarehouse = new AmazonWarehouse();
        if (params.getId() != null) {
            AmazonWarehouse amazonWarehouseOld = customAmazonWarehouseMapper.selectByPrimaryKey(params.getId());
            if (amazonWarehouseOld == null) {
                return BaseResponse.failMessage("id不存在");
            }
        }
        if (exist(params)) {
            return BaseResponse.failMessage("仓库信息已存在");
        }
        BeanUtils.copyProperties(params, amazonWarehouse);
        if ("#N/A".equals(amazonWarehouse.getState())) {
            amazonWarehouse.setState(null);
        }
        if (amazonWarehouse.getId() == null) {
            amazonWarehouse.setCreateBy(dealUserId);
            amazonWarehouse.setCreateTime(new Date());
            customAmazonWarehouseMapper.insertSelective(amazonWarehouse);
        } else {
            amazonWarehouse.setUpdateBy(dealUserId);
            amazonWarehouse.setUpdateTime(new Date());
            customAmazonWarehouseMapper.updateByPrimaryKeySelective(amazonWarehouse);
        }
        return BaseResponse.success();
    }

    @Override
    public List<AmazonWarehouseComboxResp> amazonWarehouseComboboxlist() {
        return customAmazonWarehouseMapper.amazonWarehouseComboboxlist();
    }

    @Override
    public BaseResponse importAmazonWarehouse(MultipartFile file, Integer dealUserId) {
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
            if (StringUtils.isEmpty(map.get("fulfillment-center-id"))) {
                sbErroItem.append(",").append("fulfillment-center-id不能为空");
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

            AmazonWarehouse amazonWarehouse = new AmazonWarehouse();
            amazonWarehouse.setFulfillmentCenterId(map.get("fulfillment-center-id"));
            amazonWarehouse.setState(map.get("州"));
            if ("#N/A".equals(amazonWarehouse.getState())) {
                amazonWarehouse.setState(null);
            }
            amazonWarehouse.setRemark(map.get("备注"));
            AmazonWarehouse amazonWarehouseOld = getAmazonWarehouse(amazonWarehouse.getFulfillmentCenterId());
            if (amazonWarehouseOld != null) {
                amazonWarehouse.setId(amazonWarehouseOld.getId());
                amazonWarehouse.setUpdateBy(dealUserId);
                amazonWarehouse.setUpdateTime(new Date());
                customAmazonWarehouseMapper.updateByPrimaryKeySelective(amazonWarehouse);
            } else {
                amazonWarehouse.setCreateBy(dealUserId);
                amazonWarehouse.setCreateTime(new Date());
                customAmazonWarehouseMapper.insertSelective(amazonWarehouse);
            }
        }
        return BaseResponse.success();
    }

    private AmazonWarehouse getAmazonWarehouse(String fulfillmentCenterId) {
        AmazonWarehouseExample amazonWarehouseExample = new AmazonWarehouseExample();
        amazonWarehouseExample.createCriteria().andFulfillmentCenterIdEqualTo(fulfillmentCenterId);
        List<AmazonWarehouse> list = customAmazonWarehouseMapper.selectByExample(amazonWarehouseExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    private boolean exist(SaveAmazonWarehouseReq params) {
        AmazonWarehouseExample amazonWarehouseExample = new AmazonWarehouseExample();
        AmazonWarehouseExample.Criteria criteria = amazonWarehouseExample.createCriteria();
        if (params.getId() != null) {
            criteria.andIdNotEqualTo(params.getId());
        }
        criteria.andFulfillmentCenterIdEqualTo(params.getFulfillmentCenterId());
        return customAmazonWarehouseMapper.countByExample(amazonWarehouseExample) > 0;
    }
}
