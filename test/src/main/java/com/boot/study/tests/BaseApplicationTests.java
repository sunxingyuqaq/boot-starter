package com.boot.study.tests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Xingyu Sun
 * @date 2020/4/14 9:19
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional(rollbackFor = Exception.class)
public abstract class BaseApplicationTests {
}
