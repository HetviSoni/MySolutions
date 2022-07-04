class Solution {
    static int f(int i, int j, int[][] grid, int[][]dp)
    {
        if(i==grid.length-1 && j==grid[0].length-1)
            return 1;
        if(i>=grid.length || j>=grid[0].length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(grid[i][j]==1)
            return 0;
        int b=f(i+1,j,grid,dp);
        int r=f(i,j+1,grid,dp);
        return dp[i][j]=b+r;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[arr.length-1][arr[0].length-1]==1)
            return 0;
        int dp[][]= new int[arr.length][arr[0].length];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(0,0,arr,dp);
    }
}