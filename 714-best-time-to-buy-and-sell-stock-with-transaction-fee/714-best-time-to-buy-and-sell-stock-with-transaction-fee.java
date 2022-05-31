class Solution {
    static int pro(int[] arr, int buy, int i,int[][] dp, int fee)
    {
        if(i==arr.length)
            return 0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        int profit=0;
        if(buy==1)
        {
            profit=Math.max((arr[i]*(-1)+ pro(arr,0,i+1,dp,fee)),pro(arr,1,i+1,dp,fee));
        }
        else
            profit = Math.max((arr[i]-fee+pro(arr,1,i+1,dp,fee)),pro(arr,0,i+1,dp,fee));
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][]= new int[prices.length][2];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return pro(prices,1,0,dp,fee);
    }
}