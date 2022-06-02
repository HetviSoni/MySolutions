class Solution {
    public int[][] transpose(int[][] matrix) {
        if(matrix.length==matrix[0].length){
        for(int i=0;i<matrix.length-1;i++)
        {
            for(int j=i+1;j<matrix.length;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        return matrix;
        }
        else
        {
            int ans[][]= new int[matrix[0].length][matrix.length];
            for(int i=0;i<ans.length;i++)
            {
                for(int j=0;j<ans[0].length;j++)
                {
                    ans[i][j]=matrix[j][i];
                }
            }
            return ans;
        }
    }
}