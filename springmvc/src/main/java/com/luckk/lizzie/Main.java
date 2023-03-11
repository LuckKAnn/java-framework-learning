package com.luckk.lizzie;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author liukun.inspire
 * @Date ${DATE} ${TIME}
 * @PackageName:com.luckk.lizzie
 * @ClassName: ${NAME}
 * @Version 1.0
 */
public class Main {

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length ;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ConcurrentHashMap<String, String> mp = new ConcurrentHashMap<>();
        // mp.put();
        mp.get("ss");
        Main main = new Main();
        int []nums = {1,2,3,4,5};
        System.out.println(main.left_bound(nums, 3));
    }
}