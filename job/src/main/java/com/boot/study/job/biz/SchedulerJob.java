package com.boot.study.job.biz;

import com.boot.study.job.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:34
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
public class SchedulerJob extends QuartzJobBean {

    @Autowired
    QuartzService quartzService;

    @Value("${schedule.cron.withJob1}")
    private String cronTimeJob1;

    public String getCronTimeJob1() {
        return cronTimeJob1;
    }

    @Value("${schedule.cron.withJob2}")
    private String cronTimeJob2;

    public String getCronTimeJob2() {
        return cronTimeJob2;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try{
            //job1先删后增
            log.info("job1: delete scheduleWithJob1");
            quartzService.deleteJob("scheduleWithJob1", "scheduleWithJob1_Group1");

            log.info("job1: add scheduleWithJob1");
            quartzService.addJob(ScheduleWithJob1.class, "scheduleWithJob1",
                    "scheduleWithJob1_Group1", cronTimeJob1, null);

            //按小时定时的job先删后增
            log.info("job2: delete scheduleWithJob2");
            quartzService.deleteJob("scheduleWithJob2", "scheduleWithJob2_Group2");

            log.info("job2: add scheduleWithJob2");
            quartzService.addJob(ScheduleWithJob2.class, "scheduleWithJob2",
                    "scheduleWithJob2_Group2", cronTimeJob2, null);
        } catch (Exception e) {
            log.error("quartz service scheduler job failed!");
            e.printStackTrace();
        }
    }
}
