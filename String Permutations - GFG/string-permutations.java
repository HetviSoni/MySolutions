//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static void f(String p, ArrayList<String> ans,String up)
    {
        if(up.length()==0)
        {
            ans.add(p);
            return ;
        }
        
        char ch=up.charAt(0);
        
        for(int i=0;i<=p.length();i++)
        {
            String cur= p.substring(0,i)+ch+p.substring(i);
            // System.out.println(up.substring(1));
            f(cur,ans,up.substring(1));
        }
    }
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> ans=new ArrayList();
        int start=0;
        f("",ans,S);
        // int end=ans.size()-1;
        // while(start<end)
        // {
        //     String temp=ans.get(st)
        // }
        Collections.sort(ans);
        return ans;
        
    }
	   
}
