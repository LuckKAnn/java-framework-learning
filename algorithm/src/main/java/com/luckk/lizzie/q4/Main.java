package com.luckk.lizzie.q4;

import java.util.*;

/**
 * @Author liukun.inspire
 * @Date 2023/3/26 20:35
 * @PackageName: com.luckk.lizzie.q4
 * @ClassName: Main
 * @Version 1.0
 */
public class Main {

    static Map<Integer,Integer> mp = new HashMap<>();
    static int res = 0;
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        // 两个数的最大公约数为a，那么就算再加数字，这个a也不会再变大，但是可能会变小。
        for (int i = 0; i < n; i++) {
            int idx = scanner.nextInt();
            mp.put(idx,mp.getOrDefault(idx,0)+1);
        }



    }

    public static void doProcess(List<Integer> list,int base ,int xishu,int val){

        if (mp.containsKey(val)){
            res = (res+mp.get(val))%MOD;
        }

        val = base*(xishu+1);
        list.add(val);
        int []arr = new int[list.size()];


    }

    public static int gcd(int m,int n){
        return m%n == 0 ? n : gcd(n,m%n);
    }

    public static int getGcdForArray(int []num,int n){
        if (n==1) {
            return num[n-1];
        }
        else{
            return gcd(num[n-1], getGcdForArray(num,n-1));
        }

    }
}
