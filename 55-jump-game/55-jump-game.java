class Solution {
    static boolean f(int i, int[] nums, int dp[])
    {
        if(i==nums.length-1)
            return true;
        if(i>=nums.length)
            return false;
        if(dp[i]!=-1)
        {
            if(dp[i]==0)
                return false;
            return true;
        }
        int a = nums[i];
        boolean ans = false;
        for(int j = i+1;j<=Math.min(nums.length-1,i+a);j++)
        {
            ans = ans | f(j,nums,dp);
            if(ans==true)
                dp[j]=1;
            else
                dp[j]=0;
        }
        if(ans==true)
            dp[i]=1;
        else
            dp[i]=0;
        return  ans;
    }
    public boolean canJump(int[] nums) {
        int dp[]= new int[nums.length];
        Arrays.fill(dp,-1);
        return f(0,nums,dp);
    }
}