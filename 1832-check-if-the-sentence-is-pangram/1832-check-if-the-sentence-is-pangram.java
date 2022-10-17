class Solution {
    public boolean checkIfPangram(String sentence) {
        for(char ch='a';ch<='z';ch++)
        {
            if(!sentence.contains(Character.toString(ch))) {
                return false;
            }
        }
        return true;
    }
}