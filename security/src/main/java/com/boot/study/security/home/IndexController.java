package com.boot.study.security.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/11/25 15:16
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Controller
public class IndexController {

    @GetMapping({"/","/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/index"})
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping({"/user/hello"})
    @ResponseBody
    public String user() {
        return "user";
    }

    @GetMapping({"/admin/hello"})
    @ResponseBody
    public String admin() {
        return "admin";
    }
}
