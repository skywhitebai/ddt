package com.sky.ddt.service.impl.amazon;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.enums.YesOrNoEnum;
import com.sky.ddt.dao.custom.CustomAmazonAuthMapper;
import com.sky.ddt.dto.amazon.AmazonConfig;
import com.sky.ddt.dto.amazon.amazonAuth.request.ListAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.request.SaveAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.request.UpdateAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.response.ListAmazonAuthResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.AmazonAuth;
import com.sky.ddt.entity.AmazonAuthExample;
import com.sky.ddt.service.IShopService;
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
    @Autowired
    IShopService shopService;

    @Override
    public PageInfo<ListAmazonAuthResponse> listAmazonAuth(ListAmazonAuthRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows());
        List<ListAmazonAuthResponse> listAmazonAuthResponseList = customAmazonAuthMapper.listAmazonAuth(params);
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
        JSONObject jsonObject = JSONObject.parseObject(res);
        String refreshToken = jsonObject.getString("refresh_token");
        AmazonAuth amazonAuthExist = getAmazonAuthByMerchantId(params.getSellingPartnerId());
        if (amazonAuthExist != null) {
            AmazonAuth amazonAuthUpdate = new AmazonAuth();
            amazonAuthUpdate.setId(amazonAuthExist.getId());
            amazonAuthUpdate.setRefreshToken(refreshToken);
            amazonAuthUpdate.setUpdateTime(new Date());
            amazonAuthUpdate.setUpdateBy(currentUserId.longValue());
            customAmazonAuthMapper.updateByPrimaryKeySelective(amazonAuthUpdate);
        } else {
            AmazonAuth amazonAuth = new AmazonAuth();
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

    /**
     * @param params        @return
     * @param currentUserId
     * @description 修改亚马逊授权信息
     * @author baixueping
     * @date 2021/6/24 15:57
     */
    @Override
    public BaseResponse updateAmazonAuth(UpdateAmazonAuthRequest params, Integer currentUserId) {
        if (!YesOrNoEnum.containValue(params.getStatus())) {
            return BaseResponse.failMessage("状态错误");
        }
        AmazonAuth amazonAuth = customAmazonAuthMapper.selectByPrimaryKey(params.getId());
        if (amazonAuth == null) {
            return BaseResponse.failMessage("亚马逊授权信息不存在");
        }
        if (amazonAuth.getShopId() != null) {
            if (!amazonAuth.getShopId().equals(params.getShopId())) {
                return BaseResponse.failMessage("店铺不允许修改，请联系管理员");
            }
        }
        if (params.getShopId() != null && amazonAuth.getShopId() == null) {
            if (shopService.getShop(params.getShopId()) == null) {
                return BaseResponse.failMessage("店铺id不存在，请重新选择");
            }
            //判断是否存在
            if (existAmazonAuthByShopId(params.getShopId())) {
                return BaseResponse.failMessage("店铺已存在，请重新选择或者联系管理员");
            }
        }
        AmazonAuth amazonAuthUpdate = new AmazonAuth();
        BeanUtils.copyProperties(params, amazonAuthUpdate);
        amazonAuthUpdate.setUpdateBy(currentUserId.longValue());
        amazonAuthUpdate.setUpdateTime(new Date());
        customAmazonAuthMapper.updateByPrimaryKeySelective(amazonAuthUpdate);
        return BaseResponse.success();
    }

    private boolean existAmazonAuthByShopId(Integer shopId) {
        AmazonAuthExample amazonAuthExample = new AmazonAuthExample();
        amazonAuthExample.createCriteria().andShopIdEqualTo(shopId);
        return customAmazonAuthMapper.countByExample(amazonAuthExample) > 0;
    }

    @Override
    public List<AmazonAuth> listAmazonAuth() {
        AmazonAuthExample amazonAuthExample = new AmazonAuthExample();
        amazonAuthExample.createCriteria().andStatusEqualTo(YesOrNoEnum.YES.getValue());
        return customAmazonAuthMapper.selectByExample(amazonAuthExample);
    }

    private AmazonAuth getAmazonAuthByMerchantId(String sellingPartnerId) {
        AmazonAuthExample amazonAuthExample = new AmazonAuthExample();
        amazonAuthExample.createCriteria().andMerchantIdEqualTo(sellingPartnerId);
        List<AmazonAuth> list = customAmazonAuthMapper.selectByExample(amazonAuthExample);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
