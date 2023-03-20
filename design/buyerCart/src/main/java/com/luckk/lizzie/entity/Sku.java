package com.luckk.lizzie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 19:12
 * @PackageName: com.luckk.lizzie.entity
 * @ClassName: Sku
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku implements Serializable {

    private Long id;

    private Long goodId;

    private Long shopId;
    private String name;
    private Long price;

}
