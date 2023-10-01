//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static void f(int i, int j, int m,int n,ArrayList<Integer> ans, int arr[][])
    {
        if (i > m || j > n) {
            return;
        }
        //right
        for(int x=j;x<=n;x++)
        {
            // System.out.println("right "+arr[i][x]);
            ans.add(arr[i][x]);
        }
        //down
        for(int x=i+1;x<=m;x++)
        {
            // System.out.println("down "+arr[x][n]);
            ans.add(arr[x][n]);
        }
        //left
        if(m>i){
        for(int x=n-1;x>=j;x--)
        {
            // System.out.println("left "+arr[m][x]);
            ans.add(arr[m][x]);
        }}
        //up
        if(n>j){
        for(int x=m-1;x>i;x--)
        {
            // System.out.println("up "+arr[x][i]);
            ans.add(arr[x][i]);
        }}
        return;
    }
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
         ArrayList<Integer> ans=new ArrayList();
         f(0,0,matrix.length-1,matrix[0].length-1,ans,matrix);
         return ans;
        
    }
}
