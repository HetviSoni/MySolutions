class Solution {
    static long index(int nums[], long[] sum, long t, int s)
    {
        int st = s;
        int end = nums.length-1;
        long ans=-1;
        while(st<=end)
        {
            int mid = (st+end)/2;
            long score = sum[mid]*(mid-s+1);
            if(s!=0)
                score = (sum[mid]-sum[s-1])*(mid-s+1);
            if(score<t)
            {
                ans =(long) mid;
                st=mid+1;
            }
            else
                end=mid-1;
            // System.out.println(mid);
        }
        return ans;
    }
    public long countSubarrays(int[] nums, long k) {
        long sum[]= new long[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum[i]=sum[i-1]+nums[i];
        }
        long result=0;
        for(int j=0;j<nums.length;j++)
        {
            long t = index(nums,sum,k,j);
            if(t==-1)
                continue;
            result=result+ index(nums,sum,k,j)-j+1;
        }
        return result;
    }
}