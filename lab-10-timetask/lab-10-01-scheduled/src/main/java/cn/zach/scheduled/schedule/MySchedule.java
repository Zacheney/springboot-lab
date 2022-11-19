package cn.zach.scheduled.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Zach
 * @date 2022/10/2 14:25
 */
@Component
public class MySchedule {


    @Scheduled(cron = "0/3 * * * * ?")
    public void scheduledTask() {
        System.out.println("hello world");
    }
}
