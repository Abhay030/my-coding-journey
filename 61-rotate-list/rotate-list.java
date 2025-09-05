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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        ListNode itr = head;
        int length = 0;
        while(itr != null){
            itr = itr.next;
            length++;
        }

        k = k % length;
        while(k != 0){
            ListNode ptr = head;
            ListNode slow = ptr;
            while(ptr.next != null){
                slow = ptr;
                ptr = ptr.next;
            }
            ptr.next = head;
            slow.next = null;
            head = ptr;
            k--;
        }

        return head;
    }
}