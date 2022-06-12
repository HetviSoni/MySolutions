class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0;
        int c=0;
        int s=0;
        int sum[]= new int[nums.length];
        sum[0]=nums[0];
        for(int j=1;j<sum.length;j++)
            sum[j]=sum[j-1]+nums[j];
        Map<Integer, Integer> map= new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],i);
                c=c+nums[i];
                // System.out.println(c);
                max=Math.max(max,c);
            }
            else
            {
                s=Math.max(s,map.get(nums[i])+1);
                // s=map.get(nums[i])+1;
                // System.out.println("at i= "+ i );
                c = sum[i]-sum[s-1];
                map.replace(nums[i],i);
                max=Math.max(c,max);
            }
        }
        return max;
    }
}