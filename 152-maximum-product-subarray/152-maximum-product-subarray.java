class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pro=1;
        for(int i=0;i<nums.length;i++)
        {
            pro=pro*nums[i];
            max = Math.max(pro,max);
            if(pro==0)
                pro=1;
        }
        pro=1;
        for(int j=nums.length-1;j>=0;j--)
        {
            pro=pro*nums[j];
            max=Math.max(pro,max);
            if(pro==0)
                pro=1;
        }
        return max;
    }
}