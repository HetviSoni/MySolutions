class Solution {
    static int f(int prev, int i, int[] nums,int [][] dp)
    {
        if(i==nums.length)
            return 0;
        if(prev==-1)
            return Math.max(1+f(i,i+1,nums,dp),f(-1,i+1,nums,dp));
        else
        {
            if(dp[prev][i]!=-1)
                return dp[prev][i];
            int take=0,nt=0;
            if(nums[i]>nums[prev])
                take=1+f(i,i+1,nums,dp);
            return dp[prev][i]=Math.max(f(prev,i+1,nums,dp),take);
        }
        
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]= new int[nums.length][nums.length];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return f(-1,0,nums,dp);
    }
}