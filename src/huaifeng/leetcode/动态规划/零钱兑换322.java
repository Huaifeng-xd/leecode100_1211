package huaifeng.leetcode.动态规划;

import java.util.Arrays;
// 完全背包。
public class 零钱兑换322 {
    // 因为钱可以多次使用，要达到指定额度。所以这是完全背包问题。
    // 完全背包因为要使用到之前的状态。在外种类，内额度的情况下。需要采用正序遍历


    //在背包问题中，外层循环必须体现“阶段推进”（物品），
    //内层循环体现“状态扩展”（容量）；
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        int INF = amount + 1;
        for (int i = 0; i <= coins.length; i++) {
            // 因为是最小值问题，我们让不可以达到的状态设为amount+1即可，这也就是最大。
            Arrays.fill(dp[i], INF);
            // 金额为0的情况，不需要硬币，因此为0个。
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i -1];
            for (int j = 0; j <= amount ; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= coin) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coin] + 1);
                }
            }
        }
        return dp[coins.length][amount] == INF? -1: dp[coins.length][amount];
    }

    // 一维dp的优化
    // 如果是01背包在一维情况下，不可二次使用之前的状态，内层需要倒序。
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int INF = amount + 1;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i -1];
            for (int j = 0; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] = Math.min(dp[j], dp[j-coin] + 1);
                }
            }
        }
        return dp[amount] == INF? -1: dp[amount];
    }
}
