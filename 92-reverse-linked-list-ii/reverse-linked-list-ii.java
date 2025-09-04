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
         // iterate till left - 1;
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

    private static ListNode reverseUsingList(ListNode head, int left, int right){
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