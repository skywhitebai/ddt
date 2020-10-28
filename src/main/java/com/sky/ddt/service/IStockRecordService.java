package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stockRecord.request.ListStockRecordRequest;
import com.sky.ddt.dto.stockRecord.request.SaveStockRecordRemarkRequest;
import com.sky.ddt.dto.stockRecord.response.ExportStockRecordResponse;
import com.sky.ddt.dto.stockRecord.response.ListStockRecordResponse;
import com.sky.ddt.entity.StockCart;
import com.sky.ddt.entity.StockRecord;

import java.util.List;

/**
 * @author baixueping
 * @description 备货记录
 * @date 2019/8/21 8:50
 */
public interface IStockRecordService {
    /**
     * @param
     * @return
     * @description 创建补货记录
     * @author baixueping
     * @date 2019/8/22 16:10
     */
    BaseResponse createStockRecord(Integer shopId, Integer currentUserId);

    PageInfo<ListStockRecordResponse> listStockRecord(ListStockRecordRequest params);

    /**
     * @param
     * @return
     * @description 获取补货单信息
     * @author baixueping
     * @date 2019/8/23 11:16
     */
    StockRecord getStockRecordById(Integer stockRecordId);

    /**
     * @param
     * @param type
     * @return
     * @description 获取补货单信息下载信息
     * @author baixueping
     * @date 2019/8/23 11:27
     */
    List<ExportStockRecordResponse> listExportStockRecord(Integer stockRecordId, String type);

    /**
     * @param
     * @return
     * @description 保存补货记录备注
     * @author baixueping
     * @date 2020/4/24 15:14
     */
    BaseResponse saveStockRecordRemark(SaveStockRecordRemarkRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取补货车数据
     * @author baixueping
     * @date 2020/10/28 17:12
     */
    List<StockCart> getStockCartListByShopId(Integer shopId, Integer type);

    void deleteStockCartListByShopId(Integer shopId, Integer type);
}
