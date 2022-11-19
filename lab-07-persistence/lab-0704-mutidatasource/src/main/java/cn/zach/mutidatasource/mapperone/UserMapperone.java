package cn.zach.mutidatasource.mapperone;


import cn.zach.mutidatasource.entiity.User;

import java.util.List;

/**
 * @author Zach
 * @date 2022/9/26 11:20
 */
public interface UserMapperone {

    List<User> selectAll();
}
