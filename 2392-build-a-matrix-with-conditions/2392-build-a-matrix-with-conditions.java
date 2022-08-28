class Solution {
    static boolean isPossible(ArrayList<ArrayList<Integer>> graph, int ind[])
    {
        Queue<Integer> q = new LinkedList();
        int count=0;
        for(int i=1;i<ind.length;i++)
        {
            if(ind[i]==0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int a = q.remove();
            count++;
            for(int j:graph.get(a))
            {
                ind[j]--;
                if(ind[j]==0)
                    q.add(j);
            }
        }
        if(count==ind.length-1)
            return true;
        return false;
    }
    static void order(int i, ArrayList<ArrayList<Integer>> graph, Stack<Integer> s, int[] vis)
    {
        vis[i]=1;
        for(int j:graph.get(i))
        {
            if(vis[j]==0)
            {
                order(j,graph,s,vis);
            }
        }
        s.push(i);
    }
    public int[][] buildMatrix(int k, int[][] row, int[][] col) {   
        ArrayList<ArrayList<Integer>> graphRow = new ArrayList();
        ArrayList<ArrayList<Integer>> graphCol = new ArrayList();
        int inRow[]= new int[k+1];
        int inCol[]= new int[k+1];
        for(int i=0;i<=k;i++)
        {
            graphRow.add(new ArrayList());
            graphCol.add(new ArrayList());
        }
        for(int i=0;i<row.length;i++)
        {
            int above = row[i][0];
            int below = row[i][1];
            graphRow.get(below).add(above);
            inRow[above]++;
        }
        for(int i=0;i<col.length;i++)
        {
            int left = col[i][0];
            int right = col[i][1];
            graphCol.get(right).add(left);
            inCol[left]++;
        }
        int ans[][]= new int[k][k];
        if(isPossible(graphRow,inRow) && isPossible(graphCol,inCol))
        {
            Stack<Integer> rowEle = new Stack();
            Stack<Integer> colEle = new Stack();
            int visRow[]= new int[k+1];
            int visCol[]= new int[k+1];
            for(int j=1;j<visRow.length;j++)
            {
                if(visRow[j]==0)
                    order(j,graphRow,rowEle,visRow);
            }
            for(int j=1;j<visCol.length;j++)
            {
                if(visCol[j]==0)
                    order(j,graphCol,colEle,visCol);
            }
            int ansRow[]= new int[k];
            int ansCol[]= new int[k];
            for(int i=ansRow.length-1;i>=0;i--)
            {
                ansRow[i]=rowEle.pop();
            }
            for(int i=ansCol.length-1;i>=0;i--)
            {
                ansCol[i]=colEle.pop();
            }
            // System.out.println(Arrays.toString(ansRow));
            // System.out.println(Arrays.toString(ansCol));            
            for(int i=0;i<k;i++)
            {
                int a = ansRow[i];
                for(int j=0;j<k;j++)
                {
                    if(ansCol[j]==a)
                    {
                        ans[i][j]=a;
                        break;
                    }
                }
            }
            return ans;
            
        }
        else
            return new int[0][0];
    }
}