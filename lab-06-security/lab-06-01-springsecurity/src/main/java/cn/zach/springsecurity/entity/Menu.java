package cn.zach.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Zach
 * @date 2022/10/1 21:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Integer id;
    private String pattern;
    private List<Role> roles;

}
