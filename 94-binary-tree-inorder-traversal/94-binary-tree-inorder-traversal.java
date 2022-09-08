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
    static void f(List<Integer> ans, TreeNode root)
    {
        if(root==null)
            return;
        f(ans,root.left);
        ans.add(root.val);
        f(ans,root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> s = new ArrayList();
        f(s,root);
        return s;
    }
}