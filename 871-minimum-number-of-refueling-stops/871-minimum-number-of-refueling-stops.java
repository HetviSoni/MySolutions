class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int cur=0;
        int fuel=startFuel;
        int c=0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
       int ans=0;
        if(startFuel>=target)
            return 0;
        while(cur<=target)
        {
            cur+=fuel;
            if(cur>=target)
                return ans;
            int temp = c;
            for(int j=c; j<stations.length && stations[j][0]<=cur ;j++)
            {
                pq.add(stations[j][1]);
                temp++;
            }
            c=temp;
            if(pq.size()<=0)
                return -1;
            fuel=pq.poll();
            ans++;
        }
        return ans;
    }
}