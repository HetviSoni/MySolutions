class Solution {
    static int f(int i, int j, int arr[][], int n, int dp[][])
    {
        if(i==n)
        {
            return arr[i][j];
        }
        int cd=0,cg=0;
        if(dp[i+1][j]!=-1)
        {
            cd=arr[i][j]+dp[i+1][j];
        }
        else
            cd = arr[i][j]+f(i+1,j,arr,n,dp);
        if(dp[i+1][j+1]!=-1)
            cg=arr[i][j]+dp[i+1][j+1];
        else
            cg = arr[i][j]+f(i+1, j+1,arr,n,dp);
        return dp[i][j]=Math.min(cd,cg);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n =triangle.size();
        int arr[][]= new int[n][n];
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                arr[i][j]=triangle.get(i).get(j);
                dp[i][j]=-1;
            }
        }
        
        return f(0,0,arr,n-1,dp);
    }
}