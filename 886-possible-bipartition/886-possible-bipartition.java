class Solution {
    static boolean bfs(int i, int col[], ArrayList<ArrayList<Integer> >graph)
    {
        Queue<Integer> q = new LinkedList();
        q.add(i);
        col[i]=1;
        while(!q.isEmpty())
        {
            int node = q.remove();
            int currCol = col[node];
            // System.out.println("color of "+node+" is "+currCol);
            for(int j:graph.get(node))
            {
                if(col[j]==-1)
                {
                    if(currCol==1)
                    col[j]=0;
                    else
                    col[j]=1;
                    q.add(j);
                    // System.out.println("add j= "+j);
                }
                else if(col[j]==currCol)
                     return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dis) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList());
        for(int i=0;i<dis.length;i++)
        {
            int a = dis[i][0];
            int b = dis[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // for(int i=0;i<=n;i++)
        //     System.out.println(Arrays.toString(graph.get(i).toArray()));
        int[] col=new int[n+1];
        Arrays.fill(col,-1);
        for(int j=1;j<=n;j++)
        {
            if(col[j]==-1)
            {
                // System.out.println("col of "+j+" is -1");
                if(bfs(j,col,graph)==false)
                {
                    // System.out.println("false at j= "+j);
                    return false;
                }
                    
            }
        }
        return true;
        
    }
}