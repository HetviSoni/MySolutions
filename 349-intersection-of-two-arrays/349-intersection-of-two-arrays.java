class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums1.length;i++)
            map.put(nums1[i],1);
        // System.out.println(map.size());
        for(int j=0;j<nums2.length;j++)
        {
            if(map.containsKey(nums2[j]))
                map.replace(nums2[j],map.get(nums2[j])+1);
        }
                // System.out.println(map.size());

        ArrayList<Integer> temp = new ArrayList();
        for(Map.Entry<Integer,Integer> m:map.entrySet())
        {
            // System.out.println(m.getKey()+" "+m.getValue());
            if(m.getValue()>=2)
                temp.add(m.getKey());
        }
        int ans[]= new int[temp.size()];
        for(int i=0;i<temp.size();i++)
            ans[i]=temp.get(i);
        return ans;
    }
}