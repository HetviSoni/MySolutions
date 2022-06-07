class Solution {
    static void flip(int arr[][])
    {
        for(int i=0;i<arr.length/2;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                // arr[i][j]-->arr[n-i-1][j]
                int temp=arr[i][j];
                arr[i][j]=arr[arr.length-i-1][j];
                arr[arr.length-i-1][j]=temp;
            }
        }
    }
    static void transpose(int arr[][])
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        flip(matrix);
        transpose(matrix);
        
    }
}