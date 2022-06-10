class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int c=0;
        int st=0;
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),i);
                c++;
                max=Math.max(max,c);
            }
            else
            {
                st=Math.max(st,map.get(s.charAt(i))+1);
                c=i-st+1;
                // st=i-map.get(s.charAt(i))+1;
                map.replace(s.charAt(i),i);
                max=Math.max(c,max);
                // c=0;
            }
        }
        return max;
    }
}