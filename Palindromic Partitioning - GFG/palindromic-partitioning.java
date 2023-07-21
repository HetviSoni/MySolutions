//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isP(int i, int j, String s)
    {
        int st = i;
        int e = j;
        while(st<=e)
        {
            if(s.charAt(st)!=s.charAt(e))
                return false;
            st++;
            e--;
        }
        return true;
    }
    static int f(int i, String s, int dp[])
    {
        if(i==s.length())
            return 0;
        int ans=9999;
        if(dp[i]!=-1)
            return dp[i];
        for(int j=i;j<s.length();j++)
        {
            if(isP(i,j,s))
            {
                int cur = 1+f(j+1,s,dp);
                ans=Math.min(ans,cur);
            }
        }
        return dp[i]=ans;
    }
    
    static int palindromicPartition(String s)
    {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return f(0,s,dp)-1;
        // code here
    }
}