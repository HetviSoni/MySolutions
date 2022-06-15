class Solution {
    static boolean isPossible(String a, String b)
    {
        if(a.length()!=b.length()-1)
            return false;
        int ta=0,tb=0;
        while(ta<a.length() && tb<b.length())
        {
            if(a.charAt(ta)==b.charAt(tb))
            {
                ta++;
            }
            tb++;
        }
        if(ta==a.length())
            return true;
        return false;
    }
    static int f(int prev,int i, String[] arr, int[][] dp)
    {
        if(i==arr.length)
            return 0;
        if(prev==-1)
            return Math.max(1+f(i,i+1,arr,dp),f(-1,i+1,arr,dp));
        if(dp[i][prev]!=-1)
            return dp[i][prev];
        int t=0;
        if(isPossible(arr[prev],arr[i]))
            t=1+f(i,i+1,arr,dp);
        return dp[i][prev]= Math.max(t,f(prev,i+1,arr,dp));
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        int dp[][]= new int[words.length][words.length+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        // for(String i:words)
        //     System.out.println(i);
        return f(-1,0,words,dp);
    }
}