package cn.zach.transalation;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Zach
 * @date 2022/8/9 09:50
 */
@SpringBootTest
public class Test {


    @org.junit.Test
    public void test() {
        Double a = 1.12 + 0.048 + 0.042;
        System.out.println(a);
    }
}
