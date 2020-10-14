package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.orderImport.request.ListOrderImportRequest;
import com.sky.ddt.dto.orderImport.response.ListOrderImportResponse;
import com.sky.ddt.dto.orderImport.response.OrderShopSkuResponse;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author baixueping
 * @description 导入订单管理
 * @date 2019/8/14 9:49
 */
public interface IOrderImportService {
    /**
     * @param
     * @return
     * @description 导入订单
     * @author baixueping
     * @date 2019/8/14 9:54
     */
    BaseResponse importOrder(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 分页查询导入订单信息
     * @author baixueping
     * @date 2019/8/14 12:44
     */
    PageInfo<ListOrderImportResponse> listOrderImport(ListOrderImportRequest params);

    /**
     * @param
     * @return
     * @description 亚马逊订单号获取店铺sku
     * @author baixueping
     * @date 2019/9/19 15:58
     */
    BaseResponse<List<OrderShopSkuResponse>>  listGetShopSku(MultipartFile file);
}
