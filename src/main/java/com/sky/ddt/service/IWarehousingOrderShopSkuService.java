package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrderShopSku.request.ListWarehousingOrderShopSkuRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.request.SaveWarehousingOrderShopSkuRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.request.SaveWarehousingQuantityRequest;
import com.sky.ddt.dto.warehousingOrderShopSku.response.ListWarehousingOrderShopSkuResponse;
import com.sky.ddt.entity.WarehousingOrderShopSku;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 入库单店铺sku服务
 * @date 2020/4/23 16:12
 */
public interface IWarehousingOrderShopSkuService {
    /**
     * @param
     * @return
     * @description 列表查询入库单店铺sku
     * @author baixueping
     * @date 2020/4/23 17:06
     */
    PageInfo<ListWarehousingOrderShopSkuResponse> listWarehousingOrderShopSku(ListWarehousingOrderShopSkuRequest listWarehousingOrderShopSkuRequest);

    /**
     * @param
     * @return
     * @description 保存入库单店铺sku
     * @author baixueping
     * @date 2020/4/24 9:49
     */
    BaseResponse saveWarehousingOrderShopSku(SaveWarehousingOrderShopSkuRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 删除入库单店铺sku
     * @author baixueping
     * @date 2020/4/24 9:50
     */
    BaseResponse deleteWarehousingOrderShopSku(Integer id);

    /**
     * @param
     * @param shopSkuId
     * @return
     * @description 判断入库单是否包含生产单店铺sku
     * @author baixueping
     * @date 2020/4/28 10:23
     */
    boolean existProduceOrderShopSku(Integer produceOrderId, Integer shopSkuId);

    /**
     * @param
     * @return
     * @description 判断是否存在店铺sku
     * @author baixueping
     * @date 2020/4/29 17:30
     */
    boolean existWarehousingOrderShopSku(Integer warehousingOrderId);

    /**
     * @param
     * @return
     * @description 查询入库单店铺sku信息
     * @author baixueping
     * @date 2020/5/7 15:28
     */
    List<WarehousingOrderShopSku> listWarehousingOrderShopSku(Integer warehousingOrderId);

    /**
     * @param
     * @return
     * @description 导入入库单店铺sku信息
     * @author baixueping
     * @date 2020/5/9 15:43
     */
    BaseResponse importWarehousingOrderShopSku(MultipartFile file, Integer warehousingOrderId, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 查询入库单店铺sku信息
     * @author baixueping
     * @date 2020/5/9 16:14
     */
    List<ListWarehousingOrderShopSkuResponse> listWarehousingOrderShopSkuByWarehousingOrderId(Integer warehousingOrderId);

    /**
     * @param
     * @return
     * @description 保存入库数量
     * @author baixueping
     * @date 2020/7/17 10:17
     */
    BaseResponse saveWarehousingQuantity(SaveWarehousingQuantityRequest params, Integer dealUserId);
}
