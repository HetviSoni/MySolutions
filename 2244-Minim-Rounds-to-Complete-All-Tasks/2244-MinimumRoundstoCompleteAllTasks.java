class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans=0;
        for(int i=0;i<tasks.length;i++)
        {
            int count=0;
            int cur=tasks[i];
            int p=i;
            while(p<tasks.length && tasks[p]==cur)
            {
                count++;
                p++;
            }
            i=p-1;
            if(count==1)
                return -1;
            else 
            { 
                // System.out.println(count);
                ans+=(int)Math.ceil((double)count/(double)3);
                // System.out.println("adding "+Math.ceil((double)count/(double)3)+" at"+i);
            }
        }
        return ans
        ;
    }
}
// 2 2 2 3 3 4 4 4 4 4
// 2--1
// 3--1
// 4--2
// 5--2
// 6--2
// 7--3
