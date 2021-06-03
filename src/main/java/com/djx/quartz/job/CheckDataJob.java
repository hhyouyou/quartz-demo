package com.djx.quartz.job;

import com.djx.quartz.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author djx
 * @date 2021/6/2 下午5:07
 */
@Slf4j
@Component
public class CheckDataJob extends QuartzJobBean {

    private final AtomicInteger count = new AtomicInteger();

    @Resource
    private BusinessService businessService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {

        log.info("check data success ! 调用次数:{}, businessService:{}", count.incrementAndGet(), businessService);

    }


}
