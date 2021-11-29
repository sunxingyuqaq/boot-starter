package com.boot.study.job.listener;

import com.boot.study.job.event.RegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/8 8:59
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Order(999)
@Slf4j
@Component
public class MailListener {

    @Async
    @EventListener
    public void listener(RegisterEvent registerEvent) {
        log.info("mail add " + registerEvent.getUser());
    }
}
