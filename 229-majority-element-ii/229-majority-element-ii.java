class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        List<Integer> ans = new ArrayList();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                map.replace(nums[i],map.get(nums[i])+1);
        }
        int n=nums.length/3;
        for (Integer i : map.keySet())
        {
            if(map.get(i)>n)
                ans.add(i);
          
        }
        return ans;
    }
}