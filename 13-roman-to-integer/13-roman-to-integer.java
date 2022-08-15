class Solution {
    
    public int romanToInt(String s) {
        
        Map<Character,Integer> map = new HashMap();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int n=s.length();
        int ans=map.get(s.charAt(0));
        for(int i=1;i<n;i++)
        {
            if(map.get(s.charAt(i))>map.get(s.charAt(i-1)))
                ans=ans+map.get(s.charAt(i))- 2*map.get(s.charAt(i-1));
            else
                ans=ans+map.get(s.charAt(i));
        }
        return ans;
    }
}