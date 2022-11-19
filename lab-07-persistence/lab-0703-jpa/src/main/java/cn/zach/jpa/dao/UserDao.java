package cn.zach.jpa.dao;

import cn.zach.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Zach
 * @date 2022/9/26 10:13
 */
public interface UserDao extends JpaRepository<User, String> {

    @Query(value = "select * from user where 1=1",nativeQuery = true)
    List<User> getAllUsers();

}
