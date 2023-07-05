//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    static ArrayList<Integer> ans;
    static void f(int i, ArrayList<Integer> arr, int sum)
    {
        if(i==arr.size())
        {
            ans.add(sum);
            return;
        }
        f(i+1,arr,sum+arr.get(i));
        f(i+1,arr,sum);

    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ans = new ArrayList();
        f(0,arr,0);
        Collections.sort(arr);
        return ans;
    }
}