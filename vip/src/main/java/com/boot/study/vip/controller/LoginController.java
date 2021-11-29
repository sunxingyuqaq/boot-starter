package com.boot.study.vip.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.boot.study.vip.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/14 11:12
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@RestController("api")
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public void login(@RequestParam String loginId, @RequestParam String password) {
        boolean login = iUserService.login(loginId, password);
        if (login) {
            StpUtil.setLoginId(loginId, "PC");
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        }
        StpUtil.checkLogin();
    }
}
