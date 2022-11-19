import cn.zach.rediscluster.RedisClusterApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Zach
 * @date 2022/9/28 22:44
 */
@SpringBootTest(classes = RedisClusterApplication.class)
public class RedisClusterTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void test(){
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
