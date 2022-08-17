class Solution {
    static void f(HashSet<List<Integer>> ans, int arr[], List<Integer> cur,int i, int prev)
    {
        if(i==arr.length)
        {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(prev==-1 || arr[prev]<=arr[i])
        {
            cur.add(arr[i]);
            f(ans,arr,cur,i+1,i);
            cur.remove(cur.size()-1);
            f(ans,arr,cur,i+1,prev);
        }
        else
            f(ans,arr,cur,i+1,prev);
        
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> cur = new ArrayList();
        HashSet<List<Integer>> ans = new HashSet();
        f(ans,nums,cur,0,-1);
        for(List<Integer> l:ans)
        {
            if(l.size()>1)
             res.add(l);
        }
           
        return res;
    }
}