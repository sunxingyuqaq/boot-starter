package com.boot.study.tests.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/12/8 14:12
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Data
@ApiModel
public class UserDto {

    @NotBlank(message = "username not null")
    private String username;

    private String address;

    @NotNull(message = "age not null")
    @Range(max = 99, min = 18, message = "18 <= age <=99 ")
    private Integer age;
}
