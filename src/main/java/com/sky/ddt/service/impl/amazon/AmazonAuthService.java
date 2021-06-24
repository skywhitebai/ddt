package com.sky.ddt.service.impl.amazon;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.enums.YesOrNoEnum;
import com.sky.ddt.dao.custom.CustomAmazonAuthMapper;
import com.sky.ddt.dto.amazon.AmazonConfig;
import com.sky.ddt.dto.amazon.amazonAuth.request.ListAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.request.SaveAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.response.ListAmazonAuthResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.AmazonAuth;
import com.sky.ddt.entity.AmazonAuthExample;
import com.sky.ddt.service.amazon.IAmazonAuthService;
import com.sky.ddt.util.HttpTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author baixueping
 * @description 亚马逊授权服务
 * @date 2021/6/24 11:04
 */
@Service
public class AmazonAuthService implements IAmazonAuthService {
    @Autowired
    CustomAmazonAuthMapper customAmazonAuthMapper;

    @Override
    public PageInfo<ListAmazonAuthResponse> listAmazonAuth(ListAmazonAuthRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows());
        AmazonAuthExample amazonAuthExample = new AmazonAuthExample();
        AmazonAuthExample.Criteria criteria = amazonAuthExample.createCriteria();
        if (!StringUtils.isEmpty(params.getMerchantId())) {
            criteria.andMerchantIdLike(params.getMerchantId());
        }
        if (!StringUtils.isEmpty(params.getShopName())) {
            criteria.andShopNameLike(params.getShopName());
        }
        if (params.getStatus() != null) {
            criteria.andStatusEqualTo(params.getStatus());
        }
        List<AmazonAuth> amazonAuthList = customAmazonAuthMapper.selectByExample(amazonAuthExample);
        List<ListAmazonAuthResponse> listAmazonAuthResponseList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(amazonAuthList)) {
            amazonAuthList.forEach(item -> {
                ListAmazonAuthResponse listAmazonAuthResponse = new ListAmazonAuthResponse();
                BeanUtils.copyProperties(item, listAmazonAuthResponse);
                listAmazonAuthResponseList.add(listAmazonAuthResponse);
            });
        }
        PageInfo<ListAmazonAuthResponse> pageInfo = new PageInfo<>(listAmazonAuthResponseList);
        return pageInfo;
    }

    @Override
    public BaseResponse saveAmazonAuth(SaveAmazonAuthRequest params, Integer currentUserId) {
        String url = "https://api.amazon.com/auth/o2/token";
        Map<String, String> param = new HashMap<>();
        param.put("grant_type", "authorization_code");
        param.put("code", params.getSpapiOauthCode());
        param.put("client_id", AmazonConfig.INSTANCE.getAmazonAppClientId());
        param.put("client_secret", AmazonConfig.INSTANCE.getAmazonAppClientSecret());
        String res = HttpTool.doPost(url, param);
        if (StringUtils.isEmpty(res)) {
            return BaseResponse.failMessage("授权失败");
        }
        JSONObject jsonObject=JSONObject.parseObject(res);
        String refreshToken=jsonObject.getString("refresh_token");
        AmazonAuth amazonAuthExist=getAmazonAuthByMerchantId(params.getSellingPartnerId());
        if(amazonAuthExist!=null){
            AmazonAuth amazonAuthUpdate=new AmazonAuth();
            amazonAuthUpdate.setId(amazonAuthExist.getId());
            amazonAuthUpdate.setRefreshToken(refreshToken);
            amazonAuthUpdate.setUpdateTime(new Date());
            amazonAuthUpdate.setUpdateBy(currentUserId.longValue());
            customAmazonAuthMapper.updateByPrimaryKeySelective(amazonAuthUpdate);
        }else {
            AmazonAuth amazonAuth=new AmazonAuth();
            amazonAuth.setMerchantId(params.getSellingPartnerId());
            amazonAuth.setMarketplaceId("ATVPDKIKX0DER");
            amazonAuth.setRefreshToken(refreshToken);
            amazonAuth.setCreateTime(new Date());
            amazonAuth.setCreateBy(currentUserId.longValue());
            amazonAuth.setStatus(YesOrNoEnum.YES.getValue());
            customAmazonAuthMapper.insertSelective(amazonAuth);
        }
        return BaseResponse.success();
    }
    private AmazonAuth getAmazonAuthByMerchantId(String sellingPartnerId) {
        AmazonAuthExample amazonAuthExample=new AmazonAuthExample();
        amazonAuthExample.createCriteria().andMerchantIdEqualTo(sellingPartnerId);
        List<AmazonAuth> list=customAmazonAuthMapper.selectByExample(amazonAuthExample);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }
}
