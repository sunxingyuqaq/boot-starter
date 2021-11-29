package com.boot.study;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/9/15 13:51
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SearchApplication.class);
        builder.run(args);
    }
}
