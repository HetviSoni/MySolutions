class Solution {
    static ArrayList<Integer> findIndex(int land[][], int i, int j)
    {
        ArrayList<Integer> arr= new ArrayList();
        arr.add(i);
        arr.add(j);
        while(i<land.length && land[i][j]==1)
        {
            // land[i][j]=-1;
            i++;
        }
        i--;
        while(j<land[0].length && land[i][j]==1)
        {
            // land[i][j]=-1;
            j++;
        }
        j--;
        for(int a=arr.get(0);a<=i;a++)
        {
            for(int b=arr.get(1);b<=j;b++)
            {
                land[a][b]=-1;
            }
        }
        
        arr.add(i);
        arr.add(j);
        return arr;
    }
    public int[][] findFarmland(int[][] land) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for(int i=0;i<land.length;i++)
        {
            for(int j=0;j<land[0].length;j++)
            {
                if(land[i][j]==1)
                {
                    // System.out.println("Calling for "+i+" "+j);
                    ans.add(findIndex(land,i,j));
                }
            }
        }
        int res[][]= new int[ans.size()][4];
        for(int i=0;i<res.length;i++)
        {
            // System.out.println(ans.get(i).toString());
            for(int j=0;j<4;j++)
            {
                res[i][j]=ans.get(i).get(j);
            }
        }
        return res;
    }
}









