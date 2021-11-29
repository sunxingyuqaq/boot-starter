package com.boot.study.entity;

import lombok.Data;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/9/15 14:09
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Data
public class Hero {

    private Integer id;
    private String name;
    private String country;
    private String birthday;
    private Integer longevity;

}
