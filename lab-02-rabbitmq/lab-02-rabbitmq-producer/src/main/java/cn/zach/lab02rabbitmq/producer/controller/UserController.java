package cn.zach.lab02rabbitmq.producer.controller;

import cn.zach.lab02rabbitmq.producer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/14 16:03
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/send")
    public void send(String msg) {
        userService.send(msg);
    }


}
