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
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
//  static ArrayList<Long> primesq = new ArrayList();
    public static boolean isPrime(long n)
    {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
    // static void fill()
    // {
    //     for(long i=0;i<1000001;i++)
    //     {
    //         if(isPrime(i))
    //         {
    //             primesq.add((i*i));
    //         }
    //     }
    // }
    static boolean isThreeDisctFactors(long n)
    {
        int sq = (int)Math.sqrt(n);
        if (1L * sq * sq != n)
            return false;
        return isPrime(sq) ? true : false;
    }
    // static int findIndex(long q)
    // {
    //     int ans=0;
    //     int start = 0;
    //     int end = primesq.size()-1;
    //     while(start<=end)
    //     {
    //         int mid = start+ (end-start)/2;
    //         if(primesq.get(mid)>q)
    //         {
    //             end = mid-1;
    //         }
    //         else{
    //             ans = mid;
    //             start = mid+1;
    //         }
    //     }
    //     return ans;
    // }
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        // fill();
        ArrayList<Integer> fin = new ArrayList<Integer>();
        for(int i=0;i<q;i++)
        {
            int ad=0;
            for(int j=1;j<=query.get(i);j++)
            {
                if(isThreeDisctFactors(j))
                ad++;
            }
            fin.add(ad);
        }
        return fin;
    }
}
// q=10
// 4  1 2 4  -->2         .
// 9  1 3 9  -->3          
// 25 1 5 25 -->5
// 49 1 7 49 -->7
// 81 1 9 81 -->9
// 121 1 11 121 -->11
// 169 1 13 169 -->13
// 225 1 3 5 ....
// 289 1 17 289 -->17
// 361 1 19 361 -->19
// 441 1 3 7....
// 529 1 23 529 -->23
// 841 1 29 841 -->29

// 961 1 31 961 -->31
// 1369         -->37

// 1681   41    -->41
// 1849   43    -->43
// 2209 47      -->47