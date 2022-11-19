package cn.zach.lab01springtest.service.impl;

import cn.zach.lab01springtest.entity.User;
import cn.zach.lab01springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/5 01:19
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加用户
     *
     * @param name 名字
     * @param age  年龄
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(String name, int age) {
        jdbcTemplate.execute("insert into test_user(name, age) values('" + name + "', " + age + ")");
    }


    /**
     * 更新用户
     *
     * @param name 名字
     * @param age  年龄
     */
    @Override
    public void updateUser(String name, int age) {
        jdbcTemplate.execute("update test_user set name='" + name + "', age=" + age + " where name='" + name + "'");
    }

    /**
     * 删除用户
     *
     * @param name 名字
     */
    @Override
    public void deleteUser(String name) {
        jdbcTemplate.execute("delete from test_user where name='" + name + "'");
    }

    /**
     * 删除所有
     */
    @Override
    public void deleteAll() {
        jdbcTemplate.execute("delete from test_user");
    }

    /**
     * 获取用户
     *
     * @param name 名字
     */
    @Override
    public User getUser(String name) {
        return jdbcTemplate.queryForObject("select * from test_user where name='" + name + "'", new BeanPropertyRowMapper<>(User.class));
    }


}

