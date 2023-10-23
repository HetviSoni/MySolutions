//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends




//User function Template for Java

class Solution
{
    static int f(int i, int prev, int arr[], int dp[][])
    {
        if(i==arr.length)
            return 0;
        
        if(prev!=-1)
        {
            if(dp[i][prev]!=-1)
                return dp[i][prev];
            int t = 0;
            if(arr[prev]<arr[i])
                t=arr[i]+f(i+1,i,arr,dp);
            int nt = f(i+1,prev,arr,dp);
            return dp[i][prev]= Math.max(t,nt);
        }
        int t=arr[i]+f(i+1,i,arr,dp);
        int nt=f(i+1,prev,arr,dp);
        return Math.max(t,nt);
        
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    int dp[][]=new int[n][n];
	    for(int row[]:dp)
	        Arrays.fill(row,-1);
	    return f(0,-1,arr,dp);
	    //code here.
	}  
}