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
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    static int f(int i, int cur, int target,int nums[], int dp[][])
    {
        if(i==nums.length){
            if(cur==target)
                return 1;
            return 0;
        }
      if(i>nums.length)
            return 0;
        if(dp[i][cur]!=-1)
            return dp[i][cur];
        long count=0;
        if(cur+nums[i]<=target)
            count+=f(i+1,cur+nums[i],target,nums,dp);
        count=count%1000000007;
        count+= f(i+1,cur,target,nums,dp);
        count=count%1000000007;
        return dp[i][cur]=(int)count;
        
    }
    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int sum=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        if((sum-d)%2==1 || sum-d<0)
            return 0;
        int target = (sum-d)/2;
        int dp[][] = new int[n][target+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(0,0,target,arr,dp);
	   
    }
}
// total = 17
// 5 2 cur sum1 = 7
// sum2 = 17-7  = 10
// if(i==nums.length-1)
// {
//     int sum2 = total-sum1;
//     if(sum1-sum2==d)
//         return 1
// }
