package com.boot.study.vip;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/14 10:58
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@SpringBootApplication
public class VipApplication {

    public static void main(String[] args) {
        SpringApplication.run(VipApplication.class, args);
        System.out.println("启动成功：sa-token配置如下：" + SaManager.getConfig());
    }
}
