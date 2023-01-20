public class longest_length_palindromic_String {

    public int countSubstrings2(String s) {

        int count = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

        int len = 0;

        for (int g = 0; g < s.length(); g++) {

            for (int i = 0, j = g; j < s.length(); i++, j++) {

                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    len = g+1;
                }
            }
        }

        return len;
    }
    
}
