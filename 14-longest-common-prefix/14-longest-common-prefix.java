class Solution {
    public String longestCommonPrefix(String[] str) {
        String lcp = str[0];
        for(int i=1;i<str.length;i++)
        {
            lcp = lcp.substring(0,Math.min(lcp.length(),str[i].length()));
            for(int j=0;j<Math.min(lcp.length(),str[i].length());j++)
            {
                if(lcp.charAt(j)!=str[i].charAt(j))
                {
                    lcp = lcp.substring(0,j);
                    break;
                }
            }
            
        }
        return lcp;
    }
}