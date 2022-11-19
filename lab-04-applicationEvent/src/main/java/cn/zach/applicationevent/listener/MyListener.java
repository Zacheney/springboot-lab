package cn.zach.applicationevent.listener;

import cn.zach.applicationevent.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Zach
 * @date 2022/8/2 09:54
 */
@Component
@Slf4j
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("事件执行啦。。。。");
    }
}
