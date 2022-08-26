class Solution {
    static class pair{
        long num;
        int[] freq= new int[10];
        pair(long num)
        {
            this.num=num;
            long n=num;
            while(n>0)
            {
                int a =(int) n%10;
                freq[a]++;
                n=n/10;
            }
        }
    }
    public boolean reorderedPowerOf2(int n) {
        pair[] pows = new pair[31];
        for(int i=0;i<31;i++)
        {
            pows[i] = new pair((long)Math.pow(2,i));
            // System.out.println((long)Math.pow(2,i));
            // System.out.println(Arrays.toString(pows[i].freq));
        }
        int curFreq[]= new int[10];
        while(n>0)
        {
            int a = n%10;
            curFreq[a]++;
            n=n/10;
        }
        // System.out.println(Arrays.toString(curFreq));
        for(int i=0;i<31;i++)
        {
            boolean ans=true;
            for(int j=0;j<10;j++)
            {
                if(pows[i].freq[j]!=curFreq[j])
                    ans=false;
            }
            if(ans)
                return true;
        }
        return false;
    }
}