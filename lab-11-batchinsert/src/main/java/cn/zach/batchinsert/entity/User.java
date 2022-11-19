package cn.zach.batchinsert.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Zach
 * @date 2022/10/9 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 6369334020157905548L;
    private Integer id;
    private String name;
    private Integer age;
    private Boolean sex;
    private String description;
    private String address;
    private String hobbit;

}
