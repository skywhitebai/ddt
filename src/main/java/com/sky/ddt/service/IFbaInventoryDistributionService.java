package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.fbaInventoryDistribution.req.ListFbaInventoryDistributionReq;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FbaInventoryDistribution;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sky
 * @Description fba库存分布
 * @date 2022/4/21 23:27
 */
public interface IFbaInventoryDistributionService {
    PageInfo<FbaInventoryDistribution> listFbaInventoryDistribution(ListFbaInventoryDistributionReq params);

    BaseResponse importFbaInventoryDistribution(MultipartFile file, Integer dealUserId);
}
