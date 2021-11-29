package com.boot.study.jpa;

import com.boot.study.jpa.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/19 13:56
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        ExcelUtils.INSTANCE.test();
        SpringApplication.run(JpaApplication.class, args);
    }
}
