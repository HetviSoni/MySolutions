//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int f(int i, int arr[], int k , int N, int dp[])
    {
        if(i>=N)
            return Integer.MAX_VALUE;
        if(i==N-1)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int minCost = 999999;
        for(int j=i+1;j<arr.length && j<=i+k;j++)
        {
            int cost = Math.abs(arr[i]-arr[j]) + f(j,arr,k,N, dp);
            minCost=Math.min(cost,minCost);
        }
        return dp[i]= minCost;
    }
    public int minimizeCost(int arr[],int N,int K){
        //code here
        int dp[] = new int[N+1];
        Arrays.fill(dp,-1);
        return f(0,arr,K,N,dp);
    }
}
