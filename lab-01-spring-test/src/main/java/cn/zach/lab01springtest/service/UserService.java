package cn.zach.lab01springtest.service;

import cn.zach.lab01springtest.entity.User;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/5 01:19
 */
public interface UserService {

    void addUser(String name, int age);

    void updateUser(String name, int age);

    void deleteUser(String name);

    void deleteAll();

    User getUser(String name);


}
