package cn.zach.mutidatasource.mapperone;

import cn.zach.mutidatasource.mappertwo.UserMappertwo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Zach
 * @date 2022/9/26 11:28
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserMapperTest {

    @Autowired
    private UserMapperone userMapperone;

    @Autowired
    private UserMappertwo userMappertwo;

    @Test
    void selectAll() {
        System.out.println(userMapperone.selectAll());
        System.out.println(userMappertwo.selectAll());
    }
}