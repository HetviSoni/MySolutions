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
    static boolean dfsCycle(int i, int prev,ArrayList<ArrayList<Integer>> graph, int vis[] )
    {
        vis[i]=1;
        for(int j:graph.get(i))
        {
            if(vis[j]==0)
            {
                if(dfsCycle(j,i,graph,vis))
                    return true;
            }
            else if(j!=prev)
                return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[]= new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(dfsCycle(i,-1,adj,vis))
                    return true;
            }
        }
        return false;
    }
}