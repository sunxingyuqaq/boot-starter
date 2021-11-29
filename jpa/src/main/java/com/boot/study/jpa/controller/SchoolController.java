package com.boot.study.jpa.controller;

import com.boot.study.jpa.entity.School;
import com.boot.study.jpa.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/7/7 15:42
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@RestController
@RequestMapping("api/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("all")
    public List<School> findByPage(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize) {
        return schoolService.findByPage(pageNumber, pageSize);
    }
}
