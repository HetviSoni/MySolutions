//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int e, int f) 
	{
	    // Your code here
	    int arr[][]=new int[e+1][f+1];
	    for(int i=0;i<=e;i++)
	    {
	        for(int j=0;j<=f;j++)
	        {
	            if(i==0)
	                arr[i][j]=99999;
	            else if (i==1)
	                arr[i][j] =j;
	           else if(j==0 || j==1)
	                arr[i][j]=j;
	           else{
	               int ans=Integer.MAX_VALUE;
	               int a=0;
	               int b=j-1;
	               while(a<=j-1 && b>=0)
	               {
	                   int cur=Math.max(arr[i-1][a], arr[i][b]);
	                   a++;
	                   b--;
	                   ans=Math.min(ans,cur);
	               }
	               arr[i][j]=1+ans;
	           }
	                
	        }
	    }
	   // for(int i=0;i<=e;i++)
	   // {
	   //     System.out.println(Arrays.toString(arr[i]));
	   // }
	    return arr[e][f];
	}
}
