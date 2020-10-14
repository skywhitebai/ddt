package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.produceOrder.request.ListProduceOrderRequest;
import com.sky.ddt.dto.produceOrder.request.SaveProduceOrderRequest;
import com.sky.ddt.dto.produceOrder.response.ListProduceOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FbaPackingList;
import com.sky.ddt.entity.ProduceOrder;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description 生产单服务
 * @date 2020/3/25 10:33
 */
public interface IProduceOrderService {
    /**
     * @param
     * @return
     * @description 分页查询生产单
     * @author baixueping
     * @date 2020/3/27 11:10
     */
    PageInfo<ListProduceOrderResponse> listProduceOrder(ListProduceOrderRequest listProduceOrderRequest);

    /**
     * @param
     * @return
     * @description 保存生产单基本信息
     * @author baixueping
     * @date 2020/3/30 16:23
     */
    BaseResponse saveProduceOrder(SaveProduceOrderRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 作废生产单
     * @author baixueping
     * @date 2020/4/1 10:35
     */
    BaseResponse cancelProduceOrder(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 根据生产单id获取生产单
     * @author baixueping
     * @date 2020/4/2 15:54
     */
    ProduceOrder getProduceOrderById(Integer id);

    /**
     * @param
     * @return
     * @description 根据批次号获取生产单
     * @author baixueping
     * @date 2020/4/17 17:29
     */
    ProduceOrder getProduceOrderByBatchNumber(String batchNumber);

    /**
     * @param
     * @return
     * @description 修改生产单为部分入库
     * @author baixueping
     * @date 2020/5/8 10:38
     */
    void updateProduceOrderPartialStorage(Integer produceOrderId, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 设置生产单为生产完毕
     * @author baixueping
     * @date 2020/5/8 15:29
     */
    BaseResponse finishedProduction(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 导入生产单
     * @author baixueping
     * @date 2020/7/9 10:53
     */
    BaseResponse importProduceOrder(MultipartFile file, Integer dealUserId);

}
