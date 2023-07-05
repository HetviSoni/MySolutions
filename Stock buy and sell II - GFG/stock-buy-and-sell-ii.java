//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int f(int i, int arr[], int canBuy, int dp[][])
    {
        if(i==arr.length)
        {
            return 0;
        }
        if(dp[i][canBuy]!=-1)
            return dp[i][canBuy];
        if(canBuy==1)
        {
            int buy = -arr[i] + f(i+1,arr,0,dp);
            int nb = f(i+1,arr,1,dp);
            return dp[i][canBuy]= Math.max(buy,nb);
        }
        else{
            int sell = arr[i] + f(i+1,arr,1,dp);
            int ns = f(i+1,arr,0,dp);
            return dp[i][canBuy]= Math.max(sell,ns);
        }
        
    }
    public static int stockBuyAndSell(int n, int[] prices) {
        int dp[][]=new int[n][2];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        // code here
            return f(0,prices,1,dp);
    }
}
        
