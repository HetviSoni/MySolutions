class Solution {
    static int f(int prev,int i, int arr[], int dp[][])
    {
        if(i==arr.length)
        {
            return 0;
        }
        if(prev==-1)
            return Math.max(1+f(i,i+1,arr,dp),f(-1,i+1,arr,dp));
        if(dp[prev][i]!=-1)
            return dp[prev][i];
        int take=0;
        int nt= f(prev,i+1,arr,dp);
        if(arr[i] >arr[prev])
            take = 1+f(i,i+1,arr,dp);
        return dp[prev][i]=Math.max(take,nt);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]= new int[nums.length][nums.length];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp.length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return f(-1,0,nums,dp);
    }
}