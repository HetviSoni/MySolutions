class Solution {
    static int lcs(String s,String t, int i , int j,int[][] dp)
    {
        if(i<0 )
            return j+1;
        if(j<0 )
            return i+1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return lcs(s,t,i-1,j-1,dp);
        int a = 1+lcs(s,t,i-1,j,dp);
        int b = 1+lcs(s,t,i,j-1,dp);
        int c = 1+ lcs(s,t,i-1,j-1,dp);
        return dp[i][j]=Math.min(a,Math.min(b,c));
    }
    public int minDistance(String s, String t) {
        int dp[][]= new int[s.length()][t.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return lcs(s,t,s.length()-1,t.length()-1,dp);
    }
}