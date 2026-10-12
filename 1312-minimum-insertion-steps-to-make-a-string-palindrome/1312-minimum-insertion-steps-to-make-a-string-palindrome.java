class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        String str = new StringBuilder(s).reverse().toString();
        char s1[] = s.toCharArray();
        char s2[] = str.toCharArray();

        int dp[][] = new int[n + 1][n + 1];

        // logic : find longest palindromic substring and then minus it from the original length of string.
        for(int i[] : dp) Arrays.fill(i, -1);

        return n - memo(dp, s1, s2, n - 1, n - 1);
    }
    public int memo(int dp[][], char s1[], char s2[], int n, int m){
        if(n < 0 || m < 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];

        int max = 0;
        if(s1[n] == s2[m]){
            dp[n][m] = 1 + memo(dp, s1, s2, n - 1, m - 1);
        }
        else{
            max = Math.max(memo(dp, s1, s2, n - 1, m), memo(dp, s1, s2, n, m - 1));
            dp[n][m] = Math.max(max, dp[n][m]);
        }
        return dp[n][m];
    }
}