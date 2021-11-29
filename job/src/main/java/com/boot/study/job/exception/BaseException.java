package com.boot.study.job.exception;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/7 10:43
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class BaseException extends RuntimeException{

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
