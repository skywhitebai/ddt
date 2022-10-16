package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.TransportTypeConstant;
import com.sky.ddt.dao.custom.CustomTransportTypeMapper;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transportType.request.ListTransportTypeRequest;
import com.sky.ddt.dto.transportType.request.SaveTransportTypeRequest;
import com.sky.ddt.dto.transportType.response.ListTransportTypeResponse;
import com.sky.ddt.entity.TransportType;
import com.sky.ddt.entity.TransportTypeExample;
import com.sky.ddt.service.ITransportTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.enterprise.inject.spi.Bean;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 运输方式服务类
 * @date 2020/7/2 9:47
 */
@Service
public class TransportTypeService implements ITransportTypeService {
    @Autowired
    CustomTransportTypeMapper customTransportTypeMapper;

    /**
     * @param params@return
     * @description 列表查询运输方式
     * @author baixueping
     * @date 2020/7/2 11:29
     */
    @Override
    public PageInfo<TransportType> listTransportType(ListTransportTypeRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        TransportTypeExample example = new TransportTypeExample();
        if (!StringUtils.isEmpty(params.getTransportTypeName())) {
            example.createCriteria().andTransportTypeNameLike("%"+params.getTransportTypeName()+"%");
        }
        example.setOrderByClause(" sort desc ");
        List<TransportType> list = customTransportTypeMapper.selectByExample(example);
        PageInfo<TransportType> page = new PageInfo<TransportType>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存运输渠道
     * @author baixueping
     * @date 2020/7/2 14:57
     */
    @Override
    public BaseResponse saveTransportType(SaveTransportTypeRequest params, Integer dealUserId) {
        if (params.getId() != null) {
            TransportType transportType = customTransportTypeMapper.selectByPrimaryKey(params.getId());
            if (transportType == null) {
                return BaseResponse.failMessage(TransportTypeConstant.ID_NOT_EXIST);
            }
            transportType.setTransportTypeName(params.getTransportTypeName());
            transportType.setSort(params.getSort());
            transportType.setTimeliness(params.getTimeliness());
            transportType.setRemark(params.getRemark());
            if (existTransportTypeName(transportType)) {
                return BaseResponse.failMessage(TransportTypeConstant.TRANSPORT_TYPE_NAME_EXIST);
            }
            transportType.setUpdateBy(dealUserId);
            transportType.setUpdateTime(new Date());
            customTransportTypeMapper.updateByPrimaryKey(transportType);
            return BaseResponse.success();
        }
        TransportType transportType = new TransportType();
        BeanUtils.copyProperties(params, transportType);
        if (existTransportTypeName(transportType)) {
            return BaseResponse.failMessage(TransportTypeConstant.TRANSPORT_TYPE_NAME_EXIST);
        }
        transportType.setCreateBy(dealUserId);
        transportType.setCreateTime(new Date());
        customTransportTypeMapper.insertSelective(transportType);
        return BaseResponse.success();
    }

    /**
     * @return
     * @description 获取下拉信息
     * @author baixueping
     * @date 2020/7/2 15:23
     */
    @Override
    public List<TransportType> comboboxlist() {
        TransportTypeExample example = new TransportTypeExample();
        example.setOrderByClause("sort desc");
        return customTransportTypeMapper.selectByExample(example);
    }

    /**
     * @param transportTypeId@return
     * @description 不存在物流渠道id
     * @author baixueping
     * @date 2020/7/7 9:41
     */
    @Override
    public boolean notExistTransportTypeId(Integer transportTypeId) {
        TransportTypeExample example = new TransportTypeExample();
        TransportTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(transportTypeId);
        return customTransportTypeMapper.countByExample(example) == 0;
    }

    @Override
    public TransportType getTransportType(Integer transportTypeId) {
        return customTransportTypeMapper.selectByPrimaryKey(transportTypeId);
    }

    private boolean existTransportTypeName(TransportType transportType) {
        TransportTypeExample example = new TransportTypeExample();
        TransportTypeExample.Criteria criteria = example.createCriteria();
        criteria.andTransportTypeNameEqualTo(transportType.getTransportTypeName());
        if (transportType.getId() != null) {
            criteria.andIdNotEqualTo(transportType.getId());
        }
        return customTransportTypeMapper.countByExample(example) > 0;
    }
}
