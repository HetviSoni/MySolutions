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
    static class pair
    {
        TreeNode node;
        int dis;
        pair(TreeNode node, int dis)
        {
            this.node=node;
            this.dis=dis;
        }
    }
        
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root==null)
            return ans;
        Queue<pair> q = new LinkedList();
        Map<Integer, Integer> map= new TreeMap();
        q.add(new pair(root,0));
        while(!q.isEmpty())
        {
            pair p = q.remove();
            // System.out.println(p.node.val+" "+p.dis);
            map.put(p.dis,p.node.val);
            if(p.node.left!=null)
                q.add(new pair(p.node.left,p.dis+1));
            if(p.node.right!=null)
                q.add(new pair(p.node.right,p.dis+1));
            
        }
        for(Map.Entry<Integer, Integer> m:map.entrySet())
        {
            if(m.getKey()>=0)
                ans.add(m.getValue());
        }
        return ans;
    }
}








