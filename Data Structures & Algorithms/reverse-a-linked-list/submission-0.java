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
    public ListNode reverseList(ListNode head) {
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
