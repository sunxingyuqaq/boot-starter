package com.boot.study.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/4/14 13:53
 * @apiNote DocsRestTests
 * @see Object
 * @since jdk1.8
 */
@Slf4j
public class DocsRestTests extends BaseWebApplicationTests {

    @Test
    public void rest() {
        log.info("servlet : {}", mockMvc.getDispatcherServlet());
        Assert.notNull(mockMvc, "mockMvc can not be null");
        try {
            String content = mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
            log.info("result is -------->>>> {}", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
