public class longest_repeating_subsequence {
    
    public int longestRepeatingSubsequence(String s) {
        
        int[][] dp = new int[s.length()+1][s.length()+1];
        
        for(int i = 1 ; i < dp.length ; i++){
            
            for(int j = 1 ; j < dp[0].length ; j++){
                
                if(s.charAt(i-1) == s.charAt(j-1) && i != j){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[s.length()][s.length()];
    }
    
    public static void main(String[] args) {
        
        longest_repeating_subsequence obj = new longest_repeating_subsequence();
        
        String s = "aabebcdd";
        
        System.out.println(obj.longestRepeatingSubsequence(s));
    }
}
