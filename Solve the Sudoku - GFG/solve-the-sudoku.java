//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku.
    static boolean canPut(int x, int i, int j, int arr[][])
    {
        for(int k=0;k<9;k++)
        {
            if(arr[i][k]==x || arr[k][j]==x)
                return false;
        }
        int z=i/3;
        int y=j/3;
        z=z*3;
        y=y*3;
        for(int o=z;o<z+3;o++)
        {
            for(int p=y;p<y+3;p++)
            {
                if(arr[o][p]==x)
                    return false;
            }
        }
        return true;
    }
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int row=-1;
        int col=-1;
        boolean filled=true;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(grid[i][j]==0){
                    row=i;
                    col=j;
                    filled=false;
                    break;
                }
            }
            if(!filled)
                break;
        }
        if(filled)
            return true;
        for(int i=1;i<=9;i++)
        {
            
            if(canPut(i,row,col,grid))
            {
                grid[row][col]=i;
                if(SolveSudoku(grid)){
                    // printGrid(grid);
                    return true;}
                else
                    grid[row][col]=0;
            }
        }
            
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        // System.out.println("here");
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}