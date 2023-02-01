package MorganStanley;

import java.util.Arrays;

public class lis {
    
    public int lengthOfLIS(int[] nums) {

        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] row : dp) {

            Arrays.fill(row, -1);
        }
        return solve(0, -1, nums, dp);
    }

    static int solve(int cur, int prev, int[] nums, int[][] dp) {

        if (cur == nums.length)
            return 0;

        if (dp[cur][prev + 1] != -1)
            return dp[cur][prev + 1];

        int take = 0;

        if (prev == -1 || nums[cur] > nums[prev]) {

            take = 1 + solve(cur + 1, cur, nums, dp);
        }

        int notTake = solve(cur + 1, prev, nums, dp);

        return dp[cur][prev + 1] = Math.max(take, notTake);
    }
}
