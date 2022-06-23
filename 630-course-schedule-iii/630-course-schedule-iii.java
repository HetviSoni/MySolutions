class Solution {
    class pair implements Comparable<pair>{
        int dur;
        int ld;
        pair(int dur, int ld)
        {
            this.dur=dur;
            this.ld=ld;
        }
        public int compareTo(pair o)
        {
            return o.dur-this.dur;
        }
    }
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        // for(int i=0;i<courses.length;i++)
            // System.out.println(Arrays.toString(courses[i]));
        PriorityQueue<pair> pq = new PriorityQueue();
        int ans=0;
        int curDay=0;
        for(int i=0;i<courses.length;i++)
        {
            if(curDay+courses[i][0]<=courses[i][1])
            {
                ans++;
                curDay=curDay+courses[i][0];
                pq.add(new pair(courses[i][0],courses[i][1]));
            }
            else if(pq.size()>0)
            {
                int a = pq.peek().dur;
                if(curDay-a+courses[i][0]<curDay)
                {
                    pq.remove();
                    // ans++;
                    pq.add(new pair(courses[i][0],courses[i][1]));
                    curDay=curDay-a+courses[i][0];
                }
            }
        }
        
       
        return ans;
    }
    
}