class Solution {
    static void bfs(int i, int[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList();
        q.add(i);
        vis[i]=1;
        while(!q.isEmpty())
        {
            int a = q.remove();
            for(int j=0;j<adj.get(a).size();j++)
            {
                if(vis[adj.get(a).get(j)]==0)
                {
                    vis[adj.get(a).get(j)]=1;
                    q.add(adj.get(a).get(j));
                }
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(n>connections.length+1)
            return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int j=0;j<n;j++)
            adj.add(new ArrayList());
        int[] vis=new int[n];
        for(int i=0;i<connections.length;i++)
        {
            int a=connections[i][0];
            int b=connections[i][1];
             // System.out.println(a);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        // for(int k=0;k<n;k++)
            // System.out.println(Arrays.toString(adj.get(k).toArray()));
            int count=0;
            for(int i=0;i<n;i++)
            {
                if(vis[i]==0)
                {
                    count++;
                    bfs(i,vis,adj);
                }
            }
        return count-1;
        
    }
        
    
}