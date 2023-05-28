import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author liukun.inspire
 * @Date 2023/4/4 00:04
 * @PackageName: PACKAGE_NAME
 * @ClassName: CaffineLoadingCache
 * @Version 1.0
 */
public class CaffineLoadingCache {
    static LoadingCache<String, String> cache = Caffeine.newBuilder()
            .maximumSize(3)
            .expireAfterAccess(1000, TimeUnit.MILLISECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public @Nullable String load(@NonNull String s) throws Exception {
                    // return UUID.randomUUID().toString();
                    return null;
                }

                @Override
                public @NonNull Map<@NonNull String, @NonNull String> loadAll(@NonNull Iterable<? extends @NonNull String> keys) throws Exception {
                    return CacheLoader.super.loadAll(keys);
                }
            });

    public static void main(String[] args) throws InterruptedException {

        cache.put("k1", "k1");
        cache.put("k2", "k2");
        cache.put("k3", "k3");
        cache.put("k4", "k4");
        cache.put("k5", "k5");

        System.out.println(cache.get("k1"));
        cache.put("k6", "k6");
        System.out.println(cache.estimatedSize());
        System.out.println(cache.get("k2"));

        System.out.println(cache.get("k6"));
        Thread.sleep(1000);
        System.out.println(cache.get("k6"));

    }
}
