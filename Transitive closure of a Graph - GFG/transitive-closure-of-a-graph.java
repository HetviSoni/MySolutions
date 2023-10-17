//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        //
        // int ans[][]=new int[N][N];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[0].length;j++)
            {
                if(graph[i][j]==0)
                {
                    graph[i][j]=999999;
                }
                if(i==j)
                    graph[i][j]=0;
            }
        }
        for(int k=0;k<N;k++)
        {
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(graph[i][j]>graph[i][k]+graph[k][j])
                    {
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList();
        for(int i=0;i<N;i++)
        {
            ArrayList<Integer> cur=new ArrayList();
            for(int j=0;j<N;j++)
            {
                if(graph[i][j]==999999)
                    cur.add(0);
                else
                    cur.add(1);
            }
            ans.add(cur);
        }
        return ans;
    }
}