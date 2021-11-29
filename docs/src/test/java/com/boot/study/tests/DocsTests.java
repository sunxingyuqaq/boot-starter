package com.boot.study.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/4/14 9:23
 * @apiNote test
 * @see com.boot.study.tests.BaseApplicationTests
 * @since jdk1.8
 */
@Slf4j
public class DocsTests extends BaseApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        log.info("application name : {}", applicationContext.getDisplayName());
        Assert.notNull(applicationContext, "applicationContext can not be null");
    }
}
