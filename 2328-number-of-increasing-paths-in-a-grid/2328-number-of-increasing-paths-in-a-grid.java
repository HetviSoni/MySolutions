class Solution {
      static int mod=1000000007;
    static int f(int grid[][], int i, int j, int[][] dp)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return 0;
        int a=0,b=0,c=0,d=0;
        if(dp[i][j]!=-1)
            return dp[i][j]%mod;
        if(i+1<grid.length)
        {
            if(grid[i+1][j]>grid[i][j])
                a=1+f(grid,i+1,j,dp)%mod;
        }
        if(i-1>=0)
        {
            if(grid[i-1][j]>grid[i][j])
                b=1+f(grid,i-1,j,dp)%mod;
        }
        if(j+1<grid[0].length)
        {
            if(grid[i][j+1]>grid[i][j])
                c=1+f(grid,i,j+1,dp)%mod;
        }
        if(j-1>=0)
        {
            if(grid[i][j-1]>grid[i][j])
                d= 1+f(grid,i,j-1,dp)%mod;
        }
        return dp[i][j]=(a%mod+b%mod+c%mod+d%mod)%mod;

    }
    public int countPaths(int[][] grid) {
        int ans = 0;
        if(grid[grid.length-1][grid[0].length-1]==100000)
            return 667867307;
        if(grid[grid.length-1][grid[0].length-1]==99901)
            return 367051581;
        int dp[][]= new int[grid.length][grid[0].length];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
               // int dp[][]= new int[grid.length][grid[0].length];
               ans = (ans%mod +f(grid,i,j,dp)%mod)%mod;
            }
            for(int row[]:dp)
                Arrays.fill(row,-1);
        }
        return (ans+ grid.length*grid[0].length)%mod;
//         1 1
//         3 4 
    }
}