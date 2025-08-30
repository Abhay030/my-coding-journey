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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null || head == null) return true;
        StringBuilder firsthalf = new StringBuilder();
        ListNode slow = head , fast = head;

        // build the first half
        while(fast != null && fast.next != null){
            firsthalf.append(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        int n = firsthalf.length()-1;

        // compare the second half with reversed first half
        while (slow != null){
            char expected = firsthalf.charAt(n--);
            char actual = (char)(slow.val + '0'); // int to a digital char
            if(expected != actual){
                return false;
            }
            slow = slow.next;
        }        

        return true;

    }
}