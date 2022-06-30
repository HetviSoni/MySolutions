class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr[]= new int[n+m];
        int p = 0, q=0;
        int c = 0;
        while(p<n && q<m)
        {
            if(nums1[p]<nums2[q])
            {
                arr[c]=nums1[p];
                p++;
            }
            else
            {
                arr[c]=nums2[q];
                q++;
            }
            c++;
        }
        while(p<n)
        {
            arr[c]=nums1[p];
            // System.out.println("here "+p);
            p++;
            c++;
        }
        while(q<m)
        {
            arr[c]=nums2[q];
            // System.out.println("here "+q+" "+c);
            q++;
            c++;
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(arr[arr.length/2]+" "+arr[arr.length/2 -1]);
        if(arr.length%2==1)
            return (double)arr[arr.length/2];
        else
            return (double)((double)arr[arr.length/2]+arr[arr.length/2 -1])/(double)2;
    }
    
}