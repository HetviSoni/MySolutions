class Solution {
    public void merge(int[] ans, int m, int[] b, int n) {
        int a[] = new int[m];
        for(int i=0;i<m;i++)
            a[i]=ans[i];
        int p=0,q=0,cur=0;
        while(p<m && q<n)
        {
            if(a[p]<=b[q])
            {
                ans[cur]=a[p];
                p++;
            }
            else
            {
                ans[cur]=b[q];
                q++;
            }
            cur++;
        }
        if(p<m)
        {
            for(int j=cur;j<ans.length;j++)
            {
                ans[j]=a[p];
                p++;
            }
        }
        if(q<n)
        {
            for(int j=cur;j<ans.length;j++)
            {
                ans[j]=b[q];
                q++;
            }
        }
        
    }
}