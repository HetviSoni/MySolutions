class Solution {
    public int firstMissingPositive(int[] nums) {
      Arrays.sort(nums)  ;
        int x=0;
        while(x<nums.length && nums[x]<=0)
        {
            x++;
        }
        int ans=1;
        for(int i=x;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            if(nums[i]==ans)
                ans++;
            else
                return ans;
        }
        return ans;
    }
}
// 3 4 -1 1
// -1 1 3 4