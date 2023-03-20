package com.luckk.lizzie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luckk.lizzie.dto.BuyerCartRequestDTO;
import com.luckk.lizzie.service.BuyerCartRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 19:32
 * @PackageName: com.luckk.lizzie.controller
 * @ClassName: BuyerCartController
 * @Version 1.0
 */
@RestController
public class BuyerCartController {


    @Autowired
    BuyerCartRedisService buyerCartRedisService;

    @GetMapping("/get/{userId}")
    public String getCart(@PathVariable("userId") String userId){
        try {
            return buyerCartRedisService.getBuyerCart(userId);
        } catch (JsonProcessingException e) {
            return "wrong";
        }
    }

    @PostMapping("/card/good")
    public String putCart(@RequestBody BuyerCartRequestDTO requestDTO){
        buyerCartRedisService.putBuyerCart(requestDTO.getUserId(), requestDTO.getSkuId());
        return "success";
    }
}
