//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
   static class BstNode{
        public int min;
        public int max;
        public boolean isBst;
        public Node lbst;
        public int size;
        BstNode(){
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.isBst  = false;
            this.lbst = null;
            size=0;

        }

    }
    static BstNode f(Node root)
    {
        if(root==null){
            BstNode cur = new BstNode();
            cur.max = Integer.MIN_VALUE;
            cur.min = Integer.MAX_VALUE;
            cur.isBst = true;
            cur.size = 0;
            cur.lbst=null;
            return cur;
        }
        BstNode l = f(root.left);
        BstNode r = f(root.right);
        BstNode cur = new BstNode();
        cur.min = Math.min(root.data,Math.min(l.min,r.min));
        cur.max = Math.max(root.data,Math.max(l.max,r.max));
        cur.isBst = l.isBst && r.isBst && (root.data>l.max && root.data<r.min);
        if(cur.isBst)
        {
            cur.lbst = root;
            cur.size = 1 + l.size+r.size;
        }else if(l.size>r.size){
            cur.lbst = l.lbst;
            cur.size = l.size;
        }
        else{
            cur.lbst = r.lbst;
            cur.size = r.size;
        }
        return cur;
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        BstNode cur = f(root);
        return cur.size;


    }

}