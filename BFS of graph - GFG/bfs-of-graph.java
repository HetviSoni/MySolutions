//{ Driver Code Starts
// Initial Template for Java
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
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // ArrayList<ArrayList<Integer>> graph = new ArrayList();
        // for(int i=0;i<V;i++)
        //     graph.add(new ArrayList());
        // for(int i=0;i<adj.size();i++)
        // {
        //     graph.get(adj.get(i).get(0)).add(adj.get(i).get(1));
        // }
        int vis[]= new int[V];
        Queue<Integer> q = new LinkedList();
        q.add(0);
        vis[0]=1;
        ArrayList<Integer> ans= new ArrayList();
        while(!q.isEmpty())
        {
            int a = q.remove();
            ans.add(a);
            for(int j:adj.get(a)){
                if(vis[j]==0)
                {
                    vis[j]=1;
                    q.add(j);
                }
            }
        }
        return ans;
    }
}