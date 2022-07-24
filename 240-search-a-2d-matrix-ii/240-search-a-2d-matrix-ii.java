class Solution {
    static boolean binarySearch(int t,int [][] arr,int r)
    {
        int start=0;
        int end=arr[0].length-1;
        while(start<=end)
        {
            int mid=end+(start-end)/2;
            if(arr[r][mid]<t)
                start=mid+1;
            else
                if(arr[r][mid]>t)
                    end=mid-1;
            else if(arr[r][mid]==t)
                return true;
        }
        return false;
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++)
        {
            // System.out.println(i);
            if(binarySearch(target,matrix,i)){
                return true;}
        }
        return false;
    }
}