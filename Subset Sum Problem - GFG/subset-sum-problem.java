//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    static boolean h(int i,int target, int arr[],int dp[][])
    {
        if(target==0)
            return true;
        if(i>=arr.length)
            return false;
        if(dp[i][target]!=-1)
        {
            if(dp[i][target]==1)
                return true;
            return false;
        }
        //pick
        boolean pick = false;
        if(arr[i]<=target)
            pick= h(i+1,target-arr[i],arr,dp);
        boolean np = h(i+1,target,arr,dp);
        if(pick||np)
            dp[i][target]=1;
        else
            dp[i][target]=0;
        return pick || np;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int dp[][] = new int[N][sum+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return h(0,sum,arr,dp);
    }
}



