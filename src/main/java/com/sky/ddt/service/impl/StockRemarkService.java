package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.ShopSkuConstant;
import com.sky.ddt.dao.custom.CustomStockRemarkMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.dto.stockRemark.req.ListStockRemarkReq;
import com.sky.ddt.dto.stockRemark.req.SaveStockRemarkReq;
import com.sky.ddt.dto.stockRemark.resp.ListStockRemarkResp;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.StockRemark;
import com.sky.ddt.entity.StockRemarkExample;
import com.sky.ddt.entity.User;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.service.IStockRemarkService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author sky
 * @Description
 * @date 2022/10/25 22:01
 */
@Service
public class StockRemarkService implements IStockRemarkService {
    @Autowired
    CustomStockRemarkMapper customStockRemarkMapper;
    @Autowired
    IShopSkuService shopSkuService;

    @Override
    public BaseResponse saveStockRemark(SaveStockRemarkReq req, Integer currentUserId) {
        //获取现有的备注
        StockRemark stockRemarkEnable = getStockRemarkEnable(req.getShopSkuId());
        if (stockRemarkEnable != null) {
            //判断备注是否一致  如果一直则返回
            if (stockRemarkEnable.getRemark().equals(req.getRemark())) {
                return BaseResponse.success();
            } else {
                //不一致，更新为失效
                stockRemarkEnable.setStatus(0);
                stockRemarkEnable.setUpdateBy(currentUserId);
                stockRemarkEnable.setUpdateTime(new Date());
                customStockRemarkMapper.updateByPrimaryKey(stockRemarkEnable);
            }
        }
        //添加新备注
        StockRemark stockRemark = new StockRemark();
        stockRemark.setStatus(1);
        stockRemark.setShopSkuId(req.getShopSkuId());
        stockRemark.setRemark(req.getRemark());
        stockRemark.setCreateBy(currentUserId);
        stockRemark.setCreateTime(new Date());
        stockRemark.setUpdateBy(currentUserId);
        stockRemark.setUpdateTime(stockRemark.getCreateTime());
        customStockRemarkMapper.insertSelective(stockRemark);
        return BaseResponse.success();
    }

    @Override
    public PageInfo<ListStockRemarkResp> listStockRemark(ListStockRemarkReq params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockRemarkResp> list = customStockRemarkMapper.listStockRemark(params);
        PageInfo<ListStockRemarkResp> page = new PageInfo<ListStockRemarkResp>(list);
        return page;
    }

    @Override
    public BaseResponse importStockRemark(MultipartFile file, Integer dealUserId) {
        //读取excel 转换为list
        List<Map<String, String>> list = ExcelUtil.getListByExcel(file);
        if (list == null || list.size() == 0) {
            return BaseResponse.failMessage("导入的数据内容为空");
        }
        //遍历list导入信息
        StringBuilder sbErro = new StringBuilder();
        Map<String, User> userMap = new HashMap<>();
        List<String> userNameNotExistList = new ArrayList<>();
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
                sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_EMPTY);
            } else {
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(ShopSkuConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
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
            SaveStockRemarkReq saveStockRemarkReq=new SaveStockRemarkReq();
            saveStockRemarkReq.setRemark(map.get("备注"));
            saveStockRemarkReq.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            saveStockRemark(saveStockRemarkReq,dealUserId);
        }
        return BaseResponse.success();
    }

    private StockRemark getStockRemarkEnable(Integer shopSkuId) {
        StockRemarkExample example = new StockRemarkExample();
        example.createCriteria().andShopSkuIdEqualTo(shopSkuId).andStatusEqualTo(1);
        List<StockRemark> list = customStockRemarkMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
