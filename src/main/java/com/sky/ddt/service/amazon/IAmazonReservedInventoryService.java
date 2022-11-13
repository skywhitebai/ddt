package com.sky.ddt.service.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dao.custom.CustomAmazonReservedInventoryMapper;
import com.sky.ddt.dto.amazonReservedInventory.req.ListAmazonReservedInventoryReq;
import com.sky.ddt.dto.amazonReservedInventory.resp.ListAmazonReservedInventoryResp;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sky
 * @Description
 * @date 2022/11/7 13:48
 */
public interface IAmazonReservedInventoryService {
    BaseResponse importAmazonReservedInventory(MultipartFile file, Integer dealUserId);

    PageInfo<ListAmazonReservedInventoryResp> listAmazonReservedInventory(ListAmazonReservedInventoryReq params);
}
