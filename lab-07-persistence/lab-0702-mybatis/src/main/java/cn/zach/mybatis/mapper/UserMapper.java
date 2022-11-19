package cn.zach.mybatis.mapper;

import cn.zach.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zach
 * @date 2022/9/25 22:28
 */
public interface UserMapper {

    int insertUser(User user);

    User selectUserById(String id);

    int updateUserById(User user);

    int deleteUserById(String id);


}
