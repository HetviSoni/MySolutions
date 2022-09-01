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
    static int gn(TreeNode root, int max)
    {
        if(root==null)
            return 0;
        if(root.val>=max)
        {
            return 1+ gn(root.left,root.val)+gn(root.right,root.val);
        }
        else
            return gn(root.left,max)+gn(root.right,max);
    }
    public int goodNodes(TreeNode root) {
       return gn(root,root.val);
    }
}