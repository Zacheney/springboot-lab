package cn.zach.mybatis.entity;

import java.util.Date;

/**
 * @author Zach
 * @date 2022/9/25 21:54
 */
public class User {
    private String id;
    private String name;
    private Integer age;
    private Date createBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createBy=" + createBy +
                '}';
    }
}
