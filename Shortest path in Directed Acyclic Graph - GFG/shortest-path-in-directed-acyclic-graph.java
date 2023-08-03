//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static class pair implements Comparable<pair>{
        int node;
        int dis;
        pair(int node, int dis)
        {
            this.node=node;
            this.dis=dis;
        }
        public int compareTo(pair o)
        {
            return this.dis-o.dis;
        }
    }
	public int[] shortestPath(int n,int m, int[][] edges) {
	    int dis[]=new int[n];
	    Arrays.fill(dis,99999);
	    ArrayList<ArrayList<pair>> graph=new ArrayList();
	    for(int i=0;i<n;i++)
	    {
	        graph.add(new ArrayList());
	    }
	    for(int i=0;i<m;i++)
	    {
	        int a=edges[i][0];
	        int b=edges[i][1];
	        int c=edges[i][2];
	        graph.get(a).add(new pair(b,c));
	    }
	    dis[0]=0;
	    PriorityQueue<pair> q=new PriorityQueue();
	    q.add(new pair(0,0));
	    while(!q.isEmpty())
	    {
	        pair temp=q.remove();
	        int curdis=temp.dis;
	        for(pair p:graph.get(temp.node))
	        {
	            if(curdis+p.dis<dis[p.node])
	            {
	                dis[p.node]=curdis+p.dis;
	                q.add(new pair(p.node,dis[p.node]));
	            }
	        }
	    }
	    for(int i=0;i<n;i++)
	    {
	        if(dis[i]==99999)
	            dis[i]=-1;
	    }
	    return dis;
	}
}











