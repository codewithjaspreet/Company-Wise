package Top75.DP;
// recursive solution

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int ans = solve(coins, amount,dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public int solve(int[] coins, int target,int[] dp) {

        if (target == 0)
            return 0;

        if (target < 0)
            return Integer.MAX_VALUE;

        if(dp[target]  != -1) return dp[target];
  
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {

            int ans = solve(coins, target - coins[i] , dp);

            if (ans != Integer.MAX_VALUE) {

                min = Math.min(min, 1 + ans);
            }
        }

        return dp[target] = min;

    }
}
