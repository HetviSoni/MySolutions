class Solution {
    public int longestConsecutive(int[] nums) {
        
        // 1 2 3 4 100 200
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        int cur=1;
        Arrays.sort(nums);
        int max=0;
        int s = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            //0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 10
            if(nums[i]==nums[i-1] && i+1<nums.length )
                continue;
            else if(nums[i]==nums[i-1]+1)
            {
                cur++;
            }
            else
                cur=1;
            max=Math.max(max,cur);
        }
        return max;
    }
}