package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.LabelPrintConstant;
import com.sky.ddt.dao.custom.CustomLabelPrintMapper;
import com.sky.ddt.dao.custom.CustomLabelPrintShopSkuMapper;
import com.sky.ddt.dto.labelPrint.request.LabelPrintListRequest;
import com.sky.ddt.dto.labelPrint.request.SaveLabelPrintRemarkRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.LabelPrint;
import com.sky.ddt.entity.LabelPrintExample;
import com.sky.ddt.entity.LabelPrintShopSku;
import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.service.ILabelPrintService;
import com.sky.ddt.service.IShopSkuService;
import com.sky.ddt.util.ExcelUtil;
import com.sky.ddt.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author baixueping
 * @description 标签打印
 * @date 2020/2/27 17:23
 */
@Service
public class LabelPrintService implements ILabelPrintService {
    @Autowired
    CustomLabelPrintMapper customLabelPrintMapper;
    @Autowired
    IShopSkuService shopSkuService;
    @Autowired
    CustomLabelPrintShopSkuMapper customLabelPrintShopSkuMapper;

    /**
     * @param params@return
     * @description 分页查询标签打印
     * @author baixueping
     * @date 2020/2/28 10:47
     */
    @Override
    public PageInfo<LabelPrint> list(LabelPrintListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        LabelPrintExample labelPrintExample = new LabelPrintExample();
        labelPrintExample.setOrderByClause(" create_time desc");
        List<LabelPrint> list = customLabelPrintMapper.selectByExample(labelPrintExample);
        PageInfo<LabelPrint> page = new PageInfo<LabelPrint>(list);
        return page;
    }

    /**
     * @param file
     * @param userId
     * @return
     * @description 导入标签打印信息
     * @author baixueping
     * @date 2020/2/28 11:31
     */
    @Override
    public BaseResponse importLabelPrint(MultipartFile file, Integer userId) {
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
                sbErroItem.append(",").append(LabelPrintConstant.SHOP_SKU_EMPTY);
            } else {
                ShopSku shopSku = shopSkuService.getShopSkuByShopSku(map.get("店铺sku"));
                if (shopSku == null) {
                    sbErroItem.append(",").append(LabelPrintConstant.SHOP_SKU_NOT_EXIST);
                } else {
                    map.put("shopSkuId", shopSku.getShopSkuId().toString());
                }
            }
            if (StringUtils.isEmpty(map.get("数量"))) {
                sbErroItem.append(",").append(LabelPrintConstant.QUANTITY_EMPTY);
            } else {
                Integer quantity = MathUtil.strToInteger(map.get("数量"));
                if (quantity == null || quantity < 0) {
                    sbErroItem.append(",").append(LabelPrintConstant.QUANTITY_ERRO);
                }
            }
            if (sbErroItem.length() > 0) {
                sbErro.append(",第" + (i + 2) + "行").append(sbErroItem);
            }
        }
        if (sbErro.length() > 0) {
            return BaseResponse.failMessage(sbErro.substring(1));
        }

        LabelPrint labelPrint = new LabelPrint();
        labelPrint.setCreateTime(new Date());
        labelPrint.setCreateBy(userId);
        customLabelPrintMapper.insertSelective(labelPrint);
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
            LabelPrintShopSku labelPrintShopSku = new LabelPrintShopSku();
            labelPrintShopSku.setCreateBy(userId);
            labelPrintShopSku.setCreateTime(new Date());
            labelPrintShopSku.setShopSkuId(MathUtil.strToInteger(map.get("shopSkuId")));
            labelPrintShopSku.setQuantity(MathUtil.strToInteger(map.get("数量")));
            labelPrintShopSku.setLabelPrintId(labelPrint.getId());
            customLabelPrintShopSkuMapper.insertSelective(labelPrintShopSku);
        }
        return BaseResponse.success();
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存标签打印备注
     * @author baixueping
     * @date 2020/4/20 10:50
     */
    @Override
    public BaseResponse saveLabelPrintRemark(SaveLabelPrintRemarkRequest params, Integer dealUserId) {
        LabelPrint labelPrint = new LabelPrint();
        labelPrint.setId(params.getLabelPrintId());
        labelPrint.setRemark(params.getRemark());
        customLabelPrintMapper.updateByPrimaryKeySelective(labelPrint);
        return BaseResponse.success();
    }

    /**
     * @param labelPrintId@return
     * @description 获取标签打印信息
     * @author baixueping
     * @date 2020/5/18 12:19
     */
    @Override
    public LabelPrint getLabelPrint(Integer labelPrintId) {
        if(labelPrintId==null){
            return null;
        }
        return customLabelPrintMapper.selectByPrimaryKey(labelPrintId);
    }
}
