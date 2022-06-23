class Solution {
    static class node{
        int i;
        int j;
        int time;
        node(int i, int j , int time)
        {
            this.i=i;
            this.j=j;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<node> q = new LinkedList();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                    q.add(new node(i,j,0));
            }
        }
        int ans=0;
        while(!q.isEmpty())
        {
            node n = q.remove();
            int i=n.i;
            int j=n.j;
            int t=n.time;
            ans=t;
            if(i+1<grid.length)
            {
                if(grid[i+1][j]==1)
                {
                    grid[i+1][j]=2;
                    q.add(new node(i+1,j,t+1));
                }
            }
            if(j+1<grid[0].length)
            {
                if(grid[i][j+1]==1)
                {
                    grid[i][j+1]=2;
                    q.add(new node(i,j+1,t+1));
                }
            }
            if(i-1>=0)
            {
                if(grid[i-1][j]==1)
                {
                    grid[i-1][j]=2;
                    q.add(new node(i-1,j,t+1));
                }
            }
            if(j-1>=0)
            {
                if(grid[i][j-1]==1)
                {
                    grid[i][j-1]=2;
                    q.add(new node(i,j-1,t+1));
                }
            }
            
          }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return ans;
    }
}