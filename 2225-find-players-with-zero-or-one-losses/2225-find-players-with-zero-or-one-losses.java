class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
       List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i< matches.length;i++)
        {
            if(!map.containsKey(matches[i][0]))
                map.put(matches[i][0],0);
            if(!map.containsKey(matches[i][1]))
                map.put(matches[i][1],1);
            else
            {
                map.replace(matches[i][1],map.get(matches[i][1])+1);
            }
        }
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue()==0)
                ans1.add(entry.getKey());
            else if(entry.getValue()==1)
                ans2.add(entry.getKey());
        }
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}