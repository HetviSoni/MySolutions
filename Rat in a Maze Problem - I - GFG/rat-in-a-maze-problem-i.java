//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static void f(int i, int j,int arr[][], int vis[][],ArrayList<String> ans, String cur )
    {
        if(i==arr.length-1 && j==arr[0].length-1){
            ans.add(cur);
            return;
        }
        if(i>=arr.length || j>=arr[0].length)
            return ;
        
        //up
        int u=0,d=0,r=0,l=0;
        if(i-1>=0 && arr[i-1][j]==1 && vis[i-1][j]!=1)
        {
            vis[i-1][j]=1;
            cur+='U';
            f(i-1,j,arr,vis,ans,cur);
            cur = cur.substring(0,cur.length()-1);
            vis[i-1][j]=0;
        }
        //down
        if(i+1<arr.length && arr[i+1][j]==1 && vis[i+1][j]!=1)
        {
            vis[i+1][j]=1;
            cur+='D';
            f(i+1,j,arr,vis,ans,cur);
            cur = cur.substring(0,cur.length()-1);
            vis[i+1][j]=0;
        }
        //right
        if(j+1<arr[0].length && arr[i][j+1]==1 && vis[i][j+1]!=1)
        {
            vis[i][j+1]=1;
            cur+='R';
            f(i,j+1,arr,vis,ans,cur);
            cur = cur.substring(0,cur.length()-1);
            vis[i][j+1]=0;
        }
        //left
        if(j-1>=0 && arr[i][j-1]==1 && vis[i][j-1]!=1)
        {
            vis[i][j-1]=1;
            cur+='L';
            f(i,j-1,arr,vis,ans,cur);
            cur = cur.substring(0,cur.length()-1);
            vis[i][j-1]=0;
        }
    
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int vis[][]= new int[n][n];
        vis[0][0]=1;
        ArrayList<String> ans = new ArrayList();
        if(m[0][0]==0)
            return ans;
        f(0,0,m,vis,ans,"");
        
        return ans;
    }
}