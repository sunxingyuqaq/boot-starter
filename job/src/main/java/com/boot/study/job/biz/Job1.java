package com.boot.study.job.biz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:48
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
public class Job1 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("job1 running......");
    }
}
