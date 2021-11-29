package com.boot.study.tests.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/12/3 15:27
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Controller
public class HomeController {

    @GetMapping({"/"})
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping({"/index"})
    public String index() {
        return "index";
    }

    @GetMapping({"/document"})
    public String doc() {
        return "redirect:/doc.html";
    }
}
