class Solution {
    static boolean isPossible(int piles[], int mid,int h)
    {
        int req = 0;
        for(int i=0;i<piles.length;i++)
        {
            req+=Math.ceil((double)piles[i]/(double)mid);
            
        }
        if(req<=h)
            return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length-1];
        int ans=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isPossible(piles,mid,h))
            {
                ans=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return ans;
        
    }
}
// 3+11 /2 =  14/2=7