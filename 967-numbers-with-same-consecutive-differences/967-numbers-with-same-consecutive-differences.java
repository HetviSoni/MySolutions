class Solution {
    static int length(int num)
    {
        return (int) (Math.log10(num) + 1);  
    }
    static void f(int n, int k, HashSet<Integer> ans,int cur)
    {
        if(length(cur)==n)
        {
            ans.add(cur);
            return ;            
        }
        if(cur%10+k<=9)
        {
            f(n,k,ans,cur*10+cur%10+k);            
        }
        if(cur%10-k>=0)
            f(n,k,ans,cur*10+(cur%10-k));
    }
    public int[] numsSameConsecDiff(int n, int k) {
        HashSet<Integer> ans = new HashSet();
        for(int i=1;i<=9;i++)
            f(n,k,ans,i);
        int[] res = new int[ans.size()];
        int c = 0;
        for(Integer x : ans) res[c++] = x;
        // int res[]= ans.toArray();
        
        return res;
    }
} 
         