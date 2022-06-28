class Solution {
    public int[] getAverages(int[] nums, int k) {
        int res[]=new int[nums.length];
        long sum[]=new long[nums.length];
        sum[0]=(long)nums[0];
        for(int j=1;j<nums.length;j++)
            sum[j]=sum[j-1]+(long)nums[j];
        // System.out.println(Arrays.toString(sum));
        Arrays.fill(res,-1);
        for(int i=k;i<nums.length-k;i++)
        {
            long s = 0;
            if(i-k==0)
                s = sum[i+k];
            else
                s=sum[i+k]-sum[i-k-1];
            res[i]=(int)((s) /(2*k+1));
        }
        return res;
        
    }
}