package cn.zach.lab02rabbitmq.comsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/14 16:22
 */
@Component
public class RabbitMQListener {


    @RabbitListener(queues = "queueA")
    public void receive(String msg) {
        System.out.println("Receive message: " + msg);
    }

}
