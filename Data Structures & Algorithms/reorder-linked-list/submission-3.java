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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //use two pointers to split list into half;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null ){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        //slow becomes right half, now reverse list
        ListNode l2 = reverseList(slow);
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode l1 = head;
        boolean turn = true;

        while(l1 != null && l2 != null){
            if(turn){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            turn = !turn;
        }
        current.next = (l1 != null) ? l1 : l2;
        ListNode result = dummy.next;
        head.val = result.val;
        head.next = result.next;
    }
    public ListNode reverseList(ListNode head){
        return reverseListUtil(head,null);
    }
    public ListNode reverseListUtil(ListNode current, ListNode prev){
        if(current == null){
            return prev;
        }
        ListNode next = current.next;
        current.next = prev;
        return reverseListUtil(next,current);
    }
}
