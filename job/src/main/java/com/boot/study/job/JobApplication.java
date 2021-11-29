package com.boot.study.job;

import com.boot.study.job.event.RegisterEvent;
import com.boot.study.job.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:25
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@EnableAsync
@SpringBootApplication
public class JobApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JobApplication.class, args);
        RegisterEvent registerEvent = new RegisterEvent("w");
        registerEvent.setSuccess(true);
        User user = new User();
        user.setId("1");
        user.setName("sxy");
        user.setSex("male");
        registerEvent.setUser(user);
        context.publishEvent(registerEvent);
    }
}
