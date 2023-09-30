//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int arr[][])
    {
        int row[] = new int[arr.length];
        int col[]= new int[arr[0].length];
        for(int i=0;i<row.length;i++)
        {
            for(int j=0;j<col.length;j++)
            {
                if(arr[i][j]==1)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int k=0;k<row.length;k++)
        {
            if(row[k]==1)
            {
                for(int l=0;l<col.length;l++)
                {
                    arr[k][l]=1;
                }
            }
        }
        for(int z=0;z<col.length;z++)
        {
            if(col[z]==1)
            {
                for(int d=0;d<row.length;d++)
                {
                    arr[d][z]=1;
                }
            }
        }
    }
}