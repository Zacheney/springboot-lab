package cn.zach.transalation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author Zach
 * @date 2022/8/8 22:44
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doUpdateUser() throws InterruptedException {
        log.info("开始更新用户");
        jdbcTemplate.update("update test_user set name = 'zzz' where id = 17");
        log.info("更新用户完成");
        TimeUnit.SECONDS.sleep(150);
    }
}
