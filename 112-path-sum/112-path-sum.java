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
    static boolean f(TreeNode root, int t, int cur)
    {
        cur+=root.val;
        if(root.left==null && root.right==null)
        {
            if(t==cur)
                return true;
        }
        boolean a=false,b=false;
        if(root.left!=null)
            a=f(root.left,t,cur);
        if(root.right!=null)
            b=f(root.right,t,cur);
        if(a || b)
            return true;
        cur-=root.val;
        return false;
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null )
            return false;
            
        return f(root,targetSum,0);
    }
}