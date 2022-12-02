//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    static class pair{
        int cur;
        int prev;
        pair(int cur, int prev)
        {
            this.cur=cur;
            this.prev=prev;
        }
    }
    static boolean cycle(int i, ArrayList<ArrayList<Integer>> graph,int vis[])
    {
        Queue<pair> q= new LinkedList();
        vis[i]=1;
        q.add(new pair(i,-1));
        while(!q.isEmpty())
        {
            pair p = q.remove();
            int cur = p.cur;
            int prev = p.prev;
            for(int j:graph.get(cur))
            {
                if(vis[j]==0)
                {
                    vis[j]=1;
                    q.add(new pair(j,cur));
                }
                else if(prev!=j)
                    return true;
                
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[]= new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {if(cycle(i,adj,vis))
                return true;}
        }
        return false;
    }
}