class Solution {
    static int f(int n, int dp[])
    {
        if(dp[n]!=-1)
            return dp[n];
        if(n==2 || n==1)
            return dp[n]=1;
        if(n==0)
            return dp[n]=0;
        else
            return dp[n]=f(n-3,dp)+f(n-1,dp)+f(n-2,dp);

    }
    public int tribonacci(int n) {
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
}
