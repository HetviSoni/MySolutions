//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class CreateTree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
            Solution ob = new Solution();
            Node root = ob.createTree(arr, n);
            
            printLevelOrder(root);
            System.out.println();
        }
    }
    
    public static void printList(Node root)
    {
        while(root != null)
        {
            System.out.print(root.data + " ");
        }
    }
    
    public static void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
         for (i=1; i<=h; i++)
        {
        result.clear();
        printGivenLevel(root, i);
        Collections.sort(result);
        for(int j=0;j<result.size();j++)
            System.out.print(result.get(j) + " ");
        }
    }
    
    public static int height(Node root)
    {
        if(root == null)
          return 0;
          
        else
    {

        int lheight = height(root.left);
        int rheight = height(root.right);


        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);
    }
    }
    
    public static void printGivenLevel(Node node, int level)
    {
        if (node == null)
             return;
    if (level == 1)
        result.add(node.data);
    else if (level > 1)
    {
        printGivenLevel(node.left, level-1);
        printGivenLevel(node.right, level-1);
    }
    }
}


// } Driver Code Ends


/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution
{
    static Node root;
    static void createNode(int i, int par[],HashMap<Integer,Node> map )
    {
        if(map.containsKey(i))
            return;
        
        Node cur=new Node(i);
        map.put(i,cur);
        
        if(par[i]==-1)
        {
            root=cur;
            return;
        }
        
        if(!map.containsKey(par[i]))
            createNode(par[i],par,map);
        Node pare=map.get(par[i]);
        if(pare.left==null)
            pare.left=cur;
        else
            pare.right=cur;
            
    }
    public static Node createTree(int parent[], int N)
    {
        //Your code here
        root=null;
        HashMap<Integer,Node> map=new HashMap();
        for(int i=0;i<N;i++)
        {
            createNode(i,parent,map);
        }
        // for(int i=0;i<parent.length;i++)
        // {
        //     //already created
        //     if(map.containsKey(i))    
        //     {
        //         if(parent[i]==-1)
        //             root=map.get(i);
        //         continue;
        //     }else{
                
        //         Node cur=new Node(i);
        //         map.put(i,cur);
        //         if(parent[i]==-1)
        //         {
        //             root=map.get(i);
        //             continue;
        //         }
        //         if(map.containsKey(parent[i]))
        //         {
        //             Node par=map.get(parent[i]);
        //             if(par.left!=null)
        //             {
        //                 par.right=cur;
        //             }else{
        //                 par.left=cur;
        //             }
        //         }else{
        //             Node par=new Node(parent[i]);
        //             map.put(parent[i],par);
        //             par.left=cur;
        //             // if(par.left!=null)
        //             // {
        //             //     par.right=cur;
        //             // }else{
        //             //     par.left=cur;
        //             // }
        //         }
        //         //parent hai ya nahi
        //     }
        // }
        
        return root;
    }
    
}

