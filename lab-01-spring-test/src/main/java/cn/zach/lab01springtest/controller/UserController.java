package cn.zach.lab01springtest.controller;

import cn.zach.lab01springtest.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/8 16:12
 */
@RestController
@RequestMapping("user")
public class UserController {


    @RequestMapping("/getUser")
    public String getUser(String name) {
        return "Hello, " + name;
    }

    @RequestMapping("/getUserJson")
    public String getUserJson(@RequestParam String name) {
        return 1 + "--" + name;
    }
}
