package cn.zach.applicationevent;

import cn.zach.applicationevent.event.MyEvent;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Zach
 * @date 2022/8/2 09:50
 */
@SpringBootApplication
public class ApplicationEvenApplication implements InitializingBean {

    @Autowired
    public ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEvenApplication.class, args);  // 启动应用
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.publishEvent(new MyEvent(this));
    }
}
