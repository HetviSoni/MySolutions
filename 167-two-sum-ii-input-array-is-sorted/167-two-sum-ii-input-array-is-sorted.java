class Solution {
    public int[] twoSum(int[] arr, int target) {
        int s=0;
        int e = arr.length-1;
        int ans[]= new int[2];
        while(s<e)
        {
            if (arr[s]+arr[e]>target)
            {
                e=e-1;
            }
            else if(arr[s]+arr[e]<target)
            {
                s=s+1;
            }
            else
            {
                ans[0]=s+1;
                ans[1]=e+1;
                break;
            }
        }
        return ans;
    }
}