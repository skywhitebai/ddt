package com.sky.ddt.task;

import com.sky.ddt.service.WorkTaskCreationService;
import com.sky.ddt.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author sky
 * @Description
 * @date 2022/9/11 12:09
 */
@Slf4j
@Component
public class WorkTaskCreationJob {
    @Autowired
    WorkTaskCreationService workTaskCreationService;

    //每天凌晨12.30执行生成当天需要执行的任务信息
    @Scheduled(cron ="0 30 0 * * ?")
    //@Scheduled(cron = "0 0/1 * * * ? ")
    public void scheduled() {
        log.info("{}，生成任务信息", DateUtil.getFormatDateStr(new Date()));
        workTaskCreationService.workTaskCreation();
    }
}
