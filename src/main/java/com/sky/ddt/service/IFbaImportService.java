package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.fbaImport.request.ListFbaImportRequest;
import com.sky.ddt.dto.fbaImport.response.ListFbaImportResponse;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author baixueping
 * @description fba导入服务
 * @date 2019/8/15 10:08
 */
public interface IFbaImportService {
    /**
     * @param
     * @return
     * @description fba导入
     * @author baixueping
     * @date 2019/8/15 10:23
     */
    BaseResponse importFba(MultipartFile file, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 分页查询fba信息
     * @author baixueping
     * @date 2019/8/15 13:01
     */
    PageInfo<ListFbaImportResponse> listFbaImport(ListFbaImportRequest params);
}
