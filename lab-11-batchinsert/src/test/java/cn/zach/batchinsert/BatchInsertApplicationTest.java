package cn.zach.batchinsert;

import cn.zach.batchinsert.entity.User;
import cn.zach.batchinsert.mapper.UserMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zach
 * @date 2022/10/9 17:14
 */
@SpringBootTest
class BatchInsertApplicationTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    //    效果最差
    @Test
    public void mybatisSimple() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            users.add(new User(1, "zach", 18, true, UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }
        System.out.println("开始插入----------------");
        long start = System.currentTimeMillis();
        for (User user : users) {
            userMapper.insertUser(user);
        }
        long end = System.currentTimeMillis();
        System.out.println("10w条插入耗时：" + (end - start) + "ms");
    }

    //    效果最好
    @Test
    public void mybatisBatch() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            users.add(new User(1, "zach", 18, true, UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }
        System.out.println("开始插入----------------");
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        long start = System.currentTimeMillis();
        for (User user : users) {
            mapper.insertUser(user);
        }
        sqlSession.commit();
        long end = System.currentTimeMillis();
        System.out.println("10w条插入耗时：" + (end - start) + "ms");
    }

    //    效果一般
    @Test
    public void mybatisIn() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            users.add(new User(1, "zach", 18, true, UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }
        System.out.println("开始插入----------------");
        long start = System.currentTimeMillis();
        userMapper.insertUserBatch(users);
        long end = System.currentTimeMillis();
        System.out.println("1w条插入耗时：" + (end - start) + "ms");
    }


}

