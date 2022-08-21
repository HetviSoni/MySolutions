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
    static class pair{
        int node;
        int time;
        pair(int node, int time)
        {
            this.node=node;
            this.time=time;
        }
    }
    static int bfs(int i, ArrayList<ArrayList<Integer>> graph, int[] vis)
    {
        vis[i]=1;
        // long count=1l;
        Queue<pair> q = new LinkedList();
        q.add(new pair(i,0));
        int ans = 0;
        while(!q.isEmpty())
        {
            // int n  = q.remove();
            pair p = q.remove();
            int n = p.node;
            int t = p.time;
            ans = Math.max(ans,t);
            for(int d : graph.get(n))
            {
                if(vis[d]==-1)
                {
                    // if(!res.containsKey(d))
                    // {
                        q.add(new pair(d,t+1));
                        vis[d]=1;
                    // }
                }
            }
        }
        return ans;
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root==null)
            return 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i=0;i<=100002;i++)
        {
            graph.add(new ArrayList());
        }
        int vis[]= new int[100002];
        Arrays.fill(vis,-1);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode n = q.remove();
            int a = n.val;
            if(n.left!=null)
            {
                q.add(n.left);
                graph.get(a).add(n.left.val);
                graph.get(n.left.val).add(a);
            }
            if(n.right!=null)
            {
                q.add(n.right);
                graph.get(a).add(n.right.val);
                graph.get(n.right.val).add(a);
            }
        }
        return bfs(start,graph,vis);
        
    }
}




