class Solution {
    
    public int maxScore(int[] card, int k) {
        int sum=0;
        int n=card.length;
        int total=0;
        for(int j=0;j<n;j++)
            total+=card[j];
        for(int i=0;i<n-k;i++)
        {
            sum+=card[i];
        }
        // System.out.println("sum is "+sum);
        int max=sum;
        int c=0;
        for(int i=n-k;i<n;i++)
        {
            // System.out.println("here "+sum);
            sum=sum-card[c] +card[i];
            c++;
            max=Math.min(sum,max);
        }
        return total-max;
    }
}