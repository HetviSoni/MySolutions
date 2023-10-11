//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPali(String a, int s, int e)
    {
        while(s<=e)
        {
            if(a.charAt(s)!=a.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
    String longestPalindrome(String s){
        // code here
        int n = s.length();
        int max=0;
        int start=0;
        int end=0;
        for(int i=0;i<n;i++)
        {
            for(int j=n-1;j>i;j--)
            {
                if(j-i+1>max)
                {
                    if(isPali(s,i,j))
                    {
                        max=j-i+1;
                        start=i;
                        end=j;
                        break;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}