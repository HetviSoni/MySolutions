class Solution {
    static class pair implements Comparable<pair>{
        int val;
        int freq;
        pair(int val, int freq)
        {
            this.val=val;
            this.freq=freq;
        }
        public int compareTo(pair o){
            return o.freq-this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                map.replace(nums[i],map.get(nums[i])+1);
        }
         // for(Map.Entry m : map.entrySet()){    
         //    System.out.println(m.getKey()+" "+m.getValue());    
         //   }  
        PriorityQueue<pair> pq = new PriorityQueue();
         for(Map.Entry<Integer,Integer> m : map.entrySet())
         { 
             
                 pq.add(new pair(m.getKey(),m.getValue()));
               
           }  
        int ans[]=new int[k];
        for(int j=0;j<k;j++)
        {
            ans[j]=pq.remove().val;
        }
        return ans;
    }
}