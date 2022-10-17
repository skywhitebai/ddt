package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.InternalOrderNumberConstant;
import com.sky.ddt.dao.custom.CustomInternalOrderNumberMapper;
import com.sky.ddt.dao.custom.CustomInternalOrderNumberTransportMapper;
import com.sky.ddt.dto.internalOrderNumber.request.*;
import com.sky.ddt.dto.internalOrderNumber.response.ListInternalOrderNumberResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IInternalOrderNumberFinancialRemarkHisService;
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
import java.util.stream.Collectors;

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
    @Autowired
    CustomInternalOrderNumberTransportMapper customInternalOrderNumberTransportMapper;
    @Autowired
    IInternalOrderNumberFinancialRemarkHisService internalOrderNumberFinancialRemarkHisService;

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
        TransportType transportType = transportTypeService.getTransportType(params.getTransportTypeId());
        if (transportType == null) {
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
            if (!params.getTransportTypeId().equals(internalOrderNumber.getTransportTypeId())) {
                if (transportType.getTimeliness() != null) {
                    internalOrderNumberUpdate.setEstimatedArrivalTime(DateUtil.plusDay(transportType.getTimeliness(), internalOrderNumberUpdate.getCreateTime()));
                } else {
                    internalOrderNumberUpdate.setEstimatedArrivalTime(null);
                }
            }
            internalOrderNumberUpdate.setUpdateTime(new Date());
            internalOrderNumberUpdate.setUpdateBy(dealUserId);
            customInternalOrderNumberMapper.updateByPrimaryKeySelective(internalOrderNumberUpdate);
            if (!internalOrderNumber.getFinancialRemark().equals(params.getFinancialRemark())) {
                internalOrderNumberFinancialRemarkHisService.addInternalOrderNumberFinancialRemarkHis(params.getFinancialRemark(), params.getId(), dealUserId);
            }
            return BaseResponse.success();
        }
        //新增
        InternalOrderNumber internalOrderNumber = new InternalOrderNumber();
        BeanUtils.copyProperties(params, internalOrderNumber);
        internalOrderNumber.setOrderNumber(getOrderNumber());
        internalOrderNumber.setCreateBy(dealUserId);
        internalOrderNumber.setCreateTime(new Date());
        if(params.getEstimatedArrivalTime()==null){
            if (transportType.getTimeliness() != null) {
                internalOrderNumber.setEstimatedArrivalTime(DateUtil.plusDay(transportType.getTimeliness(), DateUtil.getToday()));
            } else {
                internalOrderNumber.setEstimatedArrivalTime(null);
            }
        }
        customInternalOrderNumberMapper.insertSelective(internalOrderNumber);
        if (StringUtils.isEmpty(params.getFinancialRemark())) {
            internalOrderNumberFinancialRemarkHisService.addInternalOrderNumberFinancialRemarkHis(params.getFinancialRemark(), internalOrderNumber.getId(), dealUserId);
        }
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
        if (StringUtils.isEmpty(orderNumber)) {
            return null;
        }
        InternalOrderNumberExample example = new InternalOrderNumberExample();
        example.createCriteria().andOrderNumberEqualTo(orderNumber);
        List<InternalOrderNumber> list = customInternalOrderNumberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public BaseResponse saveFinancialRemark(SaveInternalOrderNumberFinancialRemarkRequest params, Integer dealUserId) {
        InternalOrderNumber internalOrderNumber = customInternalOrderNumberMapper.selectByPrimaryKey(params.getId());
        if (internalOrderNumber == null) {
            return BaseResponse.failMessage(InternalOrderNumberConstant.ID_NOT_EXIST);
        }
        if (internalOrderNumber.getFinancialRemark().equals(params.getFinancialRemark())) {
            return BaseResponse.success();
        }
        InternalOrderNumber internalOrderNumberUpdate = new InternalOrderNumber();
        internalOrderNumberUpdate.setId(params.getId());
        internalOrderNumberUpdate.setFinancialRemark(params.getFinancialRemark());
        internalOrderNumberUpdate.setUpdateTime(new Date());
        internalOrderNumberUpdate.setUpdateBy(dealUserId);
        customInternalOrderNumberMapper.updateByPrimaryKeySelective(internalOrderNumberUpdate);
        if (!internalOrderNumber.getFinancialRemark().equals(params.getFinancialRemark())) {
            internalOrderNumberFinancialRemarkHisService.addInternalOrderNumberFinancialRemarkHis(params.getFinancialRemark(), params.getId(), dealUserId);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse savePayAmount(SaveInternalOrderNumberPayAmountRequest params, Integer dealUserId) {
        InternalOrderNumber internalOrderNumber = customInternalOrderNumberMapper.selectByPrimaryKey(params.getId());
        if (internalOrderNumber == null) {
            return BaseResponse.failMessage(InternalOrderNumberConstant.ID_NOT_EXIST);
        }
        InternalOrderNumber internalOrderNumberUpdate = new InternalOrderNumber();
        internalOrderNumberUpdate.setId(params.getId());
        internalOrderNumberUpdate.setPayAmount(params.getPayAmount());
        internalOrderNumberUpdate.setUpdateTime(new Date());
        internalOrderNumberUpdate.setUpdateBy(dealUserId);
        customInternalOrderNumberMapper.updateByPrimaryKeySelective(internalOrderNumberUpdate);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse generateTheoreticalAmount(GenerateTheoreticalAmountRequest params) {
        //判断是否有没有头程费率或者没有重量的
        List<InternalOrderNumberTransport> internalOrderNumberTransportsNoHeadTripCostRates = customInternalOrderNumberTransportMapper.queryInternalOrderNumberTransportsNoHeadTripCostRate(params);
        if (!CollectionUtils.isEmpty(internalOrderNumberTransportsNoHeadTripCostRates)) {
            String subOrderNumbers = internalOrderNumberTransportsNoHeadTripCostRates.stream().map(item -> item.getSubOrderNumber()).collect(Collectors.joining(","));
            if (subOrderNumbers.length() > 500) {
                subOrderNumbers = subOrderNumbers.substring(0, 500);
            }
            return BaseResponse.failMessage("以下内部单号子单号的头程费率为空或者小于等于0：" + subOrderNumbers);
        }
        List<String> skuNoWeights = customInternalOrderNumberMapper.querySkuNoWeight(params);
        if (!CollectionUtils.isEmpty(skuNoWeights)) {
            String skus = skuNoWeights.stream().collect(Collectors.joining(","));
            if (skus.length() > 500) {
                skus = skus.substring(0, 500);
            }
            return BaseResponse.failMessage("以下sku重量为空或者小于等于0：" + skus);
        }
        int count = customInternalOrderNumberMapper.generateTheoreticalAmount(params);
        if (count > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failMessage("没有需要更新的数据");
    }

    @Override
    public List<ListInternalOrderNumberResponse> listExportInternalOrderNumber(ListInternalOrderNumberRequest params) {
        return customInternalOrderNumberMapper.listInternalOrderNumber(params);
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
