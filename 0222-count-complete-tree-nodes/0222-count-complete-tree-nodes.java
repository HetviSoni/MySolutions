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
    public int lh(TreeNode root){
        TreeNode a = root;
        int ans=0;
        while(a!=null)
        {
            ans++;
            a=a.left;
        }
        return ans;
    }
    public int rh(TreeNode root){
        TreeNode a = root;
        int ans=0;
        while(a!=null)
        {
            ans++;
            a=a.right;
        }
        return ans;
    }
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int lh = lh(root);
        int rh = rh(root);
        if(lh==rh)
            return (int)Math.pow(2,lh)-1;
        else
            return countNodes(root.left)+countNodes(root.right)+1;
    }
}