class Solution {
    static int lcs(String a, String b, int i, int j,int[][] dp)
    {
        if(i<0 ||j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
            return 1+lcs(a,b,i-1,j-1,dp);
        else
            return dp[i][j]=Math.max(lcs(a,b,i-1,j,dp),lcs(a,b,i,j-1,dp));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m = word2.length();
        int [][] dp = new int[n][m];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return n+m-2*lcs(word1,word2,n-1,m-1,dp);
    }
}