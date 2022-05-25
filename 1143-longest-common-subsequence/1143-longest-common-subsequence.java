class Solution {
    static int f(int i, int j, String s1, String s2, int [][] dp)
    {
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return 1+ f(i-1,j-1,s1,s2,dp);
        return dp[i][j]=Math.max(f(i-1,j,s1,s2,dp), f(i,j-1,s1,s2,dp));
        
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int dp[][]= new int[s1.length()][s2.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return f(s1.length()-1,s2.length()-1,s1,s2,dp);
    }
}