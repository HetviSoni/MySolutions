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
    static void f(TreeNode root, int val, int dep)
    {
    //         1
    //     2       3
    // 4
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int cur=1;
        while(!q.isEmpty())
        {
            int s = q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode n = q.remove();
                if(n.left!=null)
                        q.add(n.left);
                if(n.right!=null)
                        q.add(n.right);
                if(cur==dep-1)
                {
                    if(n.left!=null)
                    {
                        TreeNode actualLeft=n.left;
                        n.left=new TreeNode(val);
                        n.left.left = actualLeft;
                    }
                    else
                        n.left=new TreeNode(val);
                    if(n.right!=null)
                    {
                        TreeNode actualRight = n.right;
                        n.right = new TreeNode(val);
                        n.right.right=actualRight;
                    }
                    else
                        n.right=new TreeNode(val);
                }
                
            
            }
            cur++;
        }
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode n = new TreeNode(val);
            n.left=root;
            return n;
            
        }
        else{
            f(root,val,depth);
        return root;
        }
        
    }
}