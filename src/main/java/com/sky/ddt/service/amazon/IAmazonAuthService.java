package com.sky.ddt.service.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.amazon.amazonAuth.request.ListAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.request.SaveAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.request.UpdateAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.response.ListAmazonAuthResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.AmazonAuth;

import java.util.List;

/**
 * @author baixueping
 * @description 亚马逊授权信息
 * @date 2021/6/24 11:03
 */
public interface IAmazonAuthService {
    PageInfo<ListAmazonAuthResponse> listAmazonAuth(ListAmazonAuthRequest params);

    BaseResponse saveAmazonAuth(SaveAmazonAuthRequest params, Integer currentUserId);

    /**
     * @param
     * @param currentUserId
     * @return
     * @description 修改亚马逊授权信息
     * @author baixueping
     * @date 2021/6/24 15:57
     */
    BaseResponse updateAmazonAuth(UpdateAmazonAuthRequest params, Integer currentUserId);

    List<AmazonAuth> listAmazonAuth();
}
