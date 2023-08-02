//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class pair {
        int i;
        int j;
        int dis;
        pair(int i, int j, int dis)
        {
            this.i=i;
            this.j=j;
            this.dis=dis;
        }
        
    }
    
    int shortestDistance(int n, int m, int arr[][], int x, int y) {
        // code here
        int dis[][]= new int[n][m];
        for(int row[]:dis)
        {
            Arrays.fill(row,99999);
        }
        dis[0][0]=0;
        if(arr[0][0]==0)
            return -1;
        Queue<pair> q= new LinkedList();
        q.add(new pair(0,0,0));
        int moves[][]={{1,0},{-1,0},{0,-1},{0,1}};
        while(!q.isEmpty())
        {
            pair temp= q.remove();
            int curx=temp.i;
            int cury=temp.j;
            int curdis=temp.dis;
            for(int i=0;i<4;i++)
            {
                int newx=curx+moves[i][0];
                int newy=cury+moves[i][1];
                if(newx>=0 && newx<arr.length && newy>=0 && newy<arr[0].length && arr[newx][newy]==1)
                {
                    if(dis[newx][newy]>curdis+1)
                    {
                        dis[newx][newy]=curdis+1;
                        q.add(new pair(newx,newy,curdis+1));
                    }
                }
            }
            
        }
        // for(int row[]:dis)
        //     System.out.println(Arrays.toString(row));
        if(dis[x][y]==99999)
            return -1;
        return dis[x][y];
    }
};









