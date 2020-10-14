package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FbaImportMapper;
import com.sky.ddt.dto.fbaImport.request.ListFbaImportRequest;
import com.sky.ddt.dto.fbaImport.response.ListFbaImportResponse;

import java.util.List;

/**
 * @author baixueping
 * @description fba导入
 * @date 2019/8/15 10:07
 */
public interface CustomFbaImportMapper extends FbaImportMapper {
    /**
     * @param
     * @return 
     * @description 分页查询fba信息
     * @author baixueping
     * @date 2019/8/15 13:02
    */
    List<ListFbaImportResponse> listFbaImport(ListFbaImportRequest params);
}
