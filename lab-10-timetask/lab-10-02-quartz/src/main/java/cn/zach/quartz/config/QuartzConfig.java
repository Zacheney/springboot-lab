package cn.zach.quartz.config;

import cn.zach.quartz.job.SecondJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.JobMethodInvocationFailedException;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author Zach
 * @date 2022/10/2 14:50
 */
@Configuration
public class QuartzConfig {

    @Bean
    MethodInvokingJobDetailFactoryBean jobDetail1(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("firstJob");
        bean.setTargetMethod("timeTask");
        return bean;
    }

    @Bean
    JobDetailFactoryBean jobDetail2(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(SecondJob.class);
        return bean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTrigger(){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setRepeatCount(3);
        simpleTriggerFactoryBean.setJobDetail(jobDetail1().getObject());
        simpleTriggerFactoryBean.setStartDelay(10000);
        simpleTriggerFactoryBean.setRepeatInterval(2000);
        return simpleTriggerFactoryBean;
    }


    @Bean
    CronTriggerFactoryBean cronTrigger(){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setCronExpression("0/3 * * * * ? ");
        cronTriggerFactoryBean.setJobDetail(jobDetail2().getObject());
        return cronTriggerFactoryBean;
    }

    @Bean
    SchedulerFactoryBean schedulerFactory(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTrigger().getObject(),cronTrigger().getObject());
        return schedulerFactoryBean;
    }
}
