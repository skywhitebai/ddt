package com.sky.ddt.utilddt;

import com.sky.ddt.entity.ShopSku;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author sky
 * @Description 业务工具类
 * @date 2022/2/27 21:19
 */
public class ShopSkuUtil {
    public static List<String> getList(List<Map<String, String>> list, String key) {
        List<String> skuList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);
            String sku = map.get(key);
            if (!StringUtils.isEmpty(sku)) {
                skuList.add(sku);
            }
        }
        return skuList;
    }

    public static ShopSku getShopSkuByShopSku(String sku, List<ShopSku> shopSkuList) {
        Optional<ShopSku> f = shopSkuList.stream().filter(item -> item.getShopSku().equals(sku)).findFirst();
        if (f.isPresent()) {
            return f.get();
        }
        return null;
    }

    public static ShopSku getShopSkuByFnsku(String sku, List<ShopSku> shopSkuList) {
        Optional<ShopSku> f = shopSkuList.stream().filter(item -> item.getFnsku().equals(sku)).findFirst();
        if (f.isPresent()) {
            return f.get();
        }
        return null;
    }

    public static ShopSku getShopSkuByAsin(String asin, List<ShopSku> shopSkuList) {
        Optional<ShopSku> f = shopSkuList.stream().filter(item -> item.getAsin().equals(asin)).findFirst();
        if (f.isPresent()) {
            return f.get();
        }
        return null;
    }
}
