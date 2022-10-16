package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transportType.request.ListTransportTypeRequest;
import com.sky.ddt.dto.transportType.request.SaveTransportTypeRequest;
import com.sky.ddt.dto.transportType.response.ListTransportTypeResponse;
import com.sky.ddt.entity.TransportType;

import java.util.List;

/**
 * @author baixueping
 * @description 运输方式服务类
 * @date 2020/7/2 9:46
 */
public interface ITransportTypeService {
    /**
     * @param
     * @return
     * @description 列表查询运输方式
     * @author baixueping
     * @date 2020/7/2 11:29
     */
    PageInfo<TransportType> listTransportType(ListTransportTypeRequest params);

    /**
     * @param
     * @return
     * @description 保存运输渠道
     * @author baixueping
     * @date 2020/7/2 14:57
     */
    BaseResponse saveTransportType(SaveTransportTypeRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取下拉信息
     * @author baixueping
     * @date 2020/7/2 15:23
     */
    List<TransportType> comboboxlist();

    /**
     * @param
     * @return
     * @description 不存在物流渠道id
     * @author baixueping
     * @date 2020/7/7 9:41
     */
    boolean notExistTransportTypeId(Integer transportTypeId);

    TransportType getTransportType(Integer transportTypeId);
}
