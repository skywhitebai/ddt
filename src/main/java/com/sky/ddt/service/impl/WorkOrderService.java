package com.sky.ddt.service.impl;

import com.sky.ddt.dao.custom.CustomWorkOrderMapper;
import com.sky.ddt.service.IWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @Description 工单服务
 * @date 2021/8/9 21:46
 */
@Service
public class WorkOrderService implements IWorkOrderService {
    @Autowired
    CustomWorkOrderMapper customWorkOrderMapper;
}
