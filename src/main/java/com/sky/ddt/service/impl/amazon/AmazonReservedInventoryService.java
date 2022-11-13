package com.sky.ddt.service.impl.amazon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FbaImportConstant;
import com.sky.ddt.dao.custom.CustomAmazonReservedInventoryMapper;
import com.sky.ddt.dto.amazonReservedInventory.req.ListAmazonReservedInventoryReq;
import com.sky.ddt.dto.amazonReservedInventory.resp.ListAmazonReservedInventoryResp;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.amazon.IAmazonReservedInventoryService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
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
 * @author sky
 * @Description
 * @date 2022/11/7 13:49
 */
@Service
public class AmazonReservedInventoryService implements IAmazonReservedInventoryService {

    @Autowired
    CustomAmazonReservedInventoryMapper customAmazonReservedInventoryMapper;
    @Autowired
    IShopSkuService shopSkuService;

    @Override
    public BaseResponse importAmazonReservedInventory(MultipartFile file, Integer userId) {
        if (file == null) {
            return BaseResponse.failMessage("请选择要上传的文件");
        }
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        List<String> shopNameList = new ArrayList<>();
        Integer shopId = null;
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
            if (StringUtils.isEmpty(map.get("sku"))) {
                sbErroItem.append(",").append("sku不能为空");
            } else {
                //是否要判断sku是否本店铺的
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append("sku不存在");
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
                    map.put("shopId", shopSku.getShopId().toString());
                }
            }

            if (StringUtils.isEmpty(map.get("fnsku"))) {
                sbErroItem.append(",").append(FbaImportConstant.FNSKU_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("asin"))) {
                sbErroItem.append(",").append(FbaImportConstant.ASIN_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("product-name"))) {
                sbErroItem.append(",").append(FbaImportConstant.PRODUCT_NAME_EMPTY);
            }
            if (StringUtils.isEmpty(map.get("reserved_qty"))) {
                sbErroItem.append(",").append("reserved_qty不能为空");
            } else {
                Integer integer = MathUtil.strToInteger(map.get("reserved_qty"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append("reserved_qty必须为大于等于0的数字");
                }
            }
            if (StringUtils.isEmpty(map.get("reserved_customerorders"))) {
                sbErroItem.append(",").append("reserved_customerorders不能为空");
            } else {
                Integer integer = MathUtil.strToInteger(map.get("reserved_customerorders"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append("reserved_customerorders必须为大于等于0的数字");
                }
            }
            if (StringUtils.isEmpty(map.get("reserved_fc-transfers"))) {
                sbErroItem.append(",").append("reserved_fc-transfers不能为空");
            } else {
                Integer integer = MathUtil.strToInteger(map.get("reserved_fc-transfers"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append("reserved_fc-transfers必须为大于等于0的数字");
                }
            }
            if (StringUtils.isEmpty(map.get("reserved_fc-processing"))) {
                sbErroItem.append(",").append("reserved_fc-processing不能为空");
            } else {
                Integer integer = MathUtil.strToInteger(map.get("reserved_fc-processing"));
                if (integer == null || integer < 0) {
                    sbErroItem.append(",").append("reserved_fc-processing必须为大于等于0的数字");
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
            if (sbErro.length() > 0) {
                return BaseResponse.failMessage(sbErro.substring(1));
            }

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
            AmazonReservedInventory amazonReservedInventory = getAmazonReservedInventory(map.get("sku"));
            if (amazonReservedInventory != null) {
                setAmazonReservedInventoryByMap(amazonReservedInventory, map);
                amazonReservedInventory.setUpdateBy(userId);
                amazonReservedInventory.setUpdateTime(new Date());
                customAmazonReservedInventoryMapper.updateByPrimaryKeySelective(amazonReservedInventory);
            } else {
                amazonReservedInventory = new AmazonReservedInventory();
                setAmazonReservedInventoryByMap(amazonReservedInventory, map);
                amazonReservedInventory.setCreateBy(userId);
                amazonReservedInventory.setCreateTime(new Date());
                customAmazonReservedInventoryMapper.insertSelective(amazonReservedInventory);
            }
        }
        return BaseResponse.success();
    }

    private void setAmazonReservedInventoryByMap(AmazonReservedInventory amazonReservedInventory, Map<String, String> map) {
        if (amazonReservedInventory == null || map == null) {
            return;
        }
        amazonReservedInventory.setShopId(MathUtil.strToInteger(map.get("shopId")));
        amazonReservedInventory.setSku(map.get("sku"));
        amazonReservedInventory.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
        amazonReservedInventory.setFnsku(map.get("fnsku"));
        amazonReservedInventory.setAsin(map.get("asin"));
        amazonReservedInventory.setProductName(map.get("product-name"));
        amazonReservedInventory.setReservedQty(MathUtil.strToInteger(map.get("reserved_qty")));
        amazonReservedInventory.setReservedCustomerorders(MathUtil.strToInteger(map.get("reserved_customerorders")));
        amazonReservedInventory.setReservedFcTransfers(MathUtil.strToInteger(map.get("reserved_fc-transfers")));
        amazonReservedInventory.setReservedFcProcessing(MathUtil.strToInteger(map.get("reserved_fc-processing")));
    }

    private AmazonReservedInventory getAmazonReservedInventory(String sku) {
        if (StringUtils.isEmpty(sku)) {
            return null;
        }
        AmazonReservedInventoryExample amazonReservedInventoryExample = new AmazonReservedInventoryExample();
        amazonReservedInventoryExample.createCriteria().andSkuEqualTo(sku);
        List<AmazonReservedInventory> list = customAmazonReservedInventoryMapper.selectByExample(amazonReservedInventoryExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public PageInfo<ListAmazonReservedInventoryResp> listAmazonReservedInventory(ListAmazonReservedInventoryReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListAmazonReservedInventoryResp> list = customAmazonReservedInventoryMapper.listAmazonReservedInventory(params);
        PageInfo<ListAmazonReservedInventoryResp> page = new PageInfo<>(list);
        return page;
    }
}
