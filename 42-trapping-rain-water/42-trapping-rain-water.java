class Solution {
    public int trap(int[] height) {
        int arr[][]= new int[2][height.length];
        ArrayList<ArrayList<Integer>> mm = new ArrayList();
        int ml=0;
        for(int i=0;i<height.length;i++)
        {
            int a = height[i];
            arr[0][i]=Math.max(ml,a);
            ml=Math.max(arr[0][i],ml);
        }
        int mr=0;
        for(int j=height.length-1;j>=0;j--)
        {
            arr[1][j] = Math.max(mr,height[j]);
            mr=Math.max(arr[1][j],mr);
        }
        // for(int k=0;k<2;k++)
        // {
        //     for(int l=0;l<height.length;l++)
        //         System.out.print(arr[k][l]+" ");
        //     System.out.println();
        // }
        
        int c = 0;
        // for(int k=)
        for(int y=0;y<height.length;y++)
        {
            c+=Math.min(arr[0][y],arr[1][y])-height[y];
        }
        return c;
    }
}