class Solution {
    static boolean check(int arr[], int days, int t)
    {
        int sum=0;int count=1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>t)
                return false;
            if(sum+arr[i]>t)
            {
                count++;
                sum=arr[i];
            }
            else
                sum+=arr[i];                        
        }
        if(count>days)
                return false;
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        for(int i=0;i<weights.length;i++)
            sum+=weights[i];
        int start=0;
        int end=sum;
        int ans=-1;
        while(start<=end)
        {
            int mid=start + (end - start) / 2;
            if(check(weights,days,mid))
            {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }
}









