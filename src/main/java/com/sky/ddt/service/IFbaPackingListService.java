package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.fbaPackingList.request.ListFbaPackingListRequest;
import com.sky.ddt.dto.fbaPackingList.request.ListInvoiceInfoRequest;
import com.sky.ddt.dto.fbaPackingList.response.ListFbaPackingListResponse;
import com.sky.ddt.dto.fbaPackingList.response.ListInvoiceInfoResponse;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author baixueping
 * @description fba装箱单服务
 * @date 2020/7/21 17:02
 */
public interface IFbaPackingListService {
    /**
     * @param
     * @return
     * @description 导入装箱单
     * @author baixueping
     * @date 2020/7/21 17:07
     */
    BaseResponse importFbaPackingList(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 分页查询装箱单数据
     * @author baixueping
     * @date 2020/7/22 11:08
     */

    PageInfo<ListFbaPackingListResponse> listFbaPackingList(ListFbaPackingListRequest params);

    /**
     * @param
     * @param params
     * @return
     * @description 列表查询发票信息
     * @author baixueping
     * @date 2020/7/23 14:56
     */
    PageInfo<ListInvoiceInfoResponse> listInvoiceInfo(ListInvoiceInfoRequest params);

    /**
     * @param
     * @param dealUserId
     * @return
     * @description 生成生产单
     * @author baixueping
     * @date 2020/8/3 20:15
     */
    BaseResponse generateOutboundOrder(Integer id, Integer dealUserId);

    /**
     * @param
     * @param fbaPackingListId
     * @param type
     *@param response @return
     * @description 导出发票
     * @author baixueping
     * @date 2020/8/12 15:55
     */
    BaseResponse downInvoice(Integer fbaPackingListId, String orderNumber, String type, HttpServletResponse response);
}
