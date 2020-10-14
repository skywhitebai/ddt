package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomLabelPrintMapper;
import com.sky.ddt.dao.custom.CustomLabelPrintShopSkuMapper;
import com.sky.ddt.dto.labelPrint.request.LabelPrintShopSkuListRequest;
import com.sky.ddt.dto.labelPrint.response.LabelPrintShopSkuListResponse;
import com.sky.ddt.entity.LabelPrint;
import com.sky.ddt.service.ILabelPrintService;
import com.sky.ddt.service.ILabelPrintShopSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author baixueping
 * @description 标签打印sku服务
 * @date 2020/2/28 15:55
 */
@Service
public class LabelPrintShopSkuService implements ILabelPrintShopSkuService {
    @Autowired
    CustomLabelPrintShopSkuMapper customLabelPrintShopSkuMapper;
    @Autowired
    ILabelPrintService labelPrintService;
    /**
     * @param params@return
     * @description 查询标签打印sku列表
     * @author baixueping
     * @date 2020/2/28 15:54
     */
    @Override
    public PageInfo<LabelPrintShopSkuListResponse> list(LabelPrintShopSkuListRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<LabelPrintShopSkuListResponse> list = customLabelPrintShopSkuMapper.listLabelPrintShopSku(params);
        PageInfo<LabelPrintShopSkuListResponse> page = new PageInfo<LabelPrintShopSkuListResponse>(list);
        return page;
    }

    /**
     * @param labelPrintId@return
     * @description 获取店铺sku
     * @author baixueping
     * @date 2020/4/20 14:52
     */
    @Override
    public List<LabelPrintShopSkuListResponse> listLabelPrintShopSku(Integer labelPrintId) {
        LabelPrintShopSkuListRequest labelPrintShopSkuListRequest=new LabelPrintShopSkuListRequest();
        labelPrintShopSkuListRequest.setLabelPrintId(labelPrintId);
        List<LabelPrintShopSkuListResponse> list = customLabelPrintShopSkuMapper.listLabelPrintShopSku(labelPrintShopSkuListRequest);
        if(!CollectionUtils.isEmpty(list)){
            LabelPrint labelPrint=labelPrintService.getLabelPrint(labelPrintId);
            if(labelPrint!=null){
                list.get(0).setRemark(labelPrint.getRemark());
            }
        }
        return list;
    }
}
