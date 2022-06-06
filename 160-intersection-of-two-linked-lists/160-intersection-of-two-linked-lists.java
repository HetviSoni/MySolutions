/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int giveCount(ListNode start)
    {
        ListNode temp = start.next;
        int count=1;
        while(temp!=start)
        {
            temp=temp.next;
            count++;
        }
        return count;
    }
    public int countNodesinLoop(ListNode head)
    {
        //Add your code here.
        if(head==null || head.next==null)
            return 0;
        ListNode p = head;
        ListNode q = head.next;
        while(p!=null && q!=null)
        {
            if(p==q)
                return giveCount(p);
            else{
                p=p.next;
                if(q.next==null)
                    return 0;
                q=q.next.next;
            }
        }
        
        return 0;
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null ||countNodesinLoop(head)==0)
            return null;
        int l = countNodesinLoop(head);
        ListNode f = head;
        ListNode s = head;
        while(l>0)
        {
            s=s.next;
            l--;
        }
        while(f!=s)
        {
            f=f.next;
            s=s.next;
        }
        return s;
            
    }
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a==null || b==null)
            return null;
        ListNode temp=b;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=b;
        ListNode ans=detectCycle(a);
        temp.next=null;
        return ans;

    }
}