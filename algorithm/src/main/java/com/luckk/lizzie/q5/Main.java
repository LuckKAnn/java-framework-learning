package com.luckk.lizzie.q5;

import java.util.*;

/**
 * @Author liukun.inspire
 * @Date 2023/8/12 09:53
 * @PackageName: com.luckk.lizzie.q5
 * @ClassName: Main
 * @Version 1.0
 */
public class Main {

    public static void main(String args[]) {

        Integer max = Integer.MAX_VALUE;
        Integer m2 = 1000000007;
        long res = (max + m2) % 1000000007;
        int i1 = (max + m2) % 1000000007;
        System.out.println(i1);
        System.out.println(res);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            nums.add(num);
        }

        Collections.sort(nums, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o2 - o1);
            }
        });

        long mul = nums.get(0);
        mul %= 7 + 1e9;
        for (int i = 1; i <= k && i < n; i++) {
            mul = mul * (long) (nums.get(i) % (7 + 1e9));
            mul %= 7 + 1e9;
        }

        long sum = mul + k;
        sum %= 7 + 1e9;
        for (int i = k + 1; i < n; i++) {
            sum += nums.get(i);
            sum %= 7 + 1e9;
        }

        System.out.println(sum);
    }

}
