package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ShopClientHisMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 店铺客户端历史信息
 *
 * @author sky
 * @date 2019/03/27
 */
public interface CustomShopClientHisMapper extends ShopClientHisMapper {
    /**
     * 判断ip是否存在其他店铺
     *
     * @param shopId
     * @param ip
     * @param macAddress
     * @return
     */
    Boolean clientExistsOtherShop(@Param("shopId")Integer shopId, @Param("ip")String ip,@Param("macAddress") String macAddress);
}
