class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[]= new int[2*n];
        int c2=n;
        int c1=0;
        int c = 0;
        while(c<2*n)
        {
            arr[c] = nums[c1];
            arr[c+1]=nums[c2];
            c=c+2;
            c1++;
            c2++;
        }
        return arr;
    }
}
