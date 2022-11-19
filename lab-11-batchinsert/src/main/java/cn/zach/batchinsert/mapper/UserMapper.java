package cn.zach.batchinsert.mapper;

import cn.zach.batchinsert.entity.User;

import java.util.List;

/**
 * @author Zach
 * @date 2022/10/9 17:41
 */
public interface UserMapper {

    void insertUser(User user);

    void insertUserBatch(List<User> user);
}
