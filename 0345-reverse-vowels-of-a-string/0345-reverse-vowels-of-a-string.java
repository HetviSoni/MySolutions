class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int end=s.length()-1;
        int start= 0;
        StringBuilder string = new StringBuilder(s);
        while(start<end)
        {
            if(set.contains(s.charAt(start)) && set.contains(s.charAt(end)))
            {
                char a = s.charAt(start);
                char b = s.charAt(end);
                string.setCharAt(start, b);
                string.setCharAt(end, a);
                start++;
                end--;
            }
            else if(set.contains(s.charAt(start)) && !set.contains(s.charAt(end)))
                end--;
            else if(!set.contains(s.charAt(start)) && set.contains(s.charAt(end)))
                start++;
            else{
                start++;
                end --;
            }
        }
        return string.toString();
    }
}