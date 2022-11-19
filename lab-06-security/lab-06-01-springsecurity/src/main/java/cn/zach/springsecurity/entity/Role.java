package cn.zach.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Zach
 * @date 2022/9/29 17:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Integer id;
    private String name;
    private String nameZh;
}
