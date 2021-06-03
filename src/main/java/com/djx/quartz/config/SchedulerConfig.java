package com.djx.quartz.config;

import com.djx.quartz.job.CheckDataJob;
import com.djx.quartz.job.StatisticsDataJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author djx
 * @date 2021/6/2 下午5:20
 */
@Configuration
public class SchedulerConfig {

    public static class CheckDataJobConfig {

        @Bean("CheckDataJob")
        public JobDetail job() {

            return JobBuilder
                    .newJob(CheckDataJob.class)
                    .withIdentity("CheckDataJob")
                    .storeDurably()
                    .build();

        }


        @Bean("CheckDataJobTrigger")
        public Trigger trigger() {

            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5)
                    .repeatForever();

            return TriggerBuilder.newTrigger()
                    .forJob(job())
                    .withSchedule(simpleScheduleBuilder)
                    .withIdentity("CheckDataJobTrigger")
                    .build();
        }

    }


    public static  class StatisticsDataJobConfig{
        @Bean("StatisticsDataJob")
        public JobDetail job() {

            return JobBuilder
                    .newJob(StatisticsDataJob.class)
                    .withIdentity("StatisticsDataJob")
                    .storeDurably()
                    .build();

        }


        @Bean("StatisticsDataJobTrigger")
        public Trigger trigger() {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");

            return TriggerBuilder.newTrigger()
                    .forJob(job())
                    .withSchedule(cronScheduleBuilder)
                    .withIdentity("StatisticsDataJobTrigger")
                    .build();
        }


    }




}
