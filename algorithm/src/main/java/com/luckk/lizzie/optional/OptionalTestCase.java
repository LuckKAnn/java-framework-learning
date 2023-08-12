package com.luckk.lizzie.optional;

import com.alibaba.fastjson2.JSONObject;
import com.luckk.lizzie.optional.dto.ProvinceDTO;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author liukun.inspire
 * @Date 2023/7/8 17:42
 * @PackageName: com.luckk.lizzie.optional
 * @ClassName: OptionalTestCase
 * @Version 1.0
 */
public class OptionalTestCase {

    public static void main(String[] args) {

        BigDecimal multiply = new BigDecimal("1024").multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024"));
        System.out.println(multiply);
    }
}
