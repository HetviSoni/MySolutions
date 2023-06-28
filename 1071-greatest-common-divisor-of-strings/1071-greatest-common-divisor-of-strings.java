class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
    if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if (!str1.startsWith(str2)) {
            return "";
        }
        if (str2.isEmpty()) {
            return str1;
        }
        return gcdOfStrings(str2, str1.substring(str2.length()));
    }
}