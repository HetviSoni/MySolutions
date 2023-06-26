//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
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
    int findMaxSum(int arr[], int n) {
        // code here
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return f(arr,n,0,dp);
    }
}