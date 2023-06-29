//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int l1 = 0;
        int l2=0;
        int count=0;
        long ans=0;
        while(l1<arr1.length && l2<arr2.length)
        {
            if(arr1[l1]<arr2[l2])
            {
                count++;
                if(count==k){
                ans=arr1[l1];
                    break;
                }
                l1++;
            }
            else{
                count++;
                if(count==k){
                ans=arr2[l2];
                    break;
                }
                l2++;
            }
        }
        while(l1<arr1.length)
        {
            count++;
                if(count==k)
                ans=arr1[l1];
                l1++;
        }
        while(l2<arr2.length)
        {
            count++;
                if(count==k)
                ans=arr2[l2];
                l2++;
        }
        return ans;
    }
}