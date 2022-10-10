class Solution {
    static boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
            return "";
       
            for(int i=0;i<palindrome.length();i++)
            {
                String ans = palindrome.substring(0,i) +'a' + palindrome.substring(i+1);
                // System.out.println(palindrome.substring(0,i)+" "+ palindrome.substring(Math.min((i+1),100)));
                if(!isPalindrome(ans))
                    return ans;
            }
        
        return palindrome.substring(0,palindrome.length()-1)+'b';
    }
}