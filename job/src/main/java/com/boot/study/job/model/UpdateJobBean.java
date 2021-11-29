package com.boot.study.job.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:38
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateJobBean {

    String jobCronTime;

    public String getJobCronTime() {
        return jobCronTime;
    }

    public void setJobCronTime(String jobCronTime) {
        this.jobCronTime = jobCronTime;
    }

}
