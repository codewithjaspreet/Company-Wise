import java.util.Arrays;

public class stocks_part6 {
        // memoized solution
        public int maxProfit(int[] prices) {
            int dp[][] = new int[prices.length][2];
            for (int temp[] : dp) {
                Arrays.fill(temp, -1);
            }
            return solve(0, 1, prices, dp);
        }

        private int solve(int index, int buy, int prices[], int dp[][]) {
            if (index >= prices.length) {
                return 0;
            }
            if (dp[index][buy] != -1)
                return dp[index][buy];
            if (buy == 1) {
                return dp[index][buy] = Math.max(-prices[index] + solve(index + 1, 0, prices, dp),
                        0 + solve(index + 1, 1, prices, dp));
            }
            return dp[index][buy] = Math.max(prices[index] + solve(index + 2, 1, prices, dp),
                    0 + solve(index + 1, 0, prices, dp));
        }
    }   

