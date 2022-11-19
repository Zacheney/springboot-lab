package cn.zach.jdbctemplate.dao;


import cn.zach.jdbctemplate.entity.User;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Zach
 * @date 2022/9/25 22:16
 */
@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao(){
        User user = new User();
        user.setAge(14);
        user.setName("zach");
        user.setCreateBy(DateUtil.now());
        userDao.insertUser(user);
//        System.out.println(userDao.selectUserById("9"));
//        System.out.println(userDao.selectAllUser());
//        userDao.deleteUserById("1");
    }


}