import com.luckk.lizzie.BuyerCartApplication;
import com.luckk.lizzie.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author liukun.inspire
 * @Date 2023/3/24 10:52
 * @PackageName: PACKAGE_NAME
 * @ClassName: HyperLogRedisTest
 * @Version 1.0
 */
@SpringBootTest(classes = BuyerCartApplication.class)
public class HyperLogRedisTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisUtils redisUtils;
    public static final String KEY = "ip_20190301";


    @Test
    public void testHyperLog(){

        HyperLogLogOperations<String, String> hyperLogLog = redisTemplate.opsForHyperLogLog();

        hyperLogLog.add(KEY,"1111","222","333");

        System.out.println(hyperLogLog.size(KEY));

        hyperLogLog.add(KEY, "192.168.0.1", "192.168.0.4");
        System.out.println(hyperLogLog.size(KEY));     // 4

        hyperLogLog.add("ip_20190302", "192.168.0.1", "192.168.0.5");
        System.out.println(hyperLogLog.size("ip_20190302"));

        // union 方法对应 PFMERGE 命令
        hyperLogLog.union("ip_201903", KEY, "ip_20190302");
        System.out.println(hyperLogLog.size("ip_201903"));

    }
}
