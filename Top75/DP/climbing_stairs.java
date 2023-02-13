package Top75.DP;

class Solution {

    public int climbStairsRecursive(int n ){


        if(n == 0) return 1;
        if(n < 0) return 0;

        return climbStairsRecursive(n-1) + climbStairsRecursive(n-2);
    }

    
    public int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }
        return dp[n];

    }

}
