class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
                return i;
            if(i>0)
            {
                if(target<nums[i] && target>nums[i-1])
                    return i;
            }
            if(i==0 && target<nums[i])
                return 0;
        }
        return nums.length;
    }
}
