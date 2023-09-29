//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static void f(int i, int j, int arr[][])
    {
        arr[i][j]=0;
        //right
        if(j+1<arr[0].length && arr[i][j+1]==1)
        {
            f(i,j+1,arr);
        }
        //down
        if(i+1<arr.length && arr[i+1][j]==1)
        {
            f(i+1,j,arr);
        }
        //left
        if(j-1>=0 && arr[i][j-1]==1)
        {
            f(i,j-1,arr);
        }
        //up
        if(i-1>=0 && arr[i-1][j]==1)
        {
            f(i-1,j,arr);
        }
    }
    int numberOfEnclaves(int[][] arr) {

        // Your code here
        int grid[][]=new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                grid[i][j]=arr[i][j];
            }
        }
        for(int i=0;i<grid[0].length;i++)
        {
            if(grid[0][i]==1)
                f(0,i,grid);
            if(grid[grid.length-1][i]==1)
                f(grid.length-1,i,grid);
        }
        // System.out.println("here");
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==1)
                f(i,0,grid);
            if(grid[i][grid[0].length-1]==1)
                f(i,grid[0].length-1,grid);
        }
        int ans =0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    ans++;
            }
        }
        return ans;
    }
}








