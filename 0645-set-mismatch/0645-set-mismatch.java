class Solution {
    public int[] findErrorNums(int[] nums) {
        int arr[]= new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]++;
        }
        int ans[]= new int[2];
        for(int i=1;i<=nums.length;i++)
        {
            if(arr[i]==0)
                ans[1]=i;
            if(arr[i]==2)
                ans[0]=i;
        }
        return ans;
    }
}

