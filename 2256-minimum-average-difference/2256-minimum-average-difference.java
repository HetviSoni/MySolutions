class Solution {
    public int minimumAverageDifference(int[] nums) {
            // 2  5  3  9  5  3
            // 2  7  10 19 24 27    tot 27
            // |2/1-(27-2)/(6-1)| = 3;
            long sum[]= new long[Math.toIntExact((long) nums.length)];
            sum[0]=(long)nums[0];
            for(int i=1;i<nums.length;i++)
            {
                sum[i]=(long)nums[i]+sum[i-1];
            }
            long total = sum[nums.length-1];
            long min = 10000000;
            int index=0;
            for(long i=0;i<(long)nums.length-1;i++)
            {
                long dif =(long) Math.abs(sum[(int) i]/(long)(i+1)- (total-sum[(int) i])/(long)(nums.length-i-1) );
                if(dif<min)
                {
                    min=dif;
                    index=(int)i;
                }
                // min = Math.min(min,dif);
            }
            long a = sum[nums.length-1]/nums.length;
            if(a<min)
                return nums.length-1;
            return index;
        }
}