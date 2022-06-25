class Solution {
    public int maximumXOR(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++)
        {   xor|=nums[i];
            // System.out.println(xor);
        }
        return xor;
    }
}