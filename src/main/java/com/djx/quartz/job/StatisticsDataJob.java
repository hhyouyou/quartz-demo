package com.djx.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author djx
 * @date 2021/6/2 下午5:16
 */
@Slf4j
@Component
public class StatisticsDataJob extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext context) {

        log.info(" statistics data success !");
    }
}
