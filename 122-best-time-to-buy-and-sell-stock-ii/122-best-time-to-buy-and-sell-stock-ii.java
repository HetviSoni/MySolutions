class Solution {
    static int pro(int[] arr, int buy, int i,int[][] dp)
    {
        if(i==arr.length)
            return 0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        int profit=0;
        if(buy==1)
        {
            profit=Math.max((arr[i]*(-1)+ pro(arr,0,i+1,dp)),pro(arr,1,i+1,dp));
        }
        else
            profit = Math.max((arr[i]+pro(arr,1,i+1,dp)),pro(arr,0,i+1,dp));
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][]= new int[prices.length][2];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return pro(prices,1,0,dp);
    }
}