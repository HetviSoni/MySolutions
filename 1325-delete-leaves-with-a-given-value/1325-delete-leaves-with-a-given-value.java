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
    
    static TreeNode delete(TreeNode root, int t)
    {
        if(root==null)
            return root;
        if(root.val==t)
        {
            if(root.right==null && root.left==null)
                return null;
        }
        root.left = delete(root.left,t);
        root.right= delete(root.right,t);
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode ans = new TreeNode();
        for(int i=0;i<3000;i++)
        {
            ans = delete(root,target);
        }
        return ans;
        //1
//       3 3
//      3 2   
        
    }
}