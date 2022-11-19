package cn.zach.sessionshare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Zach
 * @date 2022/9/29 14:27
 */
@RestController
public class SessionController {


    @GetMapping("/set")
    public String setSession(String name, HttpSession session){
        session.setAttribute("name",name);
        return "set success";
    }

    @GetMapping("/get")
    public String getSession(HttpSession session){
        return session.getAttribute("name").toString();
    }
}
