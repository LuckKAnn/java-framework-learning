package com.luckk.lizzie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liukun.inspire
 * @Date 2023/6/1 16:16
 * @PackageName: com.luckk.lizzie.domain
 * @ClassName: OrderDTO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {


    private Long orderId;
    private String orderName;
    private Integer orderStatus;
}
