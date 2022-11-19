package cn.zach.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach
 * @date 2022/9/29 15:02
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
