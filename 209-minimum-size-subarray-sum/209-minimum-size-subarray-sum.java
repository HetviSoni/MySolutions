class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int cur =0;
        int p=0;
        int q=0;
        int ans = Integer.MAX_VALUE;
        while(q<nums.length && p<nums.length)
        {
             cur+=nums[q];  
            // System.out.println("p is "+p+" q is "+q);
            // System.out.println(cur);
            while(cur>=target)
            {
                ans = Math.min(q-p+1,ans);
                cur-=nums[p];
                p++;
            
             }
                     
            q++;
            
        }
        if(ans>2147483645)
            return 0;
        return ans;
    }
}
// 2 3 1 2 4 3
// 2 5 6 8 12 15
