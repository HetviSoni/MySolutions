class Solution {
    static boolean isPalin(String s)
    {
        int st=0;
        int e=s.length()-1;
        while(st<e)
        {
            if(s.charAt(st)!=s.charAt(e))
            {
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
    public int removePalindromeSub(String s) {
        if(isPalin(s))
            return 1;
        return 2;
    }
}