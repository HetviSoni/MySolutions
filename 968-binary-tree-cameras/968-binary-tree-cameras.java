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
    static int ans;
    static int f(TreeNode root)
    {
        if(root==null)
            return 1;
        int left=f(root.left);
        int right=f(root.right);
        if(left==-1 || right==-1)
        {
            ans++;
            return 0;
        }
        if(left==0 || right==0)
            return 1;
        return -1;
        
    }
    public int minCameraCover(TreeNode root) {
        ans=0;
        
        if(f(root)==-1)
        {
           
            return ans+1;
        }
       
        return ans;
    }
}