import java.util.Arrays;


// memoized  - 3D DP PROBLEM

// AT MOST 2 TRANSACTIONS
/**
 * stocks_part3
 */
public class stocks_part3 {

    static int maxProfit(int K, int N, int A[]) {
        // code here

        int[][][] dp = new int[3][N + 1][K + 1];

        for (int[][] row : dp) {

            for (int[] it : row) {

                Arrays.fill(it, -1);
            }
        }

        return solve(A, 0, 1, N, K, dp);
    }

    static int solve(int[] A, int index, int buy, int n, int k, int[][][] dp) {

        if (k == 0)
            return 0;
        if (index == A.length)
            return 0;

        if (dp[buy][index][k] != -1)
            return dp[buy][index][k];

        int profit = 0;

        if (buy == 1) {

            int buyKaro = -A[index] + solve(A, index + 1, 0, n, k, dp);
            int skipKaro = 0 + solve(A, index + 1, 1, n, k, dp);

            profit = Math.max(buyKaro, skipKaro);
        }

        else {

            int sellKaro = A[index] + solve(A, index + 1, 1, n, k - 1, dp);
            int skipKaro = 0 + solve(A, index + 1, 0, n, k, dp);

            profit = Math.max(sellKaro, skipKaro);
        }

        return dp[buy][index][k] = profit;

    }

}