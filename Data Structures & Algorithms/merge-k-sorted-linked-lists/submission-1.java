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
// 1,2,4 and 1,3,5 -> 1,2,3,4,5
// 1,2 and 1,2,3,4 -> 1,1,2,2,3,4
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        for(int i=1;i<lists.length;i++){
            ListNode merged = mergeTwoLists(lists[i],lists[i-1]);
            lists[i] = merged;
        }
        return lists[lists.length-1];
    }
    public ListNode mergeTwoLists(ListNode first,ListNode second){
        if(first == null) return second;
        if(second == null) return first;
        ListNode dummy = new ListNode();
        dummy.next = (first.val > second.val) ? second : first;
        ListNode merged = dummy;
        while(first != null && second != null){
            if(first.val < second.val){
                merged.next = first;
                first = first.next;
            }
            else {
                merged.next = second;
                second = second.next;
            }
            merged = merged.next;
        }
        merged.next = (first != null) ? first : second;
        return dummy.next;
    }
}
