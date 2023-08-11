//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        
        int arr[]=new int[26];
        // HashMap<Character,Integer> map=new HashMap();
        for(int i=0;i<S.length();i++)
        {
            int cur=S.charAt(i)-'a';
           arr[cur]++;
        }
        int count=0;
       for(int i=0;i<26;i++)
       {
           if(arr[i]%2==1)
            count++;
       }
        if(count>1)
            return 0;
        return 1;
    }
}