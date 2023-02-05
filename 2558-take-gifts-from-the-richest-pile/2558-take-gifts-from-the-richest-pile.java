class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<gifts.length;i++)
        {
            pq.add(gifts[i]);
        }
        for(int i=0;i<k;i++)
        {
            int a = pq.remove();
            int b =(int) Math.floor(Math.sqrt(a));
            pq.add(b);
        }
        Iterator value = pq.iterator();
        long ans=0;
        while (value.hasNext()) {
            ans+=(int)value.next();
        }
        // for(int i=0;i<arr.length;i++)
        // {
        //     ans+=arr[i];
        // }
        return ans;
    }
}
