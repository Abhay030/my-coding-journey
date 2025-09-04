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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       return reverseUsingRev(head , left , right);
    //    return reverseUsingList(head , left , right);
    }

    private static ListNode reverseUsingRev(ListNode head, int left, int right){
       if (head == null) return null;

        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Reach node before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse sublist from left to right
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prevSub = null;

        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }

        // Step 3: Reconnect parts
        prev.next.next = curr;  // tail of reversed part connects to remaining list
        prev.next = prevSub;    // previous part connects to new head of reversed part

        return dummy.next;
    }

    private static ListNode reverseUsing(ListNode head, int left, int right){
        ListNode prev = head;
        for(int i = 1; i<left; i++){
            prev = prev.next;
        }
        
        // store the values from left to right
        List<Integer> list = new ArrayList<>();
        ListNode ptr = prev;
        for(int i = left; i <= right; i++){
            list.add(ptr.val);
            ptr = ptr.next;
        }

        // update the values from left to right
        for(int i = right-left; i >= 0; i--){
            prev.val = list.get(i);
            prev = prev.next;
        }
        
        return head;
    }
}