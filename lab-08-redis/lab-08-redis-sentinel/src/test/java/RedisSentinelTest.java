import cn.zach.redissentinel.RedisSentinelApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Zach
 * @date 2022/9/28 15:58
 */
@SpringBootTest(classes = RedisSentinelApplication.class)
public class RedisSentinelTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws InterruptedException {
        while(true){
            try {
                stringRedisTemplate.opsForValue().set("name","zach");
                System.out.println(stringRedisTemplate.opsForValue().get("name"));
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
