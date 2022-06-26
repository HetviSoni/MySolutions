class Solution {
    static void f(int i, int j , char[][] arr, int[][] vis)
    {
        if(i-1>=0)
        {
            if(arr[i-1][j]=='1' && vis[i-1][j]==-1)
            {
                vis[i-1][j]=1;
                f(i-1,j,arr,vis);
            }
        }
        if(j-1>=0)
        {
            if(arr[i][j-1]=='1' && vis[i][j-1]==-1)
            {
                vis[i][j-1]=1;
                f(i,j-1,arr,vis);
            }                
        }
        if(i+1<arr.length)
        {
            if(arr[i+1][j]=='1' && vis[i+1][j]==-1)
            {
                vis[i+1][j]=1;
                 f(i+1,j,arr,vis);
            }
           
        }
        if(j+1<arr[0].length)
        {
            if(arr[i][j+1]=='1' && vis[i][j+1]==-1)
            {
                vis[i][j+1]=1;
                f(i,j+1,arr,vis);
            }
                
        }        
        arr[i][j]='0';
        // 1 1 1
        // 0 1 0
        // 1 1 1
    }
    public int numIslands(char[][] grid) {
        int ans=0;
        int vis[][]= new int[grid.length][grid[0].length];
        for(int row[]:vis)
            Arrays.fill(row,-1);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    f(i,j,grid,vis);
                    ans++;
                }
            }
        }
      
        // for(int i=0;i<grid.length;i++)
        //     System.out.println(Arrays.toString(grid[i]));
        return ans;
    }
}