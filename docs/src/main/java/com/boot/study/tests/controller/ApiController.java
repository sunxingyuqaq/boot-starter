package com.boot.study.tests.controller;

import com.boot.study.tests.model.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/4/14 16:41
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Api(value = "docs api test", tags = "test")
@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping("/test")
    @ApiOperation(value = "test", notes = "first api test", tags = "test", response = String.class)
    @ApiImplicitParam(name = "name", required = true, example = "tomcat", dataType = "string", dataTypeClass = String.class, paramType = "query")
    public String test(@RequestParam(name = "name") String name) {
        return "test ok " + name;
    }

    @GetMapping("/test/params")
    @ApiOperation(value = "second", notes = "second api test", tags = "test", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", required = true, example = "tomcat", dataType = "string", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "age", required = true, example = "12", dataType = "int", dataTypeClass = Integer.class, paramType = "query")
    })
    public String testParams(@RequestParam(name = "name") String name, @RequestParam(name = "age") Integer age) {
        return "test ok " + name + ": " + age;
    }

    @GetMapping("/test/{path}")
    @ApiOperation(value = "third", notes = "third api test", tags = "test", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", required = true, example = "tomcat", dataType = "string", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "path", required = true, example = "path", dataType = "string", dataTypeClass = String.class, paramType = "path")
    })
    public String testPath(@RequestParam(name = "name") String name, @PathVariable(name = "path") String path) {
        return path + " test ok " + name;
    }

    @PostMapping("post")
    @ApiOperation(value = "four", notes = "forth api test", tags = "test", response = String.class)
    @ApiImplicitParam(name = "name", required = true, example = "tomcat", dataType = "string", dataTypeClass = String.class, paramType = "query")
    public String post(@RequestParam(name = "name") String name) {
        return "test ok " + name;
    }

    @PostMapping("/post/params")
    @ApiOperation(value = "five", notes = "fifth api test", tags = "test", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", required = true, example = "tomcat", dataType = "string", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "age", required = true, example = "12", dataType = "int", dataTypeClass = Integer.class, paramType = "query")
    })
    public String testPostParams(@RequestParam(name = "name") String name, @RequestParam(name = "age") Integer age) {
        return "test ok " + name + ": " + age;
    }

    @PostMapping(value = "/post/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiOperation(value = "six", notes = "sixth api test", tags = "test", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", required = true, example = "tomcat", dataType = "string", dataTypeClass = String.class, paramType = "form"),
            @ApiImplicitParam(name = "age", required = true, example = "12", dataType = "int", dataTypeClass = Integer.class, paramType = "form")
    })
    public String postForm(@RequestParam(name = "name") String name, @RequestParam(name = "age") Integer age) {
        return "test ok " + name + ": " + age;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiOperation(value = "seven", notes = "seven api test", tags = "test", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", required = true, example = "test username", dataType = "string", dataTypeClass = String.class, paramType = "form"),
            @ApiImplicitParam(name = "address", required = true, example = "test address", dataType = "string", dataTypeClass = String.class, paramType = "form"),
            @ApiImplicitParam(name = "age", required = true, example = "12", dataType = "int", dataTypeClass = Integer.class, paramType = "form")
    })
    public UserDto login(UserDto userDto) {
        return userDto;
    }

    @PostMapping(value = "/loginJson", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "eight", notes = "eight api test", tags = "test", response = UserDto.class)
    public UserDto loginJson(@RequestBody
                             @Validated
                             UserDto userDto) {
        return userDto;
    }
}
