/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    static void f(Node root)
    {
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int s = q.size();
            // System.out.println(s);
            Node prev = q.remove();
            for(int i=0;i<s;i++)
            {
                Node cur = prev;
                if(i==s-1)
                {
                    prev.next=null;
                }
                else
                {
                    Node b = q.remove();
                    prev.next=b;
                    prev = b;
                    // q.add(b);
                }
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
    }
    public Node connect(Node root) {
        if(root==null)
            return null;
        f(root);
        return root;
    }
}