package huaifeng.leetcode.动态规划;

import java.util.Arrays;

public class 完全平方数279 {

    // 写法类似零钱兑换，零钱是我们找到1到开根号，额度是这个n，每次拼就是零钱的平方
    public int numSquares(int n) {
        int l = (int) Math.sqrt(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for (int i = 1; i <= l; i++) {
            int cur = i * i;
            for (int j = 0; j <= n; j++) {
                if(j >= cur) {
                    dp[j] = Math.min(dp[j], dp[j - cur] + 1);
                }
            }
        }
        return dp[n] == n+1 ? -1 :dp[n];
    }
}
