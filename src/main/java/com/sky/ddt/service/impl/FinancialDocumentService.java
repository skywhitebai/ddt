package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.FinancialDocumentConstant;
import com.sky.ddt.common.constant.OutboundOrderConstant;
import com.sky.ddt.common.constant.ProductDevelopConstant;
import com.sky.ddt.common.constant.SbErroEntity;
import com.sky.ddt.dao.custom.CustomFinancialDocumentMapper;
import com.sky.ddt.dto.financialDocument.request.ChangeFinancialDocumentStatusRequest;
import com.sky.ddt.dto.financialDocument.request.ListFinancialDocumentRequest;
import com.sky.ddt.dto.financialDocument.request.SaveFinancialDocumentRequest;
import com.sky.ddt.dto.financialDocument.response.ListFinancialDocumentResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.*;
import com.sky.ddt.service.IFinancialDocumentService;
import com.sky.ddt.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 财务票据管理
 * @date 2022/2/15 23:16
 */
@Service
public class FinancialDocumentService implements IFinancialDocumentService {
    @Autowired
    CustomFinancialDocumentMapper customFinancialDocumentMapper;

    @Override
    public PageInfo<ListFinancialDocumentResponse> listFinancialDocument(ListFinancialDocumentRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        List<ListFinancialDocumentResponse> list=customFinancialDocumentMapper.listFinancialDocument(params);
        PageInfo<ListFinancialDocumentResponse> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public BaseResponse saveFinancialDocument(SaveFinancialDocumentRequest params, Integer dealUserId) {
        SbErroEntity sbErroEntity = new SbErroEntity();
        FinancialDocument financialDocumentOld=null;
        if(params.getId()!=null){
            financialDocumentOld=customFinancialDocumentMapper.selectByPrimaryKey(params.getId());
            if(financialDocumentOld==null){
                sbErroEntity.append("财务单据id不存在");
            }else if(FinancialDocumentConstant.StatusEnum.PASS.getStatus().equals(financialDocumentOld.getStatus())){
                sbErroEntity.append("财务单据已审核通过不允许修改");
            }
        }
        if (sbErroEntity.isFail()) {
            return sbErroEntity.getResponse();
        }
        FinancialDocument financialDocument=new FinancialDocument();
        BeanUtils.copyProperties(params, financialDocument);
        if (params.getId() == null) {
            financialDocument.setNumber(getNumber());
            financialDocument.setStatus(FinancialDocumentConstant.StatusEnum.WAIIT_AUDIT.getStatus());
            financialDocument.setCreateBy(dealUserId);
            financialDocument.setCreateTime(new Date());
            customFinancialDocumentMapper.insertSelective(financialDocument);
        } else {
            financialDocument.setUpdateBy(dealUserId);
            financialDocument.setUpdateTime(new Date());
            customFinancialDocumentMapper.updateByPrimaryKeySelective(financialDocument);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse changeFinancialDocumentStatus(ChangeFinancialDocumentStatusRequest params, Integer dealUserId) {
        if (!FinancialDocumentConstant.StatusEnum.contains(params.getStatus())) {
            return BaseResponse.failMessage("状态错误");
        }
        FinancialDocument financialDocument = customFinancialDocumentMapper.selectByPrimaryKey(params.getId());
        if (financialDocument == null) {
            return BaseResponse.failMessage("id不存在");
        }
        if (FinancialDocumentConstant.StatusEnum.PASS.getStatus().equals(financialDocument.getStatus())) {
            return BaseResponse.failMessage("单据已审核通过，不允许修改");
        }
        FinancialDocument FinancialDocumentUpdate = new FinancialDocument();
        FinancialDocumentUpdate.setId(params.getId());
        FinancialDocumentUpdate.setUpdateBy(dealUserId);
        FinancialDocumentUpdate.setUpdateTime(new Date());
        FinancialDocumentUpdate.setStatus(params.getStatus());
        customFinancialDocumentMapper.updateByPrimaryKeySelective(FinancialDocumentUpdate);
        return BaseResponse.success();
    }

    private String getNumber() {
        String batchNumberFirst = "FD" + DateUtil.getFormatStryyyyMMdd(new Date());
        FinancialDocumentExample example = new FinancialDocumentExample();
        example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.getToday());
        Long count = customFinancialDocumentMapper.countByExample(example);
        String number = "";
        do {
            count++;
            if (count >= 10) {
                number = batchNumberFirst + count.toString();
            } else {
                number = batchNumberFirst + "0" + count.toString();
            }
        }
        while (existNumber(number));
        return number;
    }
    private boolean existNumber(String number) {
        FinancialDocumentExample example = new FinancialDocumentExample();
        example.createCriteria().andNumberEqualTo(number);
        return customFinancialDocumentMapper.countByExample(example) > 0;
    }
}
