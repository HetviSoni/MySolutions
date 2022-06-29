class Solution {
    static boolean f(int i, int nums[], int dp[], int[] vis)
    {
        if(i<0 || i>=nums.length)
            return false;
        if(nums[i]==0)
            return true;
        if(vis[i]==1)
            return false;
        vis[i]=1;
        if(dp[i]!=-1)
        {
            if(dp[i]==1)
                return true;
            return false;
        }
        
        boolean back = f(i-nums[i],nums,dp,vis);
        boolean front = f(i+nums[i],nums,dp,vis);
        if(back|front)
            dp[i]=1;
        else
            dp[i]=0;
        return  back|front;
    }
        
    public boolean canReach(int[] arr, int start) {
        int dp[]= new int[arr.length];
        Arrays.fill(dp,-1);
        int vis[]=new int[arr.length];
        Arrays.fill(vis,-1);
        return f(start,arr,dp,vis);
    }
}