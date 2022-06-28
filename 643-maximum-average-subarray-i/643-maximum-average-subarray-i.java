class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum[]= new long[nums.length];
        sum[0]=(long)nums[0];
        for(int i=1;i<nums.length;i++)
            sum[i]=sum[i-1]+nums[i];
        long ans=Integer.MIN_VALUE;
        // System.out.println(Arrays.toString(sum));
        for(int i=k-1;i<nums.length;i++)
        {
            long s=0;
            if(i-k<0)
                s=sum[i];
            else
                s = sum[i]-sum[i-k];
            // System.out.println(s);
            ans = Math.max(s,ans);
        }
        return (double)ans/(double)(k);
    }
}