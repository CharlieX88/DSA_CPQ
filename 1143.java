class Solution {
    int [][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
        for(int [] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(text1, text2, n-1, m-1);
    }
    int helper(String t1, String t2, int i, int j){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = 1+helper(t1,t2,i-1,j-1);
        }
        return dp[i][j]=Math.max(
            helper(t1,t2,i-1,j),
            helper(t1,t2,i,j-1)
        );
    }
}