package com.boot.study.job.exception;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:45
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class BadRequestException extends RuntimeException{

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    protected BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
