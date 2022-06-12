class Solution {
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
       Arrays.sort(potions);
        
        int ans[]=new int[spells.length];
        for(int i=0;i<ans.length;i++)
        {
            int s=0;
            int a=potions.length;
            int e=potions.length-1;
            while(s<=e)
            {
                int mid = (e-s)/2 +s;
                if((long)spells[i]*(long)potions[mid]>=success)
                {
                    a=mid;
                    e=mid-1;
                }
                else
                {
                    s=mid+1;
                }
            }
            ans[i]=potions.length-a;
        }
        return ans;
    }
}