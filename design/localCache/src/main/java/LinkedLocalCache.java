import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2023/4/3 23:46
 * @PackageName: PACKAGE_NAME
 * @ClassName: LinkedLocalCache
 * @Version 1.0
 */
public class LinkedLocalCache<Key, Value> extends LinkedHashMap<Key, Value> {


    private final int maxSize;


    public LinkedLocalCache(int initialCapacity, int maxSize) {
        super(initialCapacity,0.75f,true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Key, Value> eldest) {
        return size() > maxSize;
    }

    public static void main(String[] args) {
        LinkedLocalCache<String, String> cache = new LinkedLocalCache<String, String>(5, 5);
        cache.put("k1","v1");
        cache.put("k2","v1");
        cache.put("k3","v1");
        cache.put("k4","v1");
        cache.put("k5","v1");

        System.out.println(cache.get("k1"));


        cache.put("k6","k6");
        System.out.println(cache.get("k1"));
        System.out.println(cache.get("k2"));

        System.out.println(cache.get("k6"));
    }


}
