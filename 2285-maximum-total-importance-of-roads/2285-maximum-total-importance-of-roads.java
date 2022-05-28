
class Solution {
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
 
    public long maximumImportance(int n, int[][] roads) {
        // int ind[]= new int[n];
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<roads.length;i++)
        {
            if(!map.containsKey(roads[i][0]))
                map.put(roads[i][0],1);
            else
                map.replace(roads[i][0],map.get(roads[i][0])+1);
            if(!map.containsKey(roads[i][1]))
                map.put(roads[i][1],1);
            else
                map.replace(roads[i][1],map.get(roads[i][1])+1);
        
        }
        for(int d=0;d<n;d++)
        {
            if(!map.containsKey(d))
                map.put(d,0);
        }
        HashMap<Integer,Integer> sorted=sortByValue(map);
        int a=1;
         for(Map.Entry<Integer,Integer> m : sorted.entrySet()){   
             sorted.replace(m.getKey(),a);
             a++;
            // System.out.println(m.getKey()+" "+m.getValue());    
           }  
        long sum=0;
        for(int k=0;k<roads.length;k++)
        {
            int n1=roads[k][0];
            int n2 = roads[k][1];
            sum=sum+sorted.get(n1)+sorted.get(n2);
        }

        return sum;
        
    }
}