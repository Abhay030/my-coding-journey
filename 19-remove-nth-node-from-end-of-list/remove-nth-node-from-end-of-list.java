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
        // creating the dummy node.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy; // ptr to stand at nth node from the start.

        // move ptr to the nth node from start.
        for(int i = 0; i <= n; i++){
            ptr = ptr.next;
        }

        // seconf ptr to move to the nth from end.
        ListNode second = dummy;
        // move ptr and second to put second ptr t the nth from the end.
        while(ptr != null){
            ptr = ptr.next;
            second = second.next;
        }
        // remove the nth node.
        second.next = second.next.next;
        return dummy.next;
    }
}