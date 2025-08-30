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
    //    return solveUsingString(head);
       return solveUsingReverse(head);

    }

    private boolean solveUsingString(ListNode head){
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

    private boolean solveUsingReverse(ListNode head){
        ListNode slow = head , fast = head;

        // find the middle
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half 
        ListNode secondhalf = reverseLL(slow);

        // compare the first half and the second half
        ListNode p1 = head , p2 = secondhalf;
        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private ListNode reverseLL(ListNode head){
        ListNode prev = null , curr = head;

        while(curr != null){
            ListNode agla = curr.next;

            curr.next = prev;
            prev = curr;
            curr = agla;
        }

        return prev;
    }
}