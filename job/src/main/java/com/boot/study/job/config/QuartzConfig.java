package com.boot.study.job.config;

import com.boot.study.job.biz.SchedulerJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:33
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail scheduleJobDetail() {
        System.out.println("**************************************** scheduler job begin");
        JobDetail jobDetail = JobBuilder.newJob(SchedulerJob.class)
                .withIdentity("schedulerJob")
                .storeDurably()
                .build();
        System.out.println("**************************************** scheduler job end");
        return jobDetail;
    }

    @Bean
    public Trigger scheduleJobDetailTrigger() {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .forJob(scheduleJobDetail())
                .withIdentity("schedulerJob")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(0))
                .startNow()
                .build();
        System.out.println("schedulerJob trigger end");
        return trigger;
    }
}
