class Solution {
    public int removeElement(int[] nums, int val) {
        int c = -1;
        for(int i=0;i<nums.length && c+1<nums.length;i++)
        {
            if(nums[i]!=val)
            {
                //swap c+1 and i
                int temp = nums[c+1];
                nums[c+1]=nums[i];
                nums[i]=temp;
                c++;
            }
        }
        return c+1;
    }
}