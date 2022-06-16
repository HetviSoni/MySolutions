class Solution {
    static boolean isPali(String a, int s, int e)
    {
        while(s<=e)
        {
            if(a.charAt(s)!=a.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int max=0;
        int start=0;
        int end=0;
        for(int i=0;i<n;i++)
        {
            for(int j=n-1;j>i;j--)
            {
                {
                    if(j-i+1>max)
                    {
                        if(isPali(s,i,j))
                        {
                            max=j-i+1;
                            start=i;
                            end=j;
                            break;
                        }
                        
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}