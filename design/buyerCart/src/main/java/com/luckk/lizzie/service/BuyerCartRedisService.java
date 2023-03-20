package com.luckk.lizzie.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckk.lizzie.entity.Sku;
import com.luckk.lizzie.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 19:13
 * @PackageName: com.luckk.lizzie.service
 * @ClassName: BuyerCartRedisService
 * @Version 1.0
 */
@Service
@Slf4j
public class BuyerCartRedisService {


    @Autowired
    RedisUtils redisUtils;

    @Autowired
    RedisTemplate redisTemplate;


    public static final String BUYER_CART_TEMPLATE = "lkk_cart_%s";

    private ObjectMapper objectMapper = new ObjectMapper();


    public String getBuyerCart(String userId) throws JsonProcessingException {

        Map<Object, Object> objectObjectMap = redisUtils.hmGetAll(keyGenerate(userId));
        return objectMapper.writeValueAsString(objectObjectMap);
    }


    public void putBuyerCart(String userId, Long skuId) {


        // Object o = redisTemplate.opsForHash().get(userId, skuId);
        // if (Objects.isNull(o)) {
        //     // 没有创建
        //     redisTemplate.opsForHash().put(keyGenerate(userId), skuId, 1);
        // } else {
        //     Long num = (Long) o;
        //     redisTemplate.opsForHash().put(keyGenerate(userId), skuId, num++);
        // }


        Object o = redisUtils.hmGet(keyGenerate(userId), skuId);
        if (Objects.isNull(o)) {
            System.out.println("第一次");
            redisUtils.hmSet(keyGenerate(userId), skuId, 1);
        } else {
            System.out.println("第二次");
            Integer num = (Integer) o;
            redisUtils.hmSet(keyGenerate(userId), skuId, num + 1);
        }
    }

    private String keyGenerate(String userId) {
        return String.format(BUYER_CART_TEMPLATE, userId);
    }

}
