package cn.zach.jpa.dao;

import cn.zach.jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zach
 * @date 2022/9/26 10:29
 */
@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
//        userDao.save(new User(null,"jpa",18,new Date()));

//        System.out.println(userDao.findById("11"));

        System.out.println(userDao.getAllUsers());


    }

}