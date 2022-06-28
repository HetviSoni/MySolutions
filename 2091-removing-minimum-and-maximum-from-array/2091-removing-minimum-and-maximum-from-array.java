class Solution {
    public int minimumDeletions(int[] nums) {
        int maxPosition = 0;
        int minPosition = 0;
        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                maxPosition=i;
            }
            if(nums[i]<min)
            {
                min=nums[i];
                minPosition = i;
            }
        }
        if(maxPosition==minPosition)
            return 1;
        int arr[]= new int[3];
        arr[0] = Math.max(maxPosition ,minPosition)+1;
        arr[1] = nums.length-Math.min(maxPosition ,minPosition);
        arr[2] = Math.min(maxPosition ,minPosition)+1 + (nums.length -Math.max(maxPosition ,minPosition));
        int ans=arr[0] ;
        if(arr[1]<ans)
            ans = arr[1]                                                ;
        if(arr[2]<ans)
            ans=arr[2];
        return ans;
        
                                                         
    }
}