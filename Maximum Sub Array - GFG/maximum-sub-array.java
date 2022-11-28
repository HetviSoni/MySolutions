//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        int max=-1;
        int sm=0;
        int em=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]>=0)
            {
                int curi=i;
                while(i<n  && a[i]>=0)
                {
                   sum+=a[i] ;
                   i++;
                }
                if(sum>max)
                {
                    sm=curi;
                    em=i;
                    max=sum;
                }
            }
            sum=0;
        }
        ArrayList<Integer> ans = new ArrayList();
        for(int i=sm;i<em;i++)
        ans.add(a[i]);
        if(ans.size()==0)
            ans.add(-1);
        return ans;
    }
}







