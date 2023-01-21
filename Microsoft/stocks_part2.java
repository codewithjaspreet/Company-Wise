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

    class stocks_part2_1 {
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

    class stocks_part2_2{

        public int maxProfit3(int[] prices) {

            int[][] dp = new int[prices.length][2];

            for (int[] row : dp) {

                Arrays.fill(row, -1);
            }

            return solve3(prices, dp);
        }

         int solve3(int[] prices, int[][] dp) {

            
            for (int i = prices.length - 1; i >= 0; i--) {

                for (int buy = 0; buy < 2; buy++) {

                    if (i == prices.length - 1) {

                        dp[i][buy] = 0;
                        continue;
                    }

                    int profit = 0;

                    if (buy == 1) {

                        profit += Math.max((-prices[i] + dp[i + 1][0]), (dp[i + 1][1]));
                    }

                    else {

                        profit += Math.max((prices[i] + dp[i + 1][1]), (dp[i + 1][0]));
                    }

                    dp[i][buy] = profit;
                }
            }

            return dp[0][1];

        }

        public class stocks_part2_3 {
        
            // space optimized solution

            public int maxProfit4(int[] prices) {

                int[][] cur = new int[2][2];
                int[][] prev = new int[2][2];

                for (int[] row : cur) {

                    Arrays.fill(row, -1);
                }

                for (int[] row : prev) {

                    Arrays.fill(row, -1);
                }

                for (int i = prices.length - 1; i >= 0; i--) {

                    for (int buy = 0; buy < 2; buy++) {

                        if (i == prices.length - 1) {

                            cur[buy][0] = 0;
                            continue;
                        }

                        int profit = 0;

                        if (buy == 1) {

                            profit += Math.max((-prices[i] + prev[0][0]), (prev[1][0]));
                        }

                        else {

                            profit += Math.max((prices[i] + prev[1][0]), (prev[0][0]));
                        }

                        cur[buy][0] = profit;
                    }

                    prev = cur;
                    cur = new int[2][2];
                }

                return prev[1][0];

                
            }

             
        }
    }

    

    

    // tabulation





}
