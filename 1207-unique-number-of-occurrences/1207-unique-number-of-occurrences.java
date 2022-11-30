class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       Map<Integer,Integer> map = new HashMap() ;
        for(int i=0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]))
                map.put(arr[i],1);
            else
                map.replace(arr[i],map.get(arr[i])+1);
        }
       HashSet<Integer> set = new HashSet();
        for(Map.Entry<Integer,Integer> m : map.entrySet()){    
            if(set.contains(m.getValue()))
                return false;
            set.add(m.getValue());
        }
        return true;
    }
}