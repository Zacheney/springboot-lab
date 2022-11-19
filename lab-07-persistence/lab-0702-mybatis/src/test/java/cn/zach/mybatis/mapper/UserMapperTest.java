package cn.zach.mybatis.mapper;

import cn.zach.mybatis.entity.User;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Zach
 * @date 2022/9/25 23:04
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertUser() {
        User user = new User();
        user.setAge(15);
        user.setName("mybatis");
        user.setCreateBy(DateUtil.now());
        userMapper.insertUser(user);
    }
}