class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int avg = nums[nums.length/2];
        int ans = 0;
        for(int j=0;j<nums.length;j++)
            ans+=Math.abs(avg-nums[j]);
        return ans;
    }
    
}

