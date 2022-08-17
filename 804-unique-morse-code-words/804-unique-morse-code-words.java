class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."  };
        HashSet<String> set = new HashSet();
        for(int i=0;i<words.length;i++)
        {
            int n = words[i].length();
            String s = "";
            for(int j=0;j<n;j++)
            {
                char ch = words[i].charAt(j);
                int x = (int)ch -97;
                s+=morse[x];
            }
            set.add(s);
        }
        return set.size();
    }
}