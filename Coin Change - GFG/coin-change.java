//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    static long f(int i, int tar, int arr[], int cur,long dp[][])
    {
        if(i==arr.length)
        {
            if(tar==cur)
                return 1;
            return 0;
        }
        if(dp[i][cur]!=-1)
            return dp[i][cur];
        //pick
        long pick=0;
        if(cur+arr[i]<=tar)
        {
            pick= f(i,tar,arr,cur+arr[i],dp);
        }
        long np=f(i+1,tar,arr,cur,dp);
        return dp[i][cur]= pick +np;
    }
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][]=new long[coins.length][sum+1];
        for(long row[]:dp)
            Arrays.fill(row,-1);
        return f(0,sum,coins,0,dp);
    }
}