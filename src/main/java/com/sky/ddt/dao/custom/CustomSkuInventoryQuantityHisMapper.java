package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.SkuInventoryQuantityHisMapper;

import java.util.Date;

/**
 * @author sky
 * @Description sku历史库存
 * @date 2021/8/20 23:19
 */
public interface CustomSkuInventoryQuantityHisMapper extends SkuInventoryQuantityHisMapper {
    void saveSkuInventoryQuantityHis(Date month);
}
