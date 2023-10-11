//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        // code here
        Map<Character,Integer> map = new HashMap();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int n=s.length();
        int ans=map.get(s.charAt(0));
        for(int i=1;i<n;i++)
        {
            if(map.get(s.charAt(i))>map.get(s.charAt(i-1)))
                ans=ans+map.get(s.charAt(i))- 2*map.get(s.charAt(i-1));
            else
                ans=ans+map.get(s.charAt(i));
        }
        return ans;
    }
}