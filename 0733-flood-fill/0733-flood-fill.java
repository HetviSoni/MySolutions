class Solution {
    static void fill(int[][] image, int i, int j, int color, int cur, int vis[][])
    {
        image[i][j]=color;
        vis[i][j]=1;
        // 1 1 1
        // 1 1 0
        // 1 0 1
        if(i-1>=0 && image[i-1][j]==cur && vis[i-1][j]==0)
            fill(image,i-1,j,color,cur,vis);
        if(j-1>=0 && image[i][j-1]==cur && vis[i][j-1]==0)
            fill(image,i,j-1,color,cur,vis);
        if(i+1<image.length && image[i+1][j]==cur && vis[i+1][j]==0)
            fill(image,i+1,j,color,cur,vis);
        if(j+1<image[0].length && image[i][j+1]==cur && vis[i][j+1]==0)
            fill(image,i,j+1,color,cur,vis);
            
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int vis[][]= new int[image.length][image[0].length];
        fill(image,sr,sc,color,image[sr][sc], vis);
        return image;
    }
}