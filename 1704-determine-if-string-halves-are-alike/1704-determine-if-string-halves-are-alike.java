class Solution {
    public boolean halvesAreAlike(String s) {
        // char[]={'a','e','i','o','u'};
        int v1 = 0;
        int v2 = 0;
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u'  ||s.charAt(i)=='A' ||s.charAt(i)=='E' ||s.charAt(i)=='I' ||s.charAt(i)=='O' ||s.charAt(i)=='U' )
                v1++;
        }
        for(int i=s.length()/2;i<s.length();i++)
        {
             if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u'  ||s.charAt(i)=='A' ||s.charAt(i)=='E' ||s.charAt(i)=='I' ||s.charAt(i)=='O' ||s.charAt(i)=='U' )
                v2++;
        }
        if(v1==v2)
            return true;
        return false;
    }
}