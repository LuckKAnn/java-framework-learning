package com.luckk.lizzie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 19:21
 * @PackageName: com.luckk.lizzie.config
 * @ClassName: RedisConfiguration
 * @Version 1.0
 */
@Configuration
public class RedisConfiguration {
    /**
     * 自定义 RedisCacheConfiguration
     * @return
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                // 自定义 key 的序列化器
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
                // 自定义 value 的序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(genericJackson2JsonRedisSerializer()))
                // 禁止缓存 null 值
                .disableCachingNullValues();
    }

    /**
     * 自定义 RedisTemplate
     * Key: StringRedisSerializer
     * Value: genericJackson2JsonRedisSerializer
     * HashKey: genericJackson2JsonRedisSerializer
     * HashValue: genericJackson2JsonRedisSerializer
     * @return
     */
    @Bean
    public RedisTemplate<String, Serializable> serializableRedisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(keySerializer());
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(genericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
}
