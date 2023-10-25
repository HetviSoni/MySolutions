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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int f(int cur, int i, int val[], int w[], int max, int dp[][])
    {
        if(i==val.length)
            return 0;
        if(dp[cur][i]!=-1)
            return dp[cur][i];
        int t=0;
        
        if(cur+w[i]<=max)
        {
            t=val[i]+f(cur+w[i],i,val,w,max,dp);
        }
        int nt=f(cur,i+1,val,w,max,dp);
        return  dp[cur][i]=Math.max(t,nt);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][]=new int[W+1000][val.length];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return f(0,0,val,wt,W,dp);
    }
}