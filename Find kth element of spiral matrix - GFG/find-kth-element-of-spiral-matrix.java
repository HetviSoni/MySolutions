//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    static int findK(int A[][], int i, int j,
                     int n, int m, int k)
    {
        if (n < 1 || m < 1)
            return -1;
 
        if (k <= m)
            return A[i + 0][j + k - 1];
 
       
        if (k <= (m + n - 1))
            return A[i + (k - m)][j + m - 1];
 
       
        if (k <= (m + n - 1 + m - 1))
            return A[i + n - 1][j + m - 1 - (k - (m + n - 1))];
 
      
        if (k <= (m + n - 1 + m - 1 + n - 2))
            return A[i + n - 1 - (k - (m + n - 1 + m - 1))][j + 0];
 
       
        return findK(A, i + 1, j + 1, n - 2,
                     m - 2, k - (2 * n + 2 * m - 4));
    }
 
    
    int findK(int A[][], int n, int m, int k)
    {
        return findK(A, 0, 0, n, m, k);

    }
}