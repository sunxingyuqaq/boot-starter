package com.boot.study.job.service;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:36
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public interface ScheduleJobService {

    /**
     * job1定时任务
     * @throws Exception e
     */
    void scheduleJob1() throws Exception;

    /**
     * job2定时任务
     * @throws Exception e
     */
    void scheduleJob2() throws Exception;

}
