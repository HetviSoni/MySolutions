class Solution {
    static int small(int arr[])
    {
        int ans=-1;
        int a=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
                return i;
        }
        return ans;
    }
    static int big(int arr[], int t)
    {
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]>t)
                return i;
        }
        return -1;
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void reverse(int arr[], int s, int e)
    {
        while(s<e)
        {
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums.length==1)
            return ;
        int index = small(nums);
        // System.out.println(index);
        if(index==-1)
        {
            reverse(nums,0,nums.length-1);
            return;
        }
        int big=big(nums,nums[index]);
        swap(nums,index,big);
        reverse(nums,index+1,nums.length-1);
        return;
    }
}