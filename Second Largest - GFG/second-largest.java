//{ Driver Code Starts
//Initial Template for Java



import java.util.stream.Collectors; 
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        int first=-1;
        int sec=-1;
        if(arr[0]>arr[1])
        {
            first=arr[0];
            sec=arr[1];
            
        }else{
            first=arr[1];
            sec=arr[0];
        }
        if(first==sec)
                sec=-1;
        //12, 35, 1, 10, 34, 1
        for(int i=2;i<n;i++)
        {
            int cur=arr[i];
            //first=35 sec=12
            //cur=43
            // sec=43
            if(cur>sec && cur!=sec && cur!=first)
            {
                sec=cur;
                if(sec>first && sec!=first)
                {
                    int temp=first;
                    first=sec;
                    sec=temp;
                }
            }
        }
        return sec;
        // code here
    }
}