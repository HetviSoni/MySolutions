class Solution {
    static int lcs(String s,String t, int i , int j,int[][] dp)
    {
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return 1+lcs(s,t,i-1,j-1,dp);
        return dp[i][j]=Math.max(lcs(s,t,i-1,j,dp),lcs(s,t,i,j-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        String t="";
        for(int i=s.length()-1;i>=0;i--)
        {
            t+=s.charAt(i);
        }
        int dp[][]= new int[s.length()][s.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return lcs(s,t,s.length()-1,s.length()-1,dp);
    }
    
}