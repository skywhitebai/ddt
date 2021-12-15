package com.sky.ddt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.AnnouncementConstant;
import com.sky.ddt.dao.generate.AnnouncementMapper;
import com.sky.ddt.dto.announcement.request.AnnouncementListRequest;
import com.sky.ddt.dto.announcement.request.AnnouncementSaveRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.Announcement;
import com.sky.ddt.entity.AnnouncementExample;
import com.sky.ddt.service.IAnnouncementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementService implements IAnnouncementService {
    @Autowired
    AnnouncementMapper announcementMapper;
    @Override
    public PageInfo<Announcement> list(AnnouncementListRequest params) {
        PageHelper.startPage(params.getPage(),params.getRows(),true);
        AnnouncementExample example=new AnnouncementExample();
        if(!StringUtils.isEmpty(params.getTitle())){
            example.createCriteria().andTitleLike("%"+params.getTitle()+"%");
        }
        if(params.getStatus()!=null){
            example.createCriteria().andStatusEqualTo(params.getStatus());
        }
        example.setOrderByClause(" create_time desc");
        List<Announcement> list=announcementMapper.selectByExample(example);
        PageInfo<Announcement> page=new PageInfo<Announcement>(list);
        return page;
    }

    @Override
    public BaseResponse save(AnnouncementSaveRequest params, Integer dealUserId) {
        //判断参数是否正确
        StringBuilder sbErro=new StringBuilder();
        if(StringUtils.isEmpty(params.getTitle())){
            sbErro.append(AnnouncementConstant.TITLE_EMPTY);
        }
        if(StringUtils.isEmpty(params.getContent())){
            sbErro.append(AnnouncementConstant.CONTENT_EMPTY);
        }
        if(params.getStatus()==null){
            sbErro.append(AnnouncementConstant.STATUS_EMPTY);
        }else if(!AnnouncementConstant.STATUS_LIST.contains(params.getStatus())){
            sbErro.append(",").append(AnnouncementConstant.STATUS_ERRO);
        }
        if(sbErro.length()>0){
            return BaseResponse.failMessage(sbErro.substring(1));
        }
        Announcement model=new Announcement();
        BeanUtils.copyProperties(params,model);
        if(params.getAnnouncementId()==null){
            model.setCreateBy(dealUserId);
            model.setCreateTime(new Date());
            int res= announcementMapper.insert(model);
            //添加成功
            if(res>0){
                return BaseResponse.success();
            }else{
                //添加失败
                return BaseResponse.fail();
            }
        }else{
            Announcement modelOld=announcementMapper.selectByPrimaryKey(params.getAnnouncementId());
            if(modelOld==null){
                return BaseResponse.failMessage(AnnouncementConstant.ANNOUNCEMENTID_NOT_EXIST);
            }
            model.setUpdateBy(dealUserId);
            model.setUpdateTime(new Date());
            int res= announcementMapper.updateByPrimaryKeySelective(model);
            //修改成功
            if(res>0){
                return BaseResponse.success();
            }else{
                //修改失败
                return BaseResponse.fail();
            }
        }
    }

    @Override
    public BaseResponse delete(List<Integer> announcementIds, Integer dealUserId) {
        if(announcementIds==null||announcementIds.size()==0){
            return BaseResponse.success();
        }
        Announcement model=new Announcement();
        model.setStatus(0);
        model.setUpdateTime(new Date());
        model.setUpdateBy(dealUserId);
        AnnouncementExample example=new AnnouncementExample();
        example.createCriteria().andAnnouncementIdIn(announcementIds);
        int res= announcementMapper.updateByExampleSelective(model,example);
        return BaseResponse.success();
    }
}
