/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static class pair implements Comparable<pair>{
        int li;
        // int di;
        ListNode node;
        pair(int li,  ListNode node)
        {
            this.li=li;
            // this.di=di;
            this.node=node;
        }
        public int compareTo(pair o)
        {
            return this.node.val-o.node.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<pair> pq = new PriorityQueue();
        ListNode ans=new ListNode(0);
        ListNode ln=ans;
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            pq.add(new pair(i,lists[i]));
        }
        while(!pq.isEmpty())
        {
            pair temp=pq.remove();
            ln.next = temp.node;
            ln=ln.next;
            if(temp.node!=null && temp.node.next!=null)
                pq.add(new pair(temp.li,temp.node.next));
            
        }

        return ans.next;
    }
}