package com.sky.ddt.dto.fbaImport.response;

import com.sky.ddt.entity.FbaImport;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询fba
 * @date 2019/8/15 12:58
 */
@Data
public class ListFbaImportResponse extends FbaImport{
    String shopName;
}
