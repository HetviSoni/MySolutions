//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void bfs(ArrayList<ArrayList<Integer>> graph, int i, boolean vis[])
    {
        Queue<Integer> q = new LinkedList();
        q.add(i);
        vis[i]=true;
        while(!q.isEmpty())
        {
            int a = q.remove();
            
            for(int j:graph.get(a))
            {
                if(!vis[j])
                {
                    vis[j]=true;
                  q.add(j);   
                }
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int ans=0;
        boolean vis[]= new boolean[V];
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i=0;i<V;i++)
            graph.add(new ArrayList());
            
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(adj.get(i).get(j)==1 && i!=j)
                {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        // for(int i=0;i<graph.length;i++)
        // {
            
        // }
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
              {  bfs(graph,i,vis);
                  ans++;
              }
        }
        return ans;
    }
};