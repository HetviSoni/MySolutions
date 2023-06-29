//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    static int f(int i, int j,String s, String t , int dp[][])
    {
        if(i>=s.length())
            return t.length()-j;
            
        if(j>=t.length())
            return s.length()-i;
            
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return dp[i][j]= f(i+1,j+1,s,t,dp);
        //insert
        // acs dfc
        int ins = 1+f(i,j+1,s,t,dp);
        //del
        int del = 1+f(i+1,j,s,t,dp);
        //repl
        int rep = 1+f(i+1,j+1,s,t,dp);
        return dp[i][j]= Math.min(ins,Math.min(del,rep));
    } 
    public int editDistance(String s, String t) {
        // Code here
        int dp[][]=new int [s.length()][t.length()];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(0,0,s,t,dp);
    }
}