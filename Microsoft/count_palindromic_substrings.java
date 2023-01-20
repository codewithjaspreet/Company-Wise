public class count_palindromic_substrings {

    // Count Palindromic Substrings brute force
    // O(n^3) time
    public int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                if (isPalindrome(s.substring(i, j))) {
                    count++;
                } else {
                    continue;
                }
            }
        }

        return count;
    }

    boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    // optimized O(n^2) time , gap method, tabulation

    public int countSubstrings2(String s) {

        int count = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

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
                    count++;
                }
            }
        }

        return count;
    }
}
