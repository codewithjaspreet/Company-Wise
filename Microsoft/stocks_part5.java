import java.util.Arrays;

public class stocks_part5 {
        public int maxProfit(int[] prices, int fee) {

            int[][] dp = new int[prices.length][2];

            for (int[] row : dp) {

                Arrays.fill(row, -1);
            }

            return solve2(prices, 0, 1, dp, fee);
        }

        int solve2(int[] prices, int i, int buy, int[][] dp, int fee) {

            if (i == prices.length)
                return 0;

            if (dp[i][buy] != -1)
                return dp[i][buy];

            int profit = 0;

            if (buy == 1) {

                profit += Math.max((-prices[i] + solve2(prices, i + 1, 0, dp, fee)),
                        (solve2(prices, i + 1, 1, dp, fee)));
            }

            else {

                profit += Math.max((prices[i] - fee + solve2(prices, i + 1, 1, dp, fee)),
                        (solve2(prices, i + 1, 0, dp, fee)));
            }

            return dp[i][buy] = profit;

        }
    }
