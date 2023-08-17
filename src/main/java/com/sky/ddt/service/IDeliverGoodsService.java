package com.sky.ddt.service;

import com.sky.ddt.dto.deliverGoods.request.InvoiceInfo;
import com.sky.ddt.dto.deliverGoods.request.InvoiceSkuInfo;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author baixueping
 * @description 发货服务
 * @date 2019/9/9 15:37
 */
public interface IDeliverGoodsService {
    /**
     * @param
     * @param response
     * @return
     * @description 生成仓库装箱单
     * @author baixueping
     * @date 2019/9/9 15:46
     */
    BaseResponse generateDeliveryPlan(MultipartFile file, HttpServletResponse response);

    /**
     * @param
     * @param response
     * @return
     * @description 生成仓库装箱单
     * @author baixueping
     * @date 2019/9/9 15:46
     */
    BaseResponse generateWarehousePackingList(MultipartFile file, HttpServletResponse response);

    /**
     * @param
     * @param response
     * @return
     * @description 生成亚马逊装箱单
     * @author baixueping
     * @date 2019/9/9 15:46
     */
    BaseResponse generateAmazonPackingList(MultipartFile file, Integer numberOfBoxes, HttpServletResponse response);

    /**
     * @param
     * @param type
     * @param fbaNo
     * @param response @return
     * @description 生成发票
     * @author baixueping
     * @date 2019/9/9 15:47
     */
    BaseResponse generateInvoice(MultipartFile file, String type, String fbaNo, HttpServletResponse response);

    /**
     * @param
     * @return
     * @description 生成发票
     * @author baixueping
     * @date 2020/8/12 16:59
     */
    BaseResponse generateInvoice(InvoiceInfo invoiceInfo, List<InvoiceSkuInfo> invoiceSkuInfoList, String type, HttpServletResponse response);

    BaseResponse updateInvoiceSkuInfoList(List<InvoiceSkuInfo> invoiceSkuInfoList);
}
