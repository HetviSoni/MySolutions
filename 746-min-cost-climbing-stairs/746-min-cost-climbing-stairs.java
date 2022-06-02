class Solution {
    static int f(int i, int arr[],int[] dp)
    {
        if(i>=arr.length)
            return 1000000;
        if(i==arr.length-1 || i==arr.length-2)
            return arr[i];
        if(dp[i]!=-1)
            return dp[i];
        int one = arr[i]+f(i+1,arr,dp);
        int two = arr[i]+f(i+2,arr,dp);
        return dp[i]=Math.min(one,two);
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        int a=f(0,cost,dp);
        Arrays.fill(dp,-1);
        int b=f(1,cost,dp);
        return Math.min(a,b);
    }
}