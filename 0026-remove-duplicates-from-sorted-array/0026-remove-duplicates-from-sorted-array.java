class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if(l==1)
            return 1;
        int i=0, j=1;
        while(j<l)
        {
            if(nums[j]>nums[i] && j==i+1)
            {
                i++;
                j++;
            }
            else if(nums[j]>nums[i] && j!=i+1)
            {
                int t = nums[i+1];
                nums[i+1]=nums[j];
                nums[j]=t;
                i++;
                j++;
            }
            else
                {j++;}
        }
        int k=1;
        for(int p=1;p<=l;p++)
        {
            if(p==l)
                return l;
            if(nums[p]<=nums[p-1])
            {
                k=p;
                break;
            }
        }
        return k;
        
    }
}