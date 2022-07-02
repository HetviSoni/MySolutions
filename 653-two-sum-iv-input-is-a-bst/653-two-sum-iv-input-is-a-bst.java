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
    static TreeNode isPresent(TreeNode root, int t)
    {
        if(root==null)
            return null;
        if(t<root.val)
            return isPresent(root.left,t);
        if(t>root.val)
            return isPresent(root.right,t);
        else
            return root;
    }
    static boolean h(TreeNode root, int k , TreeNode ini)
    {
        if(root==null)
            return false;
        int a = root.val;
        if(isPresent(ini,k-a)!=null)
        {
            if(isPresent(ini,k-a)!=root)
             return true;
        }
           
        return h(root.left,k,ini)||h(root.right,k,ini);
    }
    public static boolean findTarget(TreeNode root, int k) {
        return h(root,k,root);
    }
}