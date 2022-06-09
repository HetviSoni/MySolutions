class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        if(nums.length<2)
            return ans;
        int a = nums[0];
        int b = nums[1];
        // int t = target-a-b;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int t = target-nums[i] - nums[j];
                int s = j+1;
                int e = nums.length-1;
                while(s<e)
                {
                    if(nums[s]+nums[e]>t)
                    {
                        e--;
                    }
                    else if(nums[s]+nums[e]<t)
                    {
                        s++;
                    }
                    else
                    {
                        List<Integer> temp = new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[s]);
                        temp.add(nums[e]);
                        ans.add(temp);
                        while(s<e && nums[s]==temp.get(2))
                            ++s;
                        while(s<e && nums[e]==temp.get(3))
                            --e;
                        
                    }
                }
                while(j+1<nums.length && nums[j+1]==nums[j] )
                        ++j;
            }
            while(i+1<nums.length && nums[i+1]==nums[i])
                    ++i;
            
        }
        return ans;
    }
}