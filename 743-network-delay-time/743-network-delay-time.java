class Solution {
    
    static class node implements Comparable<node>{
        int val;
        int time;
        node(int val,int time)
        {
            this.val=val;
            this.time=time;
        }
        public int compareTo(node o)
        {
            return this.time - o.time;
        }
        
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int time[]= new int[n+1];
        Arrays.fill(time,100000);
        ArrayList<ArrayList<node>> graph = new ArrayList();
        PriorityQueue<node> pq= new PriorityQueue();
        for(int j=0;j<=n;j++)
            graph.add(new ArrayList());
        for(int i=0;i<times.length;i++)
        {
            graph.get(times[i][0]).add(new node(times[i][1],times[i][2]));
        }
        time[k]=0;
        pq.add(new node(k,0));
        while(!pq.isEmpty())
        {
            node temp = pq.remove();
            // System.out.println("val is "+temp.val+" time is "+temp.time);
            for(node x:graph.get(temp.val))
            {
                if(time[x.val]>temp.time+x.time)
                {
                    time[x.val]=temp.time+x.time;
                    // System.out.println("updating time of "+x.val+" and setting "+time[x.val]);
                    pq.add(new node(x.val,time[x.val]));
                }
            }
        }
        int ans=0;
        for(int c=1;c<=n;c++)
        {
            if(time[c]==100000)
                return -1;
            ans=Math.max(ans,time[c]);
        }
        return ans;
    }
}