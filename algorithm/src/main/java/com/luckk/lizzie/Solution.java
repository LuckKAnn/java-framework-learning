package com.luckk.lizzie;

/**
 * @Author liukun.inspire
 * @Date 2023/3/23 19:03
 * @PackageName: com.luckk.lizzie
 * @ClassName: Solution
 * @Version 1.0
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class Solution<T> {
    public static void main(String[] args) {
        HashMap<String, String> mp = new HashMap<>();
        HashMap<Integer, Integer> mp2 = new HashMap<>();

        Type superclass = mp.getClass().getGenericSuperclass();
        Type a2 = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        System.out.println(a2);

        Solution<Integer> solution = new Solution<>();

        Type genericSuperclass = solution.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType){
            System.out.println("yes");
        }
        Type actualTypeArgument = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        System.out.println(actualTypeArgument);
        mp.put("hhh", "www");
        mp2.put(11, 11);

    }
}
