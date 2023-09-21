//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends




class Solution
{
    //Function to find the maximum money the thief can get.
    int f(int arr[], int n,int i, int dp[])
    {
        if(i>=n)
            return 0;
        if(i==n-1)
            return arr[i];
        if(dp[i]!=-1)
            return dp[i];
        int take = arr[i] + f(arr,n,i+2,dp);
        int nt = f(arr,n,i+1,dp);
        return dp[i]= Math.max(take,nt);
    }
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
         int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return f(arr,n,0,dp);
    }
}