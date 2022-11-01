class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean ans=true;
        for(int i=0;i<matrix[0].length;i++)
        {
            int a = Math.min(matrix.length,matrix[0].length-i);
            int req = matrix[0][i];
            int j=i;
            int k=0;
            while(j<i+a && k<a)
            {
                if(matrix[k][j]!=req)
                        ans=false;
                j++;
                k++;
            }
        }
        for(int j=1;j<matrix.length;j++)
        {
            int req = matrix[j][0];
            int a = Math.min(matrix.length-j,matrix[0].length);
            int i=j;
            int k=0;
            while(k<a && i<j+a)
            {
                if(matrix[i][k]!=req)
                {
                    ans=false;
                }
                i++;
                k++;
            }
        }
        return ans;
    }
}