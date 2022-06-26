class Solution {
    static int f(int i, int j , int[][] arr, int[][] vis)
    {
        int a=0,b=0,c=0,d=0;
        if(i+1<arr.length)
        {
            if(arr[i+1][j]==1 && vis[i+1][j]==-1)
            {
                vis[i+1][j]=1;
                a=1+f(i+1,j,arr,vis);
                
            }
        }
        if(j+1<arr[0].length)
        {
            if(arr[i][j+1]==1 && vis[i][j+1]==-1)
            {
                vis[i][j+1]=1;
                 b=1+f(i,j+1,arr,vis);
            }
        }
        if(i-1>=0)
        {
            if(arr[i-1][j]==1 && vis[i-1][j]==-1)
            {
                vis[i-1][j]=1;
                c=1+f(i-1,j,arr,vis);
            }
        }
        if(j-1>=0)
        {
            if(arr[i][j-1]==1 && vis[i][j-1]==-1)
            {
                vis[i][j-1]=1;
                d=1+f(i,j-1,arr,vis);
            }
        }
        arr[i][j]=0;
        // System.out.println("a "+a+" b "+b+" c "+c+" d "+d);
        // if(a==0 && b==0 && c==0 && d==0)
        //     return 1;
        return a+b+c+d;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==1 && grid[0].length==1)
        {
            if(grid[0][0]==1)
                return 1;
            return 0;
        }
        int vis[][]= new int[grid.length][grid[0].length];
        for(int[] row:vis)
            Arrays.fill(row,-1);
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int a = f(i,j,grid,vis);
                    if(a==0)
                        a=1;
                    max=Math.max(max,a);
                }
            }
        }
        return max;
    }
}