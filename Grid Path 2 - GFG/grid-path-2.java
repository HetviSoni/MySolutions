//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int f(int i, int j, int arr[][], int dp[][])
    {
        if(i>=arr.length || j>=arr[0].length)
            return 0;
        if(arr[i][j]==1)
            return 0;
        if(i==arr.length-1 && j==arr[0].length-1)
            return 1;
        
        if(dp[i][j]!=-1)            
            return dp[i][j];
        long down = 0;
        if(i+1<arr.length)
            down = f(i+1,j,arr,dp);
        long left = 0;
        if(j+1<arr[0].length)
            left = f(i,j+1,arr,dp);
        down =(int) down%1000000007;
        left = (int) left%1000000007;
        return dp[i][j]=(int) (down+left);
    }
    public int totalWays(int N, int M, int grid[][]) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(0,0,grid,dp);
        // Code here
    }
}