package com.sky.ddt.task;

import com.sky.ddt.service.IProductInventoryQuantityHisService;
import com.sky.ddt.service.ISkuInventoryQuantityHisService;
import com.sky.ddt.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author sky
 * @Description TODO
 * @date 2021/8/20 23:42
 */
@Slf4j
@Component
public class InventoryQuantityHisJob {
    @Autowired
    ISkuInventoryQuantityHisService skuInventoryQuantityHisService;
    @Autowired
    IProductInventoryQuantityHisService productInventoryQuantityHisService;
    @Scheduled(cron ="0 30 4 1 * ?")
    //@Scheduled(cron = "0 0/1 * * * ? ")
    public void scheduled() {
        log.info("{}，生成库存历史记录", DateUtil.getFormatDateStr(new Date()));
        skuInventoryQuantityHisService.saveSkuInventoryQuantityHis();
        productInventoryQuantityHisService.saveProductInventoryQuantityHis();
    }
}
