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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int f(int i, int j, int arr[][], int n, int dp[][])
    {
        if(i>=n) 
            return 0;
        if(i==n-1)
            return arr[i][j];
        if(i!=-1 && j!=-1 && dp[i][j]!=-1)     
                return dp[i][j];
        //a1
        int a1=0;
        if(j==-1 && i==-1)
            a1 =  f(i+1, (j+1)%3 , arr, n,dp);
        else
            a1 = arr[i][j] + f(i+1, (j+1)%3 , arr, n ,dp);
            
        //a2
        int a2 =0;
        if(j==-1 && i==-1)
            a2 = f(i+1, (j+2)%3 , arr, n,dp );
        else
            a2 = arr[i][j] + f(i+1, (j+2)%3 , arr, n ,dp);
            
        int a3=0;
        if(j==-1 && i==-1)
        {
              a3 = f(i+1,(j+3)%3,arr,n,dp);
              return Math.max(a1,Math.max(a2,a3));
        }
            
            
        return dp[i][j]=  Math.max(a1,a2);
    }
    public int maximumPoints(int points[][],int n){
        //code here
        // int a = f(0,0,points,n);
        // System.out.println(a+" is a");
        // int b = f(0,1,points,n);
        // System.out.println(b+" is b");
        // int c = f(0,2,points,n);
        // System.out.println(c+ " is c");
        int dp[][] = new int[n][3];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return f(-1,-1,points,n,dp);
    }
}

// 1 2 5
// 3 1 1
// 3 3 3

// 1 --> 2,0