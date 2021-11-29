package com.boot.study.vip.model;

import lombok.Getter;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/25 18:16
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Getter
public enum ResultCode implements ICode {

    /**
     * success
     */
    success("ok", 20000L),
    /**
     * fail
     */
    fail("error", 50000L);

    private final String message;
    private final Long code;

    ResultCode(String message, Long code) {
        this.message = message;
        this.code = code;
    }
}
