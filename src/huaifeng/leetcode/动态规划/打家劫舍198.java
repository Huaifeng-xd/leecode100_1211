package huaifeng.leetcode.动态规划;

import java.awt.event.MouseAdapter;

public class 打家劫舍198 {
    // 来到当前屋子可以拿到的多少钱，一种拿当前屋子和之前的屋子和，一种，不拿当前屋子
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        if (nums.length == 1) return nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        if (nums.length == 2) return dp[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
