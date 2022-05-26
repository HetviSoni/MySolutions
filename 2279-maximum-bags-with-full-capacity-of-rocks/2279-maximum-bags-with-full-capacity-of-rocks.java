class Solution {
    
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
       int n=rocks.length;
       int count=0;
       for(int i=0;i<n;i++) 
           rocks[i]=capacity[i]-rocks[i];
       Arrays.sort(rocks);
       for(int i=0;i<n && (rocks[i]-additionalRocks)<=0;i++)
        {
           count++;
            additionalRocks-=rocks[i];
       }
       return count;
    }
}