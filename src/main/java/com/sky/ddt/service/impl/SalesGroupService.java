package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomSalesGroupMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.salesGroup.req.ListSalesGroupReq;
import com.sky.ddt.dto.salesGroup.req.SaveSalesGroupReq;
import com.sky.ddt.dto.salesGroup.resp.ListSalesGroupResp;
import com.sky.ddt.entity.SalesGroup;
import com.sky.ddt.entity.SalesGroupExample;
import com.sky.ddt.service.ISalesGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description 销售分组
 * @date 2022/3/26 23:33
 */
@Service
public class SalesGroupService implements ISalesGroupService {
    @Autowired
    CustomSalesGroupMapper customSalesGroupMapper;

    @Override
    public PageInfo<ListSalesGroupResp> listSalesGroup(ListSalesGroupReq req) {
        PageHelper.startPage(req.getPage(), req.getRows(), true);
        List<ListSalesGroupResp> list = customSalesGroupMapper.listSalesGroup(req);
        PageInfo<ListSalesGroupResp> page = new PageInfo(list);
        return page;
    }

    @Override
    public BaseResponse saveSalesGroup(SaveSalesGroupReq req, Integer dealUserId) {
        if (req.getId() != null) {
            SalesGroup salesGroupOld = customSalesGroupMapper.selectByPrimaryKey(req.getId());
            if (salesGroupOld == null) {
                return BaseResponse.failMessage("id不存在");
            }
        }
        if (existGroupName(req)) {
            return BaseResponse.failMessage("分组名不能重复");
        }
        SalesGroup salesGroup=new SalesGroup();
        BeanUtils.copyProperties(req,salesGroup);
        if(req.getId()!=null){
            salesGroup.setUpdateBy(dealUserId);
            salesGroup.setUpdateTime(new Date());
            customSalesGroupMapper.updateByPrimaryKeySelective(salesGroup);
        }else{
            salesGroup.setCreateBy(dealUserId);
            salesGroup.setCreateTime(new Date());
            customSalesGroupMapper.insertSelective(salesGroup);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse deleteSalesGroup(Integer id, Integer currentUserId) {
        SalesGroup salesGroupOld = customSalesGroupMapper.selectByPrimaryKey(id);
        if (salesGroupOld == null) {
            return BaseResponse.failMessage("id不存在");
        }
        salesGroupOld.setStatus(0);
        salesGroupOld.setUpdateTime(new Date());
        salesGroupOld.setUpdateBy(currentUserId);
        customSalesGroupMapper.updateByPrimaryKeySelective(salesGroupOld);
        return BaseResponse.success();
    }

    @Override
    public List<SalesGroup> comboboxlist() {
        SalesGroupExample salesGroupExample = new SalesGroupExample();
        salesGroupExample.setOrderByClause("group_name asc");
        return customSalesGroupMapper.selectByExample(salesGroupExample);
    }

    private boolean existGroupName(SaveSalesGroupReq req) {
        SalesGroupExample salesGroupExample = new SalesGroupExample();
        SalesGroupExample.Criteria criteria = salesGroupExample.createCriteria();
        criteria.andGroupNameEqualTo(req.getGroupName());
        if (req.getId() != null) {
            criteria.andIdNotEqualTo(req.getId());
        }
        return customSalesGroupMapper.countByExample(salesGroupExample) > 0;
    }
}
