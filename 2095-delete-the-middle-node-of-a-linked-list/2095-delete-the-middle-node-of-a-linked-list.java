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
    static ListNode findMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null )
        {
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)
            return null;
        ListNode middle = findMiddle(head);
        int a = middle.val;
        ListNode cur = head;
        while(cur.next!=null)
        {
            if(cur.next==middle)
            {
                 cur.next=cur.next.next;
                 break;
            }
            else
                cur=cur.next;
        }
        return head;
    }
}