class Solution {
    static boolean containsCycle(int i, ArrayList<ArrayList<Integer>> graph, int vis[], int dfsvis[])
    {
        vis[i]=1;
        dfsvis[i]=1;
        for(int j:graph.get(i))
        {
            if(vis[j]==0)
            {
                if(containsCycle(j,graph,vis,dfsvis))                
                    return true;
            }
            else if (dfsvis[j]==1)
                return true;
        }
        dfsvis[i]=0;
        return false;
    }
    static void order(int i, ArrayList<ArrayList<Integer>> graph, Stack<Integer> s, int[] vis)
    {
        vis[i]=1;
        for(int j:graph.get(i))
        {
            if(vis[j]==0)
            {
                order(j,graph,s,vis);
            }
        }
        s.push(i);
    }
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int l=0;l<n;l++)
        {
            graph.add(new ArrayList());
        }
        for(int i=0;i<pre.length;i++)
        {
            int a=pre[i][0];
            int b=pre[i][1];
            graph.get(b).add(a);
        }
        int vis[]= new int[n];
        Stack<Integer> s = new Stack();
        
         int ans[]= new int[n];
        int dfsvis[]=new int[n];
        int c[]=new int[0];
        for(int w=0;w<n;w++)
        {
            if(vis[w]==0){
                if(containsCycle(w,graph,vis,dfsvis))
            return c;
            }
            
        }
        int newvis[]= new int[n];
        for(int k=0;k<n;k++)
        {
            if(newvis[k]==0)
                order(k,graph,s,newvis);            
        }       
        
        for(int x=0;x<n;x++)
        {
            ans[x]=s.pop();
        }
        return ans;
    }
}








