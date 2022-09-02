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
    static class pair{
        int node;
        int dis;
        pair(int node, int dis)
        {
            this.node=node;
            this.dis=dis;
        }
    }
       
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i=0;i<=500;i++)
        {
            graph.add(new ArrayList());
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode n = q.remove();
            int a = n.val;
            // System.out.println(a);
            if(n.left!=null)
            {
                int b = n.left.val;
                graph.get(a).add(b);
                graph.get(b).add(a);
                q.add(n.left);
            }
            if(n.right!=null)
            {
                int b = n.right.val;
                graph.get(a).add(b);
                graph.get(b).add(a);
                q.add(n.right);
            }
        }
        // for(int i=0;i<graph.size();i++)
        // {
        //     System.out.println(graph.get(i).toString());
        // }
        int vis[]=new int [501];
        List<Integer> ans = new ArrayList();
        Queue<pair> qu = new LinkedList();
        qu.add(new pair(target.val,0));
        vis[target.val]=1;
        while(!qu.isEmpty())
        {
            pair p = qu.remove();
            int a = p.node;
            int d = p.dis;
            if(d==k)
                ans.add(a);
            for(int j=0;j<graph.get(a).size();j++)
            {
                if(vis[graph.get(a).get(j)]==0)
                {
                    vis[graph.get(a).get(j)]=1;
                    qu.add(new pair(graph.get(a).get(j),d+1) );
                    // if(d+1==k)
                    //     ans.add(graph.get(a).get(j));
                }
            }
        }
        return ans;
        
    }
}