package java.com.luckk.lizzie.frameworklearning;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 16:30
 * @PackageName: java.com.luckk.lizzie.frameworklearning
 * @ClassName: ConcurrentHashMapTest
 * @Version 1.0
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String > mp = new ConcurrentHashMap<>();

        System.out.println(mp.size());
        System.out.println(mp.mappingCount());

    }
}
