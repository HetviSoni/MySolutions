class Solution {
    static int less(String s, int k)
    {
        int ans=0;
        int n=s.length();
        int p=0;
        String temp="";
        for(int i=n-1;i>=0;i--)
        {
            if(Long.parseLong(s.charAt(i)+temp, 2)<=(long)k)
            {
                ans++;
                temp=s.charAt(i)+temp;
            }
            else{
                p=i;
                break;
                
            }
        } 
        for(int j=p-1;j>=0;j--)
        {
            if(s.charAt(j)=='0')
                ans++;
        }
        return ans;
    }
    public int longestSubsequence(String s, int k) {
        int ans=0;
        int n=s.length();
        if(n<=32)
            return less(s,k);
        int p=0;
        String temp="";
        for(int i=n-1;i>=n-32;i--)
        {
            if(Long.parseLong(s.charAt(i)+temp, 2)<=(long)k)
            {
                ans++;
                temp=s.charAt(i)+temp;
            }
            else{
                p=i;
                break;
                
            }
            if(i==n-32)
                p=i;
        } 
       
        for(int j=p-1;j>=0;j--)
        {
            if(s.charAt(j)=='0')
                ans++;
        }
        
        return Math.min(ans,s.length());
    }
}