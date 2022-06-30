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
    static int inOrderSuc(TreeNode root)
    {
        TreeNode temp =root;
        while(temp.left!=null)
        {
            temp=temp.left;
        }
        // System.out.println(temp.val);
        return temp.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(key<root.val)
        {
            root.left=deleteNode(root.left,key);
        }
        else if (key>root.val)
        {
            root.right=deleteNode(root.right,key);
        }
        else{
            if(root.right==null && root.left==null)
                return null;
            if(root.right==null)
                return root.left;
            else if(root.left==null)
                return root.right;
            int a = inOrderSuc(root.right);
            root.val = a;
           root.right= deleteNode(root.right,a);
        }
        return root;
    }
}