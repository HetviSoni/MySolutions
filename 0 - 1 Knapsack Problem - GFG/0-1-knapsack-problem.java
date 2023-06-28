//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int h(int i , int cur, int target, int val[], int w[], int[][] dp)
    {
        if(i==w.length-1)
        {
            if(w[i]+cur<=target)
                return val[i];
            return 0;
        }
        if(dp[i][cur]!=-1)
            return dp[i][cur];
        int pick  = Integer.MIN_VALUE;
        if(w[i]+cur<=target)
            pick = val[i] + h(i+1,w[i]+cur,target,val,w,dp);
        int np = h(i+1,cur,target,val,w,dp);
        return dp[i][cur]= Math.max(pick,np);
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][] = new int[val.length][W+1];
         for(int row[]:dp)
            Arrays.fill(row,-1);
         return h(0,0,W,val,wt,dp);
    } 
}


