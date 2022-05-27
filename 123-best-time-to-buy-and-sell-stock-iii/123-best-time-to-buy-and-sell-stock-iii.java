class Solution {
    static int f(int i,int buy, int t, int[] arr, int[][][] dp)
    {
        if(t==0)
            return 0;
        if(i==arr.length)
            return 0;
        if(dp[i][buy][t]!=-1)
            return dp[i][buy][t];
        int profit=0;
        if(buy==1)
        {
            int b= -arr[i]+f(i+1,0,t,arr,dp);
            int nb=f(i+1,1,t,arr,dp);
            profit=Math.max(b,nb);
        }
        else
        {
            int s=arr[i]+f(i+1,1,t-1,arr,dp);
            int ns=f(i+1,0,t,arr,dp);
            profit=Math.max(s,ns);
        }
        return dp[i][buy][t]=profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][][]= new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<3;k++)
                    dp[i][j][k]=-1;
            }
        }
        return f(0,1, 2,prices, dp);
    }
}