class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0;i<n.length();i++)
        {
            char ch = n.charAt(i);
            int a = ch - '0';
            max= Math.max(max,a);
        }
        if(max ==0 || max == 1)
            return 1;
        return max;
        
    }
}



