package com.luckk.lizzie.dto;

import lombok.Data;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 19:38
 * @PackageName: com.luckk.lizzie.dto
 * @ClassName: BuyerCartRequestDTO
 * @Version 1.0
 */
@Data
public class BuyerCartRequestDTO {

    private String userId;
    private Long skuId;
}
