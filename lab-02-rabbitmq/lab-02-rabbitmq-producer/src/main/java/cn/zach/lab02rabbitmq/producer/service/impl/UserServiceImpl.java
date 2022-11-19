package cn.zach.lab02rabbitmq.producer.service.impl;

import cn.zach.lab02rabbitmq.producer.config.TopicRabbitConfig;
import cn.zach.lab02rabbitmq.producer.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/14 16:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String msg) {
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE,"topic.A.message", msg);
    }
}
