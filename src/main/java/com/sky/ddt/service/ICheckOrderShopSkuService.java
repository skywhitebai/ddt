package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.checkOrderShopSku.request.ListCheckOrderShopSkuRequest;
import com.sky.ddt.dto.checkOrderShopSku.request.SaveCheckOrderShopSkuRequest;
import com.sky.ddt.dto.checkOrderShopSku.request.SaveInventoryQuantityNewRequest;
import com.sky.ddt.dto.checkOrderShopSku.response.ListCheckOrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.CheckOrderShopSku;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 盘点单店铺sku
 * @date 2020/5/11 10:47
 */
public interface ICheckOrderShopSkuService {
    /**
     * @param
     * @return
     * @description 盘点单是否包含店铺sku
     * @author baixueping
     * @date 2020/5/11 15:02
     */
    boolean existCheckOrderShopSku(Integer checkOrderId);

    /**
     * @param
     * @return
     * @description 分页查询盘点单店铺sku信息
     * @author baixueping
     * @date 2020/5/11 15:02
     */
    PageInfo<ListCheckOrderShopSkuResponse> listCheckOrderShopSku(ListCheckOrderShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 保存盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 15:24
     */
    BaseResponse saveCheckOrderShopSku(SaveCheckOrderShopSkuRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 删除盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 15:52
     */
    BaseResponse deleteCheckOrderShopSku(Integer id);

    /**
     * @param
     * @return
     * @description 导入盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 16:44
     */
    BaseResponse importCheckOrderShopSku(MultipartFile file, Integer checkOrderId, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 查询盘点单所有店铺sku
     * @author baixueping
     * @date 2020/5/11 17:26
     */
    List<ListCheckOrderShopSkuResponse> listCheckOrderShopSkuByCheckOrderId(Integer checkOrderId);

    /**
     * @param
     * @return
     * @description 获取盘点单店铺sku
     * @author baixueping
     * @date 2020/5/11 17:36
     */
    List<CheckOrderShopSku> listCheckOrderShopSku(Integer checkOrderId);

    /**
     * @param
     * @return
     * @description 保存最新库存数量
     * @author baixueping
     * @date 2020/7/17 11:06
     */
    BaseResponse saveInventoryQuantityNew(SaveInventoryQuantityNewRequest params, Integer dealUserId);
}
