package cn.zach.lab02rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/14 01:00
 */
@Configuration
public class TopicRabbitConfig {


    public static final String TOPIC_EXCHANGE = "topicExchange";
    public static final String QUEUE_A = "queueA";
    public static final String QUEUE_B = "queueB";

    /**
     * 定义交换机
     *
     * @return {@link Exchange}
     */
    @Bean
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE).durable(true).build();
    }

    /**
     * 定义队列A
     *
     * @return {@link Queue}
     */
    @Bean
    public Queue queueA() {
        return QueueBuilder.durable(QUEUE_A).build();
    }


    /**
     * 定义队列B
     *
     * @return {@link Queue}
     */
    @Bean
    public Queue queueB() {
        return QueueBuilder.durable(QUEUE_B).build();
    }

    /**
     * 将队列和交换机进行绑定
     *
     * @return {@link Binding}
     */
    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(topicExchange()).with("topic.A.#").noargs();
    }



}
