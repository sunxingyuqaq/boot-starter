package com.boot.study.job.controller;

import com.boot.study.job.biz.Job1;
import com.boot.study.job.event.RegisterEvent;
import com.boot.study.job.exception.BadRequestException;
import com.boot.study.job.model.JobXXXBean;
import com.boot.study.job.model.UpdateJobBean;
import com.boot.study.job.model.User;
import com.boot.study.job.service.QuartzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.quartz.JobDataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:27
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@RestController
@Api(value = "quartz增删改查相关API")
@RequestMapping(value = "/quartz")
public class JobController {

    @Autowired
    QuartzService quartzService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @ApiOperation(value = "使用quartz添加job")
    @RequestMapping(value = "/addJob/{jobUUID}", method = RequestMethod.POST)
    public void addQuartzJob(
            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID,
            @ApiParam(name = "JobXXXBean") @RequestBody JobXXXBean jobXXXBean) {

        if (jobXXXBean.getOpenBean() != null) {
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("key01", jobXXXBean.getKey01());
            jobDataMap.put("key02", jobXXXBean.getKey02());
            jobDataMap.put("key03", jobXXXBean.getKey03());
            jobDataMap.put("jobTimeCron", jobXXXBean.getJobTimeCron());
            jobDataMap.put("key04", jobXXXBean.getKey04());
            quartzService.addJob(Job1.class,
                    jobUUID,
                    jobUUID,
                    jobXXXBean.getJobTimeCron(),
                    jobDataMap);
        } else {
            throw new BadRequestException("参数错误");
        }
    }


    @ApiOperation(value = "使用quartz查询所有job")
    @RequestMapping(value = "/queryAllJob", method = RequestMethod.GET)
    public List<Map<String, Object>> queryAllQuartzJob() {
        List<Map<String, Object>> list = quartzService.queryAllJob();
        RegisterEvent registerEvent = new RegisterEvent("w");
        registerEvent.setSuccess(true);
        User user = new User();
        user.setId("1");
        user.setName("sxy");
        user.setSex("male");
        registerEvent.setUser(user);
        applicationEventPublisher.publishEvent(registerEvent);
        return list;
    }


    @ApiOperation(value = "使用quartz查询所有运行job")
    @RequestMapping(value = "/queryRunJob", method = RequestMethod.GET)
    public List<Map<String, Object>> queryRunQuartzJob() {

        List<Map<String, Object>> list = quartzService.queryRunJob();
        return list;
    }

    @ApiOperation(value = "使用quartz删除job")
    @RequestMapping(value = "/deleteJob/{jobUUID}", method = RequestMethod.DELETE)
    public void deleteJob(
            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID) {

        quartzService.deleteJob(jobUUID, jobUUID);
    }


    @ApiOperation(value = "使用quartz修改job的cron时间")
    @RequestMapping(value = "/updateJob/{jobUUID}", method = RequestMethod.PUT)
    public void deleteJob(
            @ApiParam(name = "jobUUID") @PathVariable("jobUUID") String jobUUID,
            @ApiParam(name = "jobCronTime") @RequestBody UpdateJobBean updateJobBean) {

        quartzService.updateJob(jobUUID, jobUUID, updateJobBean.getJobCronTime());

    }

}
