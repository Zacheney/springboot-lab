package cn.zach.lab02rabbitmq.producer.service;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/14 16:04
 */
public interface UserService {
    void send(String msg);
}
