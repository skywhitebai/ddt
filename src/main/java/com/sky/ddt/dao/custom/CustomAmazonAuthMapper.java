package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.AmazonAuthMapper;
import com.sky.ddt.dto.amazon.amazonAuth.request.ListAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.response.ListAmazonAuthResponse;
import com.sky.ddt.entity.AmazonAuthExample;

import java.util.List;

/**
 * @author baixueping
 * @description 亚马逊授权
 * @date 2021/6/24 11:06
 */
public interface CustomAmazonAuthMapper extends AmazonAuthMapper {
    List<ListAmazonAuthResponse> listAmazonAuth(ListAmazonAuthRequest amazonAuthExample);
}
