package com.sky.ddt.dto.fbaInventoryDistribution.resp;

import com.sky.ddt.entity.FbaInventoryDistribution;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/4/26 23:06
 */
@Data
public class ListFbaInventoryDistributionResp extends FbaInventoryDistribution {
    String shopName;
}
