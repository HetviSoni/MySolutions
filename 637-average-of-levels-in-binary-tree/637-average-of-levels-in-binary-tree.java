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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<ArrayList<Integer>> nodes = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if(root==null)
            return new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int s = q.size();
            ArrayList<Integer> level = new ArrayList();
            for(int i=0;i<s;i++)
            {
                TreeNode node = q.remove();
                level.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            nodes.add(level);
        }
        List<Double> ans  = new ArrayList();
        for(int i=0;i<nodes.size();i++)      
        {
            long sum=0;
            for(int j=0;j<nodes.get(i).size();j++)
            {
                sum+=(long)nodes.get(i).get(j);
            }
            double d = (double)sum/(double)nodes.get(i).size();
            ans.add(d);
        }
        return ans;
        
        
        
        
        
        
        
        
    }
}