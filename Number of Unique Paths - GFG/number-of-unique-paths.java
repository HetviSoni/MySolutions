//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    static int f(int i, int j, int a, int b, int dp[][])
    {
        if(i>=a || j>=b)
            return 0;
        if(i==a-1 && j==b-1)
            return 1;
        if(dp[i][j]!=-1)            
            return dp[i][j];
        int down = 0;
        if(i+1<a)
            down = f(i+1,j,a,b,dp);
        int left = 0;
        if(j+1<b)
            left = f(i,j+1,a,b,dp);
        return dp[i][j]= down+left;
    }
    public static int NumberOfPath(int a, int b) 
    {
        int dp[][] = new int[a][b];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(0,0,a,b,dp);
        //Your code here
    }
}