package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.InternalOrderNumberTransportMapper;
import com.sky.ddt.dto.internalOrderNumberTransport.request.ListInternalOrderNumberTransportRequest;
import com.sky.ddt.dto.internalOrderNumberTransport.response.ListInternalOrderNumberTransportResponse;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 内部单号服务类
 * @date 2020/7/1 16:51
 */
public interface CustomInternalOrderNumberTransportMapper extends InternalOrderNumberTransportMapper {
    List<ListInternalOrderNumberTransportResponse> listInternalOrderNumberTransport(ListInternalOrderNumberTransportRequest params);

    Long existHeadTripCostRateNull(@Param("shopId") Integer shopId, @Param("month") Date month);

    void lockHeadTripCostRate(@Param("shopId") Integer shopId, @Param("month") Date monthDate);
}
