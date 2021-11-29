package com.boot.study.job.biz;

import com.boot.study.job.service.ScheduleJobService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:35
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class ScheduleWithJob1 extends QuartzJobBean {

    @Autowired
    ScheduleJobService scheduleJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("start schedule job1: " + LocalDateTime.now());
        try {
            scheduleJobService.scheduleJob1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
