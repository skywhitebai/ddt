package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transferOrderShopSku.request.ListTransferOrderShopSkuRequest;
import com.sky.ddt.dto.transferOrderShopSku.request.SaveTransferOrderShopSkuRequest;
import com.sky.ddt.dto.transferOrderShopSku.request.SaveTransferQuantityRequest;
import com.sky.ddt.dto.transferOrderShopSku.response.ListTransferOrderShopSkuResponse;
import com.sky.ddt.entity.TransferOrderShopSku;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author baixueping
 * @description 调拨店铺sku
 * @date 2020/8/28 16:28
 */
public interface ITransferOrderShopSkuService {
    boolean existTransferOrderShopSku(Integer id);

    /**
     * @param
     * @return
     * @description 分页查询调拨单店铺sku数据
     * @author baixueping
     * @date 2020/9/1 11:10
     */
    PageInfo<ListTransferOrderShopSkuResponse> listTransferOrderShopSku(ListTransferOrderShopSkuRequest params);

    /**
     * @param
     * @return
     * @description 保存调拨单店铺sku
     * @author baixueping
     * @date 2020/9/1 12:50
     */
    BaseResponse saveTransferOrderShopSku(SaveTransferOrderShopSkuRequest params, Integer dealUserId);

    BaseResponse deleteTransferOrderShopSku(Integer id);

    /**
     * @param
     * @return
     * @description 根据调拨单id查询调拨单店铺sku信息
     * @author baixueping
     * @date 2020/9/1 15:00
     */
    List<TransferOrderShopSku> listTransferOrderShopSku(Integer transferOrderId);
/**
 * @param
 * @return
 * @description 导入调拨单店铺sku
 * @author baixueping
 * @date 2020/9/1 15:54
*/
    BaseResponse importTransferOrderShopSku(MultipartFile file, Integer transferOrderId, Integer dealUserId);

    List<ListTransferOrderShopSkuResponse> listTransferOrderShopSkuByTransferOrderId(Integer transferOrderId);

    BaseResponse saveTransferQuantity(SaveTransferQuantityRequest params, Integer dealUserId);
}
