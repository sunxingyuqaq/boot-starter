package com.boot.study.job.service.impl;

import com.boot.study.job.service.ScheduleJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 11:04
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Override
    public void scheduleJob1() throws Exception {
        log.info("scheduleJob1 run...");
    }

    @Override
    public void scheduleJob2() throws Exception {
        log.info("scheduleJob2 run...");
    }
}
