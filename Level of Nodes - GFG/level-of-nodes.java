//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    static class pair{
        int val;
        int dis;
        pair(int val,int dis)
        {
            this.val=val;
            this.dis=dis;
        }
    }
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        Queue<pair> q=new LinkedList();
        q.add(new pair(0,0));
        int vis[]=new int[V];
        
        while(!q.isEmpty())
        {
            pair cur=q.remove();
            vis[cur.val]=1;
            if(cur.val==X)
                return cur.dis;
            for(int j:adj.get(cur.val))
            {
                if(vis[j]==0)
                q.add(new pair(j,cur.dis+1));
            }
        }
        return -1;
    }
}