package cn.zach.jdbctemplate.dao;

import cn.zach.jdbctemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zach
 * @date 2022/9/25 21:57
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertUser(User user){
        return jdbcTemplate.update("insert into user(name,age,create_by) values(?,?,?)",user.getName(),user.getAge(),user.getCreateBy());
    }

    public int deleteUserById(String id){
        return jdbcTemplate.update("delete from user where id = ?",id);
    }

    public int updateUser(User user){
        return jdbcTemplate.update("update user set name = ?,age = ?,create_by = ? where id = ?",user.getName(),user.getAge(),user.getCreateBy(),user.getId());
    }

    public User selectUserById(String id){
        return jdbcTemplate.queryForObject("select * from user where id = ?",new Object[]{id},(rs,rowNum)->{
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setCreateBy(rs.getDate("create_by"));
            return user;
        });
    }

    public List<User> selectAllUser(){
        return jdbcTemplate.query("select * from user",(rs,rowNum)->{
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setCreateBy(rs.getDate("create_by"));
            return user;
        });
    }
}
