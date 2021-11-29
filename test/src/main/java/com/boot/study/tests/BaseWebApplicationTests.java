package com.boot.study.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/4/14 13:46
 * @apiNote BaseWebApplicationTests
 * @see Object
 * @since jdk1.8
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public abstract class BaseWebApplicationTests {

    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @BeforeEach
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

}
