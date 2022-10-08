class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int dif=Integer.MAX_VALUE;
        int ans=dif;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            int left = i+1;
            int right = nums.length-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-sum)<dif)
                {
                    dif = Math.min(dif,Math.abs(target-sum));
                    ans = sum;
                }
                if(sum>target)
                    right--;
                else
                    left++;
            }
        }
        return ans;
    }
}