class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26];
        int[] m = new int[26];
        for(int i=0;i<ransomNote.length();i++)
        {
            char ch = ransomNote.charAt(i);
            int a = (int)ch -97;
            r[a]++;
        }
        for(int j=0;j<magazine.length();j++)
        {
            char ch = magazine.charAt(j);
            int a = (int)ch -97;
            m[a]++;
        }
        for(int k=0;k<26;k++)
        {
            if(r[k]>m[k])
                return false;
        }
        return true;
    }
}