import java.util.Arrays;

public class stocks_part2 {
    

    // recursive solution
    // time complexity : O(2^n) , space complexity : O(n)
    public int maxProfit(int[] prices) {

        return solve(prices, 0, 1);
    }

    static int solve(int[] prices, int i, int buy) {

        if (i == prices.length)
            return 0;

        int profit = 0;

        if (buy == 1) {

            profit += Math.max((-prices[i] + solve(prices, i + 1, 0)), (solve(prices, i + 1, 1)));
        }

        else {

            profit += Math.max((prices[i] + solve(prices, i + 1, 1)), (solve(prices, i + 1, 0)));
        }

        return profit;

    }

    // memoization

    class Solution {
        public int maxProfit2(int[] prices) {

            int[][] dp = new int[prices.length][2];

            for (int[] row : dp) {

                Arrays.fill(row, -1);
            }

            return solve2(prices, 0, 1, dp);
        }

         int solve2(int[] prices, int i, int buy, int[][] dp) {

            if (i == prices.length)
                return 0;

            if (dp[i][buy] != -1)
                return dp[i][buy];

            int profit = 0;

            if (buy == 1) {

                profit += Math.max((-prices[i] + solve2(prices, i + 1, 0, dp)), (solve2(prices, i + 1, 1, dp)));
            }

            else {

                profit += Math.max((prices[i] + solve2(prices, i + 1, 1, dp)), (solve2(prices, i + 1, 0, dp)));
            }

            return dp[i][buy] = profit;

        }
    }

    // tabulation

    



}
