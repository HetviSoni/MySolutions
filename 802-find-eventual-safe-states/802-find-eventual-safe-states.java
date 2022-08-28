class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        for(int j=0;j<graph.length;j++)
            list.add(new ArrayList());
        HashSet<Integer> term = new HashSet();
        int ind[]= new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                list.get(i).add(graph[i][j]);
                ind[i]++;
            }
            // System.out.println(Arrays.toString(list.get(i).toArray()));
        }
         // System.out.println(Arrays.toString(ind));
        for(int i=0;i<graph.length;i++)
        {
            if(ind[i]==0)
                term.add(i);
        }
        HashSet<Integer> ans= new HashSet();
        for(int k=0;k<=100;k++){
        for(int i=0;i<graph.length;i++)
        {
            boolean isSafe=true;
            for(int j:list.get(i))
            {
                if(!term.contains(j))
                    isSafe=false;
            }
            if(isSafe)
            {
                 ans.add(i);
                 term.add(i);
            }
               
        }
        }
        ArrayList<Integer> res=new ArrayList();
        for(int x:ans)
            res.add(x);
        Collections.sort(res);
        return res;
        
    }
}