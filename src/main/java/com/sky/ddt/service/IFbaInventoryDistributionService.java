package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.fbaInventoryDistribution.req.DownFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.req.ListFbaInventoryDistributionReq;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.ListFbaInventoryDistributionResp;
import com.sky.ddt.dto.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author sky
 * @Description fba库存分布
 * @date 2022/4/21 23:27
 */
public interface IFbaInventoryDistributionService {
    PageInfo<ListFbaInventoryDistributionResp> listFbaInventoryDistribution(ListFbaInventoryDistributionReq params);

    BaseResponse importFbaInventoryDistribution(MultipartFile file, Integer dealUserId);

    BaseResponse downFbaInventoryDistribution(DownFbaInventoryDistributionReq params, HttpServletResponse response);
}
