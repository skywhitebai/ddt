package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomSalesGroupUserMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.salesGroupUser.req.ListSalesGroupUserReq;
import com.sky.ddt.dto.salesGroupUser.req.SaveSalesGroupUserReq;
import com.sky.ddt.dto.salesGroupUser.resp.ListSalesGroupUserResp;
import com.sky.ddt.entity.SalesGroupUser;
import com.sky.ddt.entity.SalesGroupUserExample;
import com.sky.ddt.service.ISalesGroupUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @Description
 * @date 2022/3/27 13:40
 */
@Service
public class SalesGroupUserService implements ISalesGroupUserService {
    @Autowired
    CustomSalesGroupUserMapper customSalesGroupUserMapper;

    @Override
    public PageInfo<ListSalesGroupUserResp> listSalesGroupUser(ListSalesGroupUserReq req) {
        PageHelper.startPage(req.getPage(), req.getRows(), true);
        List<ListSalesGroupUserResp> list = customSalesGroupUserMapper.listSalesGroupUser(req);
        PageInfo<ListSalesGroupUserResp> page = new PageInfo(list);
        return page;
    }

    @Override
    public BaseResponse saveSalesGroupUser(SaveSalesGroupUserReq req, Integer currentUserId) {
        if (req.getId() != null) {
            SalesGroupUser salesGroupUserOld = customSalesGroupUserMapper.selectByPrimaryKey(req.getId());
            if (salesGroupUserOld == null) {
                return BaseResponse.failMessage("分组id不存在");
            }
        }
        SalesGroupUser salesGroupUser = new SalesGroupUser();
        BeanUtils.copyProperties(req, salesGroupUser);
        if (existSalesGroupUser(req)) {
            return BaseResponse.failMessage("用户id已存在");
        }
        if(req.getId()==null){
            salesGroupUser.setCreateBy(currentUserId);
            salesGroupUser.setCreateTime(new Date());
            customSalesGroupUserMapper.insertSelective(salesGroupUser);
        }else{
            customSalesGroupUserMapper.updateByPrimaryKeySelective(salesGroupUser);
        }
        return BaseResponse.success();
    }

    private boolean existSalesGroupUser(SaveSalesGroupUserReq req) {
        SalesGroupUserExample salesGroupUserExample = new SalesGroupUserExample();
        SalesGroupUserExample.Criteria criteria = salesGroupUserExample.createCriteria();
        criteria.andUserIdEqualTo(req.getUserId());
        if (req.getId() != null) {
            criteria.andIdNotEqualTo(req.getId());
        }
        return customSalesGroupUserMapper.countByExample(salesGroupUserExample) > 0;
    }
}
