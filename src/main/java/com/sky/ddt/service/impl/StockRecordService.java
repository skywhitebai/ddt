package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.OrderImportConstant;
import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.common.constant.StockRecordConstant;
import com.sky.ddt.dao.custom.CustomShopMapper;
import com.sky.ddt.dao.custom.CustomStockCartMapper;
import com.sky.ddt.dao.custom.CustomStockRecordItemMapper;
import com.sky.ddt.dao.custom.CustomStockRecordMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecord.request.ListStockRecordRequest;
import com.sky.ddt.dto.stockRecord.request.SaveStockRecordRemarkRequest;
import com.sky.ddt.dto.stockRecord.response.ExportStockRecordResponse;
import com.sky.ddt.dto.stockRecord.response.ListStockRecordResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IFactoryProductionOrderService;
import com.sky.ddt.service.IShopUserService;
import com.sky.ddt.service.IStockRecordService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 备货记录
 * @date 2019/8/21 8:51
 */
@Service
public class StockRecordService implements IStockRecordService {
    @Autowired
    IShopUserService shopUserService;
    @Autowired
    CustomStockCartMapper customStockCartMapper;
    @Autowired
    CustomShopMapper customShopMapper;
    @Autowired
    CustomStockRecordMapper customStockRecordMapper;
    @Autowired
    CustomStockRecordItemMapper customStockRecordItemMapper;
    @Autowired
    IFactoryProductionOrderService factoryProductionOrderService;

    /**
     * @param shopId
     * @param currentUserId
     * @return
     * @description 创建补货记录
     * @author baixueping
     * @date 2019/8/22 16:10
     */
    @Override
    public BaseResponse createStockRecord(Integer shopId, Integer currentUserId) {
        if (shopId == null) {
            return BaseResponse.failMessage(StockRecordConstant.SHOP_ID_EMPTY);
        }
        if (!shopUserService.exisShopUser(shopId, currentUserId)) {
            return BaseResponse.failMessage(StockRecordConstant.USER_NO_SHOP_RIGHT);
        }
        List<StockCart> stockCartList = getStockCartListByShopId(shopId,StockConsatnt.TypeEnum.REPLENISHMENT.getType());
        if(CollectionUtils.isEmpty(stockCartList)){
            return BaseResponse.failMessage(StockRecordConstant.STOCK_CART_LIST_EMPTY);
        }
        //生成补货记录
        Shop shop=customShopMapper.selectByPrimaryKey(shopId);
        if(shop==null){
            return BaseResponse.failMessage(StockRecordConstant.SHOP_ID_NOT_EXIST);
        }
        String  title=shop.getShopName()+"补货单"+DateUtil.getFormatDateStr(new Date());
        StockRecord stockRecord=new StockRecord();
        stockRecord.setShopId(shopId);
        stockRecord.setCreateBy(currentUserId);
        stockRecord.setCreateTime(new Date());
        stockRecord.setTitle(title);
        customStockRecordMapper.insertSelective(stockRecord);
        //生成补货记录内容
        for(StockCart stockCart:stockCartList){
            StockRecordItem stockRecordItem=new StockRecordItem();
            stockRecordItem.setCreateBy(currentUserId);
            stockRecordItem.setCreateTime(new Date());
            stockRecordItem.setStockQuantity(stockCart.getStockQuantity());
            stockRecordItem.setStockQuantityKy(stockCart.getStockQuantityKy());
            stockRecordItem.setStockQuantityKp(stockCart.getStockQuantityKp());
            stockRecordItem.setStockQuantityHy(stockCart.getStockQuantityHy());
            stockRecordItem.setShopSkuId(stockCart.getShopSkuId());
            stockRecordItem.setStockRecordId(stockRecord.getId());
            stockRecordItem.setProductionQuantity(stockCart.getProductionQuantity());
            customStockRecordItemMapper.insertSelective(stockRecordItem);
        }
        //删除补货购物车信息
        deleteStockCartListByShopId(shopId);
        return BaseResponse.success();
    }

    @Override
    public PageInfo<ListStockRecordResponse> listStockRecord(ListStockRecordRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListStockRecordResponse> list = customStockRecordMapper.listStockRecord(params);
        PageInfo<ListStockRecordResponse> page = new PageInfo<ListStockRecordResponse>(list);
        return page;
    }

    /**
     * @param stockRecordId@return
     * @description 获取补货单信息
     * @author baixueping
     * @date 2019/8/23 11:16
     */
    @Override
    public StockRecord getStockRecordById(Integer stockRecordId) {
        if(stockRecordId==null){
            return null;
        }
        return customStockRecordMapper.selectByPrimaryKey(stockRecordId);
    }

    /**
     * @param stockRecordId@return
     * @description 获取补货单信息下载信息
     * @author baixueping
     * @date 2019/8/23 11:27
     */
    @Override
    public List<ExportStockRecordResponse> listExportStockRecord(Integer stockRecordId,String type) {
        if(stockRecordId==null){
            return new ArrayList<ExportStockRecordResponse>();
        }
        return customStockRecordMapper.listExportStockRecord(stockRecordId,type);
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存补货记录备注
     * @author baixueping
     * @date 2020/4/24 15:14
     */
    @Override
    public BaseResponse saveStockRecordRemark(SaveStockRecordRemarkRequest params, Integer dealUserId) {
        StockRecord stockRecord=new StockRecord();
        stockRecord.setId(params.getStockRecordId());
        stockRecord.setRemark(params.getRemark());
        customStockRecordMapper.updateByPrimaryKeySelective(stockRecord);
        return BaseResponse.success();
    }

    private void deleteStockCartListByShopId(Integer shopId) {
        StockCartExample example=new StockCartExample();
        example.createCriteria().andShopIdEqualTo(shopId);
        customStockCartMapper.deleteByExample(example);
    }

    List<StockCart> getStockCartListByShopId(Integer shopId, Integer type) {
        StockCartExample example=new StockCartExample();
        example.createCriteria().andShopIdEqualTo(shopId).andTypeEqualTo(type);
        return customStockCartMapper.selectByExample(example);
    }
}
