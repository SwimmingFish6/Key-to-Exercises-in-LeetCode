class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length() + 1, pLength = p.length() + 1;
        boolean[][] dp = new boolean[sLength][pLength];
        dp[0][0] = true;

        for (int i = 1;i <= s.length();i++) {
            dp[i][0] = false;
        }

        for (int j = 1;j <= p.length();j++) {
            dp[0][j] = j > 1 && dp[0][j - 2] && p.charAt(j - 1) == '*';
        }

        for (int i = 1;i <= s.length();i++) {
            for (int j = 1;j <= p.length();j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
                else {
                    dp[i][j] = (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) || dp[i][j - 2];
                }
            }
        }



        return dp[sLength - 1][pLength - 1];
    }
}