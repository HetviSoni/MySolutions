class Solution {
    public int missingNumber(int[] nums) {
        int arr[]= new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            int a = nums[i];
            arr[a]=1;
        }
        for(int j=0;j<=nums.length;j++)
        {
            if(arr[j]==0)
                return j;
        }
        return nums.length-1;
        
    }
}