class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1)
            return 1;
        if(nums.length==2)
        {
            if(nums[0]!=nums[1])
                return 2;
            else return 1;
        }
        boolean allEq=true;
        for(int u=1;u<nums.length;u++)
        {
            if(nums[u]!=nums[u-1])
                allEq=false;
        }
        if(allEq)
            return 1;
        int dif[] = new int[nums.length-1];
        for(int i=0;i<dif.length;i++)
            dif[i]=nums[i+1]-nums[i];
        // System.out.println(Arrays.toString(dif));
        int count=0;
        //     16 -12  5   3   2   -5 -5  11 -8
        ArrayList<Integer> arr = new ArrayList();
        int a=0;
        while(a<dif.length && dif[a]==0)
        {
            a++;
        }
        arr.add(dif[a]);
        for(int i=a+1;i<dif.length;i++)
        {
            if(arr.get(arr.size()-1)>0)
            {
                if(dif[i]<0)
                {
                     arr.add(dif[i]);
                // System.out.println("added "+dif[i]);
                }
                    
            }
            else if(arr.get(arr.size()-1)<0)
            {
                if(dif[i]>0)
                {
                                        arr.add(dif[i]);
                // System.out.println("added "+dif[i]);

                }
            }
        }
        return arr.size()+1;
    }
}


//  1 7  4  9  2  5
      // 6 -3  5 -7  3

//  1  17  5  10  13  15  10  5  16  8
//     16 -12 5   3   2   -5 -5  11 -8

// 0 0 -1 3