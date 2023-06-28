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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    //
    static int f(int i, int cur, int target,int nums[], int dp[][])
    {
        // if(cur==target)
        //     return 1;
        if(i==nums.length){
            if(cur==target)
                return 1;
            return 0;
        }
      if(i>nums.length)
            return 0;
        if(dp[i][cur]!=-1)
            return dp[i][cur];
        long count=0;
        if(cur+nums[i]<=target)
            count+=f(i+1,cur+nums[i],target,nums,dp);
        count=count%1000000007;
        count+= f(i+1,cur,target,nums,dp);
        count=count%1000000007;
        return dp[i][cur]=(int)count;
        
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int dp[][]= new int[n][sum+1];
	    for(int row[]:dp)
	        Arrays.fill(row,-1);
	    return f(0,0,sum,arr,dp);
	    // Your code goes here
	} 
}