class Solution {
    static void merge(int arr[], int s, int mid, int e)
    {
        int res[]=new int[e-s+1];
        int p=s;
        int q=mid+1;
        int c=0;
        while(p<=mid && q<=e)
        {
            if(arr[p]<arr[q])
            {
                res[c]=arr[p];
                p++;
            }
            else{
                res[c]=arr[q];
                q++;
            }
            c++;
        }
        while(p<=mid)
        {
            res[c]=arr[p];
            c++;
            p++;
        }
        while(q<=e)
        {
            res[c]=arr[q];
            q++;
            c++;
        }
        int a=0;
        for(int i=s;i<=e;i++)
        {
            arr[i]=res[a];
            a++;
        }
    }
    static void mergeSort(int arr[], int s, int e)
    {
        if(s>=e)
            return;
        int mid=s+(e-s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}