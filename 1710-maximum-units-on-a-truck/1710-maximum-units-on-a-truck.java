class Solution {
    public int maximumUnits(int[][] boxTypes, int t) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        // for(int i=0;i<boxTypes.length;i++)
        //     System.out.println(Arrays.toString(boxTypes[i]));
        int rem = t;
        int ans=0;
        
        for(int i=0;i<boxTypes.length;i++)
        {
            if(rem-boxTypes[i][0]<0)
            {
                ans=ans+ rem*boxTypes[i][1];
                break;
            }
            else
            {
                ans = ans+boxTypes[i][0]*boxTypes[i][1];
                rem-=boxTypes[i][0];
            }
        }
        return ans;
    }
}
// 5 10
// 3 9  rem = 2
// 4 7
// 2 5