public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] nums) {
        
        int[][] dp = new int[nums.length][nums.length + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return util(0, -1, nums, dp);
        
        
    }
    
   
        int util(int ind, int prev, int[] nums, int[][] dp) {

        if (ind == nums.length)
            return 0;

        if (dp[ind][prev + 1] != -1)
            return dp[ind][prev + 1];

        int notTake = 0 + util(ind + 1, prev, nums, dp);

        int take = -1;

        if (prev == -1 || nums[ind] > nums[prev]) {

            take = 1 + util(ind + 1, ind, nums, dp);
        }

        return dp[ind][prev + 1] = Math.max(take, notTake);

    }
}
