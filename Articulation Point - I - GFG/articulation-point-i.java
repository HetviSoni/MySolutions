//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    static int timer = 1;
    static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> graph,
    int vis[], int low[], int mark[],int tin[])
    {
        vis[node]=1;
        tin[node]= timer;
        low[node]=timer;
        timer++;
        int child=0;
        for(int i:graph.get(node))
        {
            if(i==parent)
                continue;
            if(vis[i]==0)
            {
                dfs(i,node,graph,vis,low,mark,tin);
                low[node]= Math.min(low[node],low[i]);
                if(low[i]>=tin[node] && parent!=-1)
                    mark[node]=1;
                child++;
            }
            else{
                low[node]=Math.min(low[node],tin[i]);
            }
        }
        if(child>1 && parent==-1)
                mark[node]=1;
        
    }
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int vis[]= new int[n];
        int tin[]= new int[n];
        int low[]= new int[n];
        int mark[]= new int[n];
        ArrayList<Integer> ap = new ArrayList();
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                dfs(i, -1, adj,vis, low, mark,tin);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(mark[i]==1)
                ap.add(i);
        }
        if(ap.size()==0)
            ap.add(-1);
        Collections.sort(ap);
        return ap;
    }
}