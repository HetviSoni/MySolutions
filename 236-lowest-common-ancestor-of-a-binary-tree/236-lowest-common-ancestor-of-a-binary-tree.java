/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static boolean hel(ArrayList<TreeNode> path, int tar,TreeNode root)
    {
        if(root==null)
            return false;
        path.add(root);
        if(root.val==tar)
            return true;
        if(hel(path,tar,root.left)|| hel(path,tar,root.right))
            return true;
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ptoOne= new ArrayList();
        ArrayList<TreeNode> pttwo= new ArrayList();
        boolean one=hel(ptoOne,p.val,root);
        boolean two=hel(pttwo,q.val,root);
        int c=0;
        while(true)
        {
            if(c<Math.min(ptoOne.size(),pttwo.size()) && ptoOne.get(c)==pttwo.get(c))
                c++;
            else break;
        }
        return ptoOne.get(c-1);
    }
}