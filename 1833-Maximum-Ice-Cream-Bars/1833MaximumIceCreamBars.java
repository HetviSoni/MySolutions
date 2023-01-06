class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int bill=0;
        int count=0;
        while(count<costs.length && bill<coins)
        {
            if(costs[count]+bill<=coins)
            {
                bill+=costs[count];
                count++;
            }
            else break;
        }
        return count;
    }
}
