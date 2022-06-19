class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // [2,6,4,8,10,9,15]
        //  2,4,6,8,9,10,15
        int arr[]= new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int s=0;
        int e=nums.length-1;
        while(s<nums.length)
        {
            if(nums[s]==arr[s])
                s++;
            else break;
        }
        while(e>=0)
        {
            if(nums[e]==arr[e])
                e--;
            else break;
        }
        if(s==nums.length)
            return 0;
        return e-s+1;
    }
}