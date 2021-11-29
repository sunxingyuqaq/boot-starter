package com.boot.study.vip.model;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/25 18:11
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class Result<T> {

    private static final String SUCCESS_MESSAGE = "ok";
    private static final Long SUCCESS_CODE = 20000L;

    private T data;
    private String message;
    private Long code;

    public Result(T data, String message, Long code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result() {
        this.data = null;
        this.message = SUCCESS_MESSAGE;
        this.code = SUCCESS_CODE;
    }

    public static <T> Result<T> success() {
        return new Result<>();
    }

    public static <T> Result<T> success(T data, String message, Long code) {
        return new Result<>(data, message, code);
    }
}
