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
    static class node{
        TreeNode node;
        int ver;
        int hor;
        node(TreeNode node, int ver, int hor)
        {
            this.node= node;
            this.ver= ver;
            this.hor= hor;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap();
        Queue<node> q= new LinkedList();
        q.add(new node(root,0,0));
        while(!q.isEmpty())
        {
            node n = q.remove();
            int h= n.ver;
            int v = n.hor;
            if (!map.containsKey(v)) {
                map.put(v, new TreeMap < > ());
            }
            if (!map.get(v).containsKey(h)) {
                map.get(v).put(h, new PriorityQueue < > ());
            }
            map.get(v).get(h).offer(n.node.val);
            // map.put(v,new TreeMap<>());
            // map.get(v).put(h,new PriorityQueue<Integer>());
            // map.get(v).get(h).add(n.node.val);
            if(n.node.left!=null)
                q.add(new node(n.node.left,h+1,v-1));
            if(n.node.right!=null)
                q.add(new node(n.node.right, h+1, v+1));
            
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}





