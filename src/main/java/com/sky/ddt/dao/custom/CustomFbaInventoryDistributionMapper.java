package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FbaInventoryDistributionMapper;
import com.sky.ddt.dto.fbaInventoryDistribution.resp.FbaInventoryDistributionExistInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sky
 * @Description fba库存分布
 * @date 2022/4/21 23:26
 */
public interface CustomFbaInventoryDistributionMapper extends FbaInventoryDistributionMapper {
    List<FbaInventoryDistributionExistInfo> listFbaInventoryDistributionExist(@Param("snapshotDay")Date snapshotDay,@Param("shopSkuList") List<Map<String, String>> list);
}
