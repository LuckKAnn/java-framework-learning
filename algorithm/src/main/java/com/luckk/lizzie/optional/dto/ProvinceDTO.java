package com.luckk.lizzie.optional.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author liukun.inspire
 * @Date 2023/7/8 17:41
 * @PackageName: com.luckk.lizzie.optional.dto
 * @ClassName: ProvinceDTO
 * @Version 1.0
 */
@Data
@ToString
public class ProvinceDTO extends Object{

    private String name;
    private volatile String idx;
    private List<ProvinceDTO> children;
}
