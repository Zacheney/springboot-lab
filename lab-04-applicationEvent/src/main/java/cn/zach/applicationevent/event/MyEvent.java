package cn.zach.applicationevent.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Zach
 * @date 2022/8/2 09:52
 */
public class MyEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    public MyEvent(Object source) {
        super(source);
    }
}

