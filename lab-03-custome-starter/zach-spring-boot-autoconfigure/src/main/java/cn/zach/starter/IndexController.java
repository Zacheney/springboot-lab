package cn.zach.starter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach
 * @date 2022/7/20 21:41
 */
@RestController
public class IndexController {


    @RequestMapping("/index")
    public String index() {
        return "Hello World";
    }

}
