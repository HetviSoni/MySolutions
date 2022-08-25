class Solution {
    static boolean f(int i, String s, Map<String,Integer> map, int[] dp)
    {
        if(i==s.length())
            return true;
        if(dp[i]!=-1)
        {
            if(dp[i]==0)
                return false;
            return true;
        }
        for(int j=i;j<s.length();j++)
        {
            if(map.containsKey(s.substring(i,Math.min(j+1,s.length())))
               && f(j+1,s,map,dp)
              )
            {
                dp[i]=1;
                return true;
            }
                
            
        }
        dp[i]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Integer> map = new HashMap();
        for(int i=0;i<wordDict.size();i++)
        {
            map.put(wordDict.get(i),1);
        }
        int dp[]= new int[s.length()];
        Arrays.fill(dp,-1);
        return f(0,s,map,dp);
        
    }
}