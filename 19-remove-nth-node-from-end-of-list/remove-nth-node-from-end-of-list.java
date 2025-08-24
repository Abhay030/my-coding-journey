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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        for(int i = 0; i<= n; i++){
            ptr = ptr.next;
        }

        ListNode second = dummy;
        while(ptr != null){
            ptr = ptr.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}