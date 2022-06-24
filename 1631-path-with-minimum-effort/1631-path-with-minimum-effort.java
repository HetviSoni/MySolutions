class Solution {
    static int me=100000000;
    static class node implements Comparable<node> 
    {
        int i;
        int j;
        int ht;
        node(int i, int j, int ht)
        {
            this.i=i;
            this.j=j;
            this.ht=ht;
        }
        public int compareTo(node o)   {
            return this.ht-o.ht;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int eff[][]= new int[m][n];
        for(int k[]:eff)
            Arrays.fill(k,me);
        PriorityQueue<node> pq = new PriorityQueue();
        // eff[0][0]=;
        pq.add(new node(0,0,0));
        while(!pq.isEmpty())
        {
            node temp = pq.remove();
            int i=temp.i;
            int j=temp.j;
            if(i==m-1 && j==n-1)
            {
                if(eff[i][j]>=me)
                    return 0;
                return eff[i][j];
            }
            if(i+1<m)
            {
                int newEff = Math.max(temp.ht,Math.abs(heights[i+1][j]-heights[i][j]));
                pq.add(new node(i+1,j,newEff));
                if(eff[i+1][j]>newEff)
                {
                    eff[i+1][j]=newEff;
                    // System.out.println("changing effort of "+i+1+" "+j+" to "+diff);
                    pq.add(new node(i+1,j,newEff));
                }
            }
            if(i-1>=0)
            {
                int newEff = Math.max(temp.ht,Math.abs(heights[i-1][j]-heights[i][j]));
               
                if(eff[i-1][j]>newEff)
                {
                    eff[i-1][j]=newEff;
                    pq.add(new node(i-1,j,newEff));
                }
            }
            if(j+1<n)
            {
                int diff = Math.abs(heights[i][j+1]-heights[i][j]);
                int newEff = Math.max(temp.ht,diff);
                if(eff[i][j+1]>newEff)
                {
                    eff[i][j+1]=newEff;
                     // System.out.println("changing effort of "+i+" "+j+1+" to "+diff);
                    pq.add(new node(i,j+1,newEff));
                }
            }
            if(j-1>=0)
            {
                int diff = Math.abs(heights[i][j-1]-heights[i][j]);
                int newEff = Math.max(temp.ht,diff);
                if(eff[i][j-1]>newEff)
                {
                    eff[i][j-1]=newEff;
                    pq.add(new node(i,j-1,newEff));
                }
            }
        }
        return -1;
    }
}