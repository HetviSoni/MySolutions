class Solution {
    public boolean checkPossibility(int[] nums) {
        int count =0;
        int check=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1]  )
            {
                if(i==1 && check<1)
                {
                    if(i+1<nums.length)
                    {
                        if(nums[i+1]>=nums[i])
                        {
                          nums[i-1]  =nums[i];
                            check=1;
                            count=0;
                            i=1;
                        }
                        else if(nums[i+1]<nums[i])
                            return false;
                    }
                    
                }
               if(i+1<nums.length && check<1)
               {
                   if(nums[i+1]>=nums[i-1])
                   {
                       nums[i]=nums[i-1];
                       i=1;
                       check=1;
                       count=0;
                   }
                   else if(i-2>=0)
                   {
                      if(nums[i-2]<=nums[i])
                      {
                          nums[i-1]=nums[i];
                          i=1;
                          check=1;
                          count =0;
                      }
                       else return false;
                   }
                   
               }
               count++;
                
             }
                
        }
        if(count>1)
            return false;
        return true;
        
    }
}