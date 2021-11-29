package com.boot.study.jpa.enums;

import cn.hutool.core.util.StrUtil;

import java.util.NoSuchElementException;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/7/14 11:40
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public enum RoleEnum {
    // @formatter:off
    /**
     * USER
     */
     USER("user", "10000100"),
    /**
     * TEST
     */
     TEST("test", "20000200"),
    /**
     * ADMIN
     */
    ADMIN("admin", "30000300");
    // @formatter:on

    private String name;
    private String code;

    RoleEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public RoleEnum getRoleByCode(String code) {
        RoleEnum[] values = values();
        for (RoleEnum value : values) {
            if (code.equals(value.getCode())) {
                return value;
            }
        }
        throw new NoSuchElementException(StrUtil.format("error code is {} check your code value", code));
    }
}
