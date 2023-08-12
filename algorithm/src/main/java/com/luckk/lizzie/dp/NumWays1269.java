package com.luckk.lizzie.dp;

/**
 * @Author liukun.inspire
 * @Date 2023/8/5 15:31
 * @PackageName: com.luckk.lizzie.dp
 * @ClassName: NumWays1269
 * @Version 1.0
 */
// https://leetcode.cn/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/
public class NumWays1269 {

    private static int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {


        // dp[i][j]表示，移动i步之后处于j位置的数目
        /**
         * i  <= 0   <=steps
         *
         * 0<=j<=min(arrLen, steps/2);
         * dp[i][j] = d[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1];
         */

        int farIndex = Math.min(arrLen - 1, steps / 2);
        // int farIndex =arrLen;

        int[][] dp = new int[steps + 1][farIndex + 1];

        // init
        // dp[0][0] = 1, dp[0][i]= 0;

        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= farIndex; j++) {
                int left = j == 0 ? 0 : dp[i - 1][j - 1];
                int right = j == farIndex ? 0 : dp[i - 1][j + 1];
                dp[i][j] = ((left + right) % MOD + dp[i - 1][j]) % MOD;
            }
        }
        return dp[steps][0];
    }


}
