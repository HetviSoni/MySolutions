class Solution {

    static boolean search(int[][] arr,int t, int i, int j)
    {
        
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length)
            return false;
        if(arr[i][j]==t)
            return true;
        if(t<arr[i][j])
            return search(arr,t,i,j-1);
        else return search(arr,t,i+1,j);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        
        return search(matrix,target,0,matrix[0].length-1);
    }
}