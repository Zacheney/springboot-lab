package cn.zach.quartz.job;

import org.springframework.stereotype.Component;

/**
 * @author Zach
 * @date 2022/10/2 14:48
 */
@Component(value = "firstJob")
public class FirstJob {

    public void timeTask(){
        System.out.println("hello world,this is First job");
    }

}
