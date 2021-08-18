package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.workOrder.request.ListWorkOrderRequest;
import com.sky.ddt.dto.workOrder.request.SaveWorkOrderRequest;
import com.sky.ddt.entity.WorkOrder;

/**
 * @author sky
 * @Description 工单服务
 * @date 2021/8/9 21:30
 */
public interface IWorkOrderService {
    PageInfo<WorkOrder> listWorkOrder(ListWorkOrderRequest params);

    BaseResponse saveWorkOrder(SaveWorkOrderRequest params, Integer dealUserId);

    BaseResponse cancelWorkOrder(Integer id, Integer dealUserId);
}
