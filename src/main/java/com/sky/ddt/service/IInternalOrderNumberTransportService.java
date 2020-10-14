package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.internalOrderNumberTransport.request.AddInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.request.ListInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.request.SaveInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.response.ListInternalOrderNumberTransportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 内部单号物流信息
 * @date 2020/7/1 16:43
 */
public interface IInternalOrderNumberTransportService {
    /**
     * @param
     * @return
     * @description 分页查询内部单号运输信息
     * @author baixueping
     * @date 2020/7/3 14:40
     */
    PageInfo<ListInternalOrderNumberTransportResponse> listInternalOrderNumberTransport(ListInternalOrderNumberTransportRequest params);

    /**
     * @param
     * @return
     * @description 保存内部单号运输管理
     * @author baixueping
     * @date 2020/7/6 14:27
     */
    BaseResponse saveInternalOrderNumberTransport(SaveInternalOrderNumberTransportRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 批量添加内部单号发货信息
     * @author baixueping
     * @date 2020/7/7 16:08
     */
    BaseResponse batchAddInternalOrderNumberTransport(List<AddInternalOrderNumberTransportRequest> list, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 导入转单号
     * @author baixueping
     * @date 2020/7/14 11:01
     */
    BaseResponse importTransferOrderNo(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 导出内部单号发货记录
     * @author baixueping
     * @date 2020/7/22 11:46
     */
    List<ListInternalOrderNumberTransportResponse> listExportInternalOrderNumberTransport(ListInternalOrderNumberTransportRequest params);

    /**
     * @param
     * @return
     * @description 导入头程费率
     * @author baixueping
     * @date 2020/8/13 14:36
     */
    BaseResponse importHeadTripCostRate(MultipartFile file, Integer dealUserId);


    boolean existHeadTripCostRateNull(Integer shopId, Date monthDate);

    /**
     * @param
     * @return
     * @description 锁定头程费率
     * @author baixueping
     * @date 2020/8/18 17:19
     */
    void lockHeadTripCostRate(Integer shopId, Date monthDate);
}
