class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList();
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],1);
        }
        // int i=1;
        for(int j=1;j<=nums.length;j++)
        {
            if(!map.containsKey(j))
                ans.add(j);
        }
        return ans;
    }
}