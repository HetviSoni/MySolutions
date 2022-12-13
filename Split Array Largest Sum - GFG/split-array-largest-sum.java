//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean check(int mid, int array[], int n, int K)
    {
 
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
 
            // If individual element is greater
            // maximum possible sum
            if (array[i] > mid)
                return false;
 
            // Increase sum of current sub - array
            sum += array[i];
 
            // If the sum is greater than
            // mid increase count
            if (sum > mid) {
                count++;
                sum = array[i];
            }
        }
        count++;
 
        // Check condition
        if (count <= K)
            return true;
        return false;
    }
    
    static int splitArray(int[] array , int n, int K) {
        // code here
        int start = 1;
        for (int i = 0; i < n; ++i) {
            if (array[i] > start)
                start = array[i]; //Max subarray sum, considering subarray of length 1
        }
        int end = 0;
 
        for (int i = 0; i < n; i++) {
            end += array[i]; //Max subarray sum, considering subarray of length n
        }
 
        // Answer stores possible
        // maximum sub array sum
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
 
            // If mid is possible solution
            // Put answer = mid;
            if (check(mid, array, n, K)) {
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
 
        return answer;
    }
};