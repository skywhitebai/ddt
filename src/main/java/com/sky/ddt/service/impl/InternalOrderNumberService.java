package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InternalOrderNumberConstant;
import com.sky.ddt.dao.custom.CustomInternalOrderNumberMapper;
import com.sky.ddt.dto.internalOrderNumber.request.ListInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.request.SaveInternalOrderNumberRequest;
import com.sky.ddt.dto.internalOrderNumber.response.ListInternalOrderNumberResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.InternalOrderNumber;
import com.sky.ddt.entity.InternalOrderNumberExample;
import com.sky.ddt.service.IInternalOrderNumberService;
import com.sky.ddt.service.ITransportTypeService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.PdfUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 内部单号
 * @date 2020/6/30 10:44
 */
@Service
public class InternalOrderNumberService implements IInternalOrderNumberService {
    @Autowired
    CustomInternalOrderNumberMapper customInternalOrderNumberMapper;
    @Autowired
    ITransportTypeService transportTypeService;

    /**
     * @param params@return
     * @description 分页查询内部单号
     * @author baixueping
     * @date 2020/6/30 14:43
     */
    @Override
    public PageInfo<ListInternalOrderNumberResponse> listInternalOrderNumber(ListInternalOrderNumberRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListInternalOrderNumberResponse> list = customInternalOrderNumberMapper.listInternalOrderNumber(params);
        PageInfo<ListInternalOrderNumberResponse> page = new PageInfo<ListInternalOrderNumberResponse>(list);
        return page;
    }

    /**
     * @param params     @return
     * @param dealUserId
     * @description 保存内部单号
     * @author baixueping
     * @date 2020/6/30 15:16
     */
    @Override
    public BaseResponse saveInternalOrderNumber(SaveInternalOrderNumberRequest params, Integer dealUserId) {
        if(transportTypeService.notExistTransportTypeId(params.getTransportTypeId())){
            return BaseResponse.failMessage(InternalOrderNumberConstant.TRANSPORT_TYPE_ID_NOT_EXIST);
        }
        //修改
        if (params.getId() != null) {
            InternalOrderNumber internalOrderNumber = customInternalOrderNumberMapper.selectByPrimaryKey(params.getId());
            if (internalOrderNumber == null) {
                return BaseResponse.failMessage(InternalOrderNumberConstant.ID_NOT_EXIST);
            }
            InternalOrderNumber internalOrderNumberUpdate = new InternalOrderNumber();
            BeanUtils.copyProperties(params, internalOrderNumberUpdate);
            internalOrderNumberUpdate.setUpdateTime(new Date());
            internalOrderNumberUpdate.setUpdateBy(dealUserId);
            customInternalOrderNumberMapper.updateByPrimaryKeySelective(internalOrderNumberUpdate);
            return BaseResponse.success();
        }
        //新增
        InternalOrderNumber internalOrderNumber = new InternalOrderNumber();
        BeanUtils.copyProperties(params, internalOrderNumber);
        internalOrderNumber.setOrderNumber(getOrderNumber());
        internalOrderNumber.setCreateBy(dealUserId);
        internalOrderNumber.setCreateTime(new Date());
        customInternalOrderNumberMapper.insertSelective(internalOrderNumber);
        return BaseResponse.success();
    }

    /**
     * @param id
     * @param response
     * @return
     * @description 下载pdf
     * @author baixueping
     * @date 2020/7/1 10:38
     */
    @Override
    public BaseResponse downPDF(Integer id, HttpServletResponse response) {
        if (id == null) {
            return BaseResponse.failMessage(InternalOrderNumberConstant.ID_EMPTY);
        }
        InternalOrderNumber internalOrderNumber = customInternalOrderNumberMapper.selectByPrimaryKey(id);
        if (internalOrderNumber == null) {
            return BaseResponse.failMessage(InternalOrderNumberConstant.ID_NOT_EXIST);
        }
        try {
            return PdfUtil.exportInternalOrderNumberPdf(internalOrderNumber, response);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.failMessage(e.getMessage());
        }
    }

    /**
     * @param orderNumber@return
     * @description 获取内部单号
     * @author baixueping
     * @date 2020/7/7 16:32
     */
    @Override
    public InternalOrderNumber getInternalOrderNumberByOrderNumber(String orderNumber) {
        if(StringUtils.isEmpty(orderNumber)){
            return null;
        }
        InternalOrderNumberExample example = new InternalOrderNumberExample();
        example.createCriteria().andOrderNumberEqualTo(orderNumber);
        List<InternalOrderNumber> list=customInternalOrderNumberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    private String getOrderNumber() {
        //获取当天数量
        InternalOrderNumberExample example = new InternalOrderNumberExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customInternalOrderNumberMapper.countByExample(example);
        String orderNumber;
        do {
            count++;
            String countStr;
            if (count < 10) {
                countStr = "00" + count;
            } else if (count < 100) {
                countStr = "0" + count;
            } else {
                countStr = count.toString();
            }
            orderNumber = "A" + DateUtil.getFormatStryyyyMMdd(new Date()) + countStr;
        } while (existOrderNumber(orderNumber));
        return orderNumber;
    }

    private boolean existOrderNumber(String orderNumber) {
        InternalOrderNumberExample example = new InternalOrderNumberExample();
        example.createCriteria().andOrderNumberEqualTo(orderNumber);
        return customInternalOrderNumberMapper.countByExample(example) > 0;
    }
}
