import com.luckk.lizzie.SsoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author liukun.inspire
 * @Date 2023/3/19 22:08
 * @PackageName:PACKAGE_NAME
 * @ClassName: RedisTest
 * @Version 1.0
 */
@SpringBootTest(classes = SsoApplication.class)
public class RedisTest {

    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Test
    void testOne() {
        redisTemplate.opsForValue().set("name","卷心菜");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name); //卷心菜
    }
}
