class Solution {
    static int f(int i, int j, int[]arr, int[][] dp)
    {
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int mini=10000000;
        for(int k=i;k<=j;k++)
        {
            int cost=arr[j+1]-arr[i-1]+f(i,k-1,arr,dp)+f(k+1,j,arr,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
        
    }
    public int minCost(int n, int[] cuts) {
        int neu[]= new int[cuts.length+2];
        neu[0]=0;
        neu[cuts.length+1]=n;
        for(int i=1;i<neu.length-1;i++)
            neu[i]=cuts[i-1];
        Arrays.sort(neu);
        int[][] dp=new int[neu.length][neu.length];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(1,neu.length-2,neu,dp);
        
    }
}