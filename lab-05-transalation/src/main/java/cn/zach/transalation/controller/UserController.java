package cn.zach.transalation.controller;

import cn.zach.transalation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach
 * @date 2022/8/8 22:47
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/updateUser")
    public String updateUser() throws InterruptedException {
        userService.doUpdateUser();
        return "success";
    }




}
