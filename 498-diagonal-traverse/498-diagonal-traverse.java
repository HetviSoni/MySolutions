class Solution {
    static int[] diagonallyUp(int i, int j, int arr[], int cur, int mat[][])
    {
        arr[cur]=mat[i][j];
        cur++;
        int p=i-1,q=j+1;
        while(p>=0 && q<mat[0].length)
        {
            arr[cur]=mat[p][q];
            p--;
            q++;
            cur++;
        }
        int res[]={p+1,q-1,cur};
        return res;
        
    }
    static int[] diagonallyDown(int i, int j , int arr[], int cur, int mat[][])
    {
        arr[cur]=mat[i][j];
        cur++;
        int p=i+1;
        int q = j-1;
        while(p<mat.length && q>=0)
        {
            arr[cur]=mat[p][q];
            p++;
            q--;
            cur++;
        }
        int res[]= {p-1,q+1,cur};
        return res;
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int ans[]= new int[m*n];
        int temp[]=diagonallyUp(0,0,ans,0,mat);
        boolean goUp=false;
        for(int i=1;i<m+n-1;i++)
        {
            int row=temp[0];
            int col=temp[1];
            int c=temp[2];
            if(!goUp){
            if(col+1<n)
                temp=diagonallyDown(row,col+1,ans,c,mat);
            else
                temp=diagonallyDown(row+1,col,ans,c,mat);
            // System.out.println(Arrays.toString(ans));
            }
            else
            {
                if(row+1<mat.length)
                    temp=diagonallyUp(row+1,col,ans,c,mat);
                else
                    temp=diagonallyUp(row,col+1,ans,c,mat);
            }
            // System.out.println(Arrays.toString(temp));
            goUp=!goUp;
        }
        
        return ans;
    }
}

