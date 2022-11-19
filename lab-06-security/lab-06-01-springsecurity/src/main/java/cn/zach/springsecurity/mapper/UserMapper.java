package cn.zach.springsecurity.mapper;

import cn.zach.springsecurity.entity.Role;
import cn.zach.springsecurity.entity.User;

import java.util.List;

/**
 * @author Zach
 * @date 2022/9/29 17:40
 */
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getUserRolesByUid(Integer uid);
}
