/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static void inOrder(TreeNode root,ArrayList<Integer> arr)
    {
        if(root==null)
            return;
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
        
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr= new ArrayList();
        inOrder(root,arr);
        int ans = 10000000;
        for(int i=1;i<arr.size();i++)
        {
            if(arr.get(i)-arr.get(i-1)<ans)
                ans= arr.get(i)-arr.get(i-1);
        }
        // System.out.println(Arrays.toString(arr.toArray()));
        return ans;
    }
}
