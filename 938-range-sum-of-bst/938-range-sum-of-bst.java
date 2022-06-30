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
    static int sum(TreeNode root, int low, int high)
    {
        if(root==null)
            return 0;
        int a=0,b=0;
        if(root.val>=low && root.val<=high)
        {
             a= root.val+sum(root.left,low,high);
             b= root.val+sum(root.right,low,high);
        }
        else
        {
            a=sum(root.left,low,high);
            b=sum(root.right,low,high);
        }
        return a+b;
        
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return sum(root,low,high)/2;
    }
}