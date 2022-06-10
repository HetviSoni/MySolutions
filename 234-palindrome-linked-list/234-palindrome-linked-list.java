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
    static boolean isOdd(ListNode head)
    {
        int n=0;
        ListNode t = head;
        while(t!=null)
        {
            n++;
            t=t.next;
        }
        if(n%2!=0)
            return true;
        return false;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        
        Stack<ListNode> s = new Stack();
        while(fast!=null)
        {
            s.push(slow);
            slow=slow.next;
            if(fast.next==null)
                break;
            else
                fast=fast.next.next;
        }
        if(isOdd(head))
            s.pop();
        while(slow!=null && s.size()!=0)
        {
            ListNode a = s.pop();
            if(a.val!=slow.val)
                return false;
            slow=slow.next;
        }
        return true;
    }
}