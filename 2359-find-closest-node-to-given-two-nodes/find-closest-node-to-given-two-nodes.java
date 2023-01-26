class Solution {
    static void dfs(ArrayList<ArrayList<Integer>> graph, int dis[], int vis[], int i)
    {
        vis[i]=1;
        if(graph.get(i).size()>0){
            if(vis[graph.get(i).get(0)]==0)
            {
                dis[graph.get(i).get(0)]=dis[i]+1;
                dfs(graph,dis,vis,graph.get(i).get(0));
            }
        // if(vis[graph.get(i).get(0)]==1)
        // {
        //     if(dis[graph.get(i).get(0)]>dis[i]+1)
        //         dis[graph.get(i).get(0)]=dis[i]+1;

        // }
        // else{
        //     dis[graph.get(i).get(0)]=dis[i]+1;
        // }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i=0;i<edges.length;i++)
        {
            graph.add(new ArrayList());
        }
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i]!=-1)
                graph.get(i).add(edges[i]);
        }
        int dis1[] = new int[edges.length];
        int dis2[] = new int[edges.length];
        int vis[]= new int[edges.length];
        Arrays.fill(dis1,100000);
        Arrays.fill(dis2,100000);
        dis1[node1]=0;
        dis2[node2]=0;
        dfs(graph,dis1,vis,node1);
        Arrays.fill(vis,0);
        dfs(graph,dis2,vis,node2);
        // System.out.println(Arrays.toString(dis1));
        // System.out.println(Arrays.toString(dis2));
        int min = 1000000;
        int index=-1;
        for(int i=0;i<edges.length;i++)
        {
            if(Math.max(dis1[i],dis2[i])<min)
            {
                min = Math.max(dis1[i],dis2[i]);
                System.out.println(min);
                index =i;
            }
        }
        if(min ==100000 )
            return -1;
        return index;
    }
}
