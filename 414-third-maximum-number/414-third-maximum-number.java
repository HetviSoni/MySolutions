class Solution {
    public int thirdMax(int[] nums) {
       HashSet<Integer> hs = new HashSet();
        for(int i=0;i<nums.length;i++)
            hs.add(nums[i]);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(Integer a:hs)
        {
            pq.add(a);
        }
       
        if(pq.size()<3)
        {
            return pq.peek();
        }
        else
        {
            int o=pq.remove();
            int t=pq.remove();
             
        }
        return pq.peek();
    }
}