class Solution {
     static int f(int grid[][], int i, int j, int[][] dp)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return 0;
        int arr[]=new int[4];
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i+1<grid.length)
        {
            if(grid[i+1][j]>grid[i][j])
                arr[0]=1+f(grid,i+1,j,dp);
        }
        if(i-1>=0)
        {
            if(grid[i-1][j]>grid[i][j])
                arr[1]=1+f(grid,i-1,j,dp);
        }
        if(j+1<grid[0].length)
        {
            if(grid[i][j+1]>grid[i][j])
                arr[2]=1+f(grid,i,j+1,dp);
        }
        if(j-1>=0)
        {
            if(grid[i][j-1]>grid[i][j])
                arr[3]= 1+f(grid,i,j-1,dp);
        }
         int max = arr[0];
         for(int x=1;x<4;x++)
             max=Math.max(max,arr[x]);
        return dp[i][j]=max;

    }
    public int longestIncreasingPath(int[][] grid) {
        int ans = 0;
        
        int dp[][]= new int[grid.length][grid[0].length];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                ans = Math.max(ans,f(grid,i,j,dp));
            }
            for(int row[]:dp)
                Arrays.fill(row,-1);
        }
        return ans+1;
    }
}