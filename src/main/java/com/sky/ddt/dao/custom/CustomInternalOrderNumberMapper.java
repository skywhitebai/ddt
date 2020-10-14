package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.InternalOrderNumberMapper;
import com.sky.ddt.dto.internalOrderNumber.request.ListInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.response.ListInternalOrderNumberResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 内部单号
 * @date 2020/6/30 10:41
 */
public interface CustomInternalOrderNumberMapper extends InternalOrderNumberMapper {
    /**
     * @param
     * @return
     * @description 分页查询内部单号
     * @author baixueping
     * @date 2020/6/30 14:54
    */
    List<ListInternalOrderNumberResponse> listInternalOrderNumber(ListInternalOrderNumberRequest params);
}
