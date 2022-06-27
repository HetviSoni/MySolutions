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
    static int min(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh = min(root.left);
        int rh = min(root.right);
        if((root.left==null && root.right!=null) || (root.right==null && root.left!=null))
            return 1+Math.max(lh,rh);
        return 1+Math.min(lh,rh);
    }
    public int minDepth(TreeNode root) {
        return min(root);
    }
}