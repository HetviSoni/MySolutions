//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int f(int i, int j, int arr[][], int dp[][])
    {
        if(i>=arr.length)
            return Integer.MIN_VALUE;
        if(i==arr.length-1)
            return arr[i][j];
        if(dp[i][j]!=-1) 
            return dp[i][j];
        int down = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE;
        int right  = Integer.MIN_VALUE;
        
        //down
        down = arr[i][j]+f(i+1,j,arr,dp);
        if(j-1>=0)
            left = arr[i][j] + f(i+1, j-1, arr,dp);
        if(j+1<arr[0].length)
            right = arr[i][j] +f(i+1, j+1, arr,dp);
            
        return dp[i][j]= Math.max(down, Math.max(left,right));
        
    }
    static int maximumPath(int N, int Matrix[][])
    {
       int ans = 0;
       int dp[][] = new int[N][N];
       for(int row[]:dp)
                Arrays.fill(row,-1);
       for(int i=0;i<Matrix[0].length;i++)
       {
           
           ans = Math.max(ans,f(0,i,Matrix,dp));
       }
       return ans;
        // code here
    }
}