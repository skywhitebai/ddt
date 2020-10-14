package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SkuMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sku.request.GetPrintTmallSkuRequest;
import com.sky.ddt.dto.sku.request.SkuListRequest;
import com.sky.ddt.dto.sku.response.GetPrintTmallSkuResponse;
import com.sky.ddt.dto.sku.response.SkuExportInfoResponse;
import com.sky.ddt.dto.sku.response.SkuListResponse;

import java.util.List;

/**
 * @author baixueping
 * @description sky操作类
 * @date 2019/5/10 9:25
 */
public interface CustomSkuMapper extends SkuMapper {
    /**
     * @param
     * @return
     * @description 查询sku列表
     * @author baixueping
     * @date 2019/5/10 10:48
     */
    List<SkuListResponse> listSku(SkuListRequest params);

    /**
     * 导出sku信息查询
     *
     * @param params
     * @return
     */
    List<SkuExportInfoResponse> listSkuExportInfo(SkuListRequest params);

    /**
     * @param
     * @return
     * @description 获取天猫打印sku信息
     * @author baixueping
     * @date 2020/4/30 17:11
     */
    GetPrintTmallSkuResponse getPrintTmallSku(GetPrintTmallSkuRequest params);
}
