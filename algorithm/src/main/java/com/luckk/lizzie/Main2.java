package com.luckk.lizzie;

import java.util.Scanner;

/**
 * @Author liukun.inspire
 * @Date 2023/3/16 19:55
 * @PackageName:com.luckk.lizzie
 * @ClassName: Main2
 * @Version 1.0
 */
public class Main2 {

    static int size = 101;
    public static void main(String[] args) {
        // 背包问题
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int v = input.nextInt();
        int [][]price = new int[size][size];
        int [][]value = new int[size][size];

        int []numArr = new int[size];
        for (int i = 0; i < n ; i++) {
            int num = input.nextInt();
            numArr[i] = num;
            for (int j = 0; j < num ; j++) {
                price[i][j] = input.nextInt();
            }
            for (int j = 0; j < num; j++) {
                value[i][j] = input.nextInt();
            }
        }
        int[] dp = new int[size];
        for (int i = 0; i < n; i++) {
            for (int j = v; j >=0; j--) {
                for (int k = 0; k < numArr[i]; k++) {

                    if (j>=price[i][k]) {
                        System.out.println(dp[j]);
                        System.out.println(dp[j-price[i][k]]);
                        System.out.println(value[i][k]);
                        dp[j] = Math.max(dp[j],dp[j-price[i][k]]+value[i][k]);
                    }

                }
            }
        }

        System.out.println(dp[v]);
    }
}
