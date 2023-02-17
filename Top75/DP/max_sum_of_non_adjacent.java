package Top75.DP;
import java.util.Arrays;

// memoization soln

class Solution

{

    public int FindMaxSum(int arr[], int n)
    
    {
        
        
        int[] dp = new int[n+1];
        
        Arrays.fill(dp , -1);
        
        int ans = solve(arr , n-1 , dp);

        
        return ans;
        
    }
    
    static int solve(int[] nums , int n , int[] dp){
        
        
        if(n < 0) return 0;
        
        if(n == 0) return nums[0];
        
        if(dp[n] != -1) return dp[n];
        
        int incl = solve(nums , n-2,dp) + nums[n];
        int exl = solve(nums , n-1,dp) + 0;
        
        return dp[n] = Math.max(incl , exl);
    }

        // Function to find the maximum money the thief can get.
        public int tabulation(int arr[], int n) {
            int dp[] = new int[n + 1];
            dp[0] = 0;
            dp[1] = Math.max(dp[0], arr[0]);
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], arr[i - 1] + dp[i - 2]);
            }
            return dp[n];
    }
}