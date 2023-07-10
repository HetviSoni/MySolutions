//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    static class DSU{
        ArrayList<Integer> parent;
        ArrayList<Integer> size;
        DSU(int n)
        {
            this.parent=new ArrayList();
            this.size = new ArrayList();
            for(int i=0;i<=n;i++)
            {
                parent.add(i);
                size.add(1);
            }
        }
        int findPar(int x)
        {
            if(parent.get(x)==x)
                return x;
            int up = findPar(parent.get(x));
            parent.set(x,up);
            return parent.get(x);
        }
        void union(int x, int y)
        {
            int px = findPar(x);
            int py = findPar(y);
            if(px==py)
                return;
            if(size.get(px)>size.get(py))
            {
                size.set(px,size.get(px)+size.get(py));
                parent.set(py,px);
            }
            else{
                size.set(py,size.get(px)+size.get(py));
                parent.set(px,py);
            }
        }
    }
    public int Solve(int n, int[][] edge) {
        // Code here
        DSU dsu = new DSU(n);
        int c=0;
        for(int i=0;i<edge.length;i++)
        {
            int a = edge[i][0];
            int b = edge[i][1];
            if(dsu.findPar(a)==dsu.findPar(b))
            {
                c++;
            }
            else{
                dsu.union(a,b);
            }
        }
        int available=0;
        for(int i=0;i<n;i++)
        {
            if(dsu.parent.get(i)==i)
                available++;
        }
        int ans=available-1;
        if(c>=ans)
            return ans;
        return -1;
    }
}