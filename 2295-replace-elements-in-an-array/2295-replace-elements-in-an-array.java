// import java.util.List;
// import com.google.common.primitives.Ints;
class Solution {
   
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map= new HashMap();
        for(int j=0;j<nums.length;j++)
            map.put(nums[j],j);
        for(int i=0;i<operations.length;i++)
        {
            int a=operations[i][0];
            int b=operations[i][1];
            nums[map.get(a)]=b;
            map.put(b,map.get(a));
            
        }
        return nums;
    }
}