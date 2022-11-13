class Solution {
    public String reverseWords(String s) {
        int n = s.length()-1;
        int pointer =n+1;
        String ans="";
        for(int i=n;i>=0;i--)
        {
            if(s.charAt(i)==' ')
            {
                ans = ans+ s.substring(i+1,pointer);
                ans=ans+ s.substring(i,i+1);
                if(i>0 && s.charAt(i)==' ') {
                    while (i > 0 && s.charAt(i) == ' ') 
                    i--;
                    pointer = i + 1;
                }
                else
                    pointer=i;
            }
        }
        ans = ans+s.substring(0,pointer);
        ans=ans.trim();
        return ans;
    }
}