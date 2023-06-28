//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    static int h(int i,int req, int arr[], int dp[][])
    {
        if(i>=arr.length)
            return 0;
        if(dp[i][req]!=-1)
            return dp[i][req];
        //pick
        int pick = -9999;
        if(i+1<=req)
            pick = arr[i] + h(i,req-i-1,arr,dp);
        int up = h(i+1,req,arr,dp);
        
        return dp[i][req]= Math.max(pick,up);
}
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]= new int[n+1][n+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return h(0,n,price,dp);
    }
}