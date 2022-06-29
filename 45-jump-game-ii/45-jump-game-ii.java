class Solution {
    static int f(int i, int[] nums, int[] dp)
    {
        if(i==nums.length-1)
            return 0;
        if(i>=nums.length)
            return 1000000000;
        if(dp[i]!=-1)
            return dp[i];
        int a = nums[i];
        int min = 100000000;
        for(int j = i+1;j<=Math.min(nums.length-1,i+a);j++)
        {
            int st = 1+f(j,nums,dp);
            min = Math.min(min,st);
        }
        return dp[i]=min;
    }
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return f(0,nums,dp);
    }
}