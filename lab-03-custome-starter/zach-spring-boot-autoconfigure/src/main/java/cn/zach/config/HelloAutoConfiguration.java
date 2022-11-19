package cn.zach.config;

import cn.zach.model.Student;
import cn.zach.starter.IndexController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zach
 * @date 2022/7/20 21:46
 */
@Configuration
public class HelloAutoConfiguration {


    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

    @Bean
    public Student student() {
        return new Student("Zach", 18);
    }
}
