package com.boot.study.job.event;

import com.boot.study.job.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/8 8:55
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Setter
@Getter
@ToString
public class RegisterEvent extends ApplicationEvent {

    private User user;
    private Boolean success;

    public RegisterEvent(Object source) {
        super(source);
    }

}
