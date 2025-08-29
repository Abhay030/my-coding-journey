/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // loop will exit when they intersect or either they both are null.
        while (temp1 != temp2) {
            // traverse the first LL and then second also so ultimately they will travel l1+l2 = l2+l1 which will 
            // be same for both ,  hence they will meet at a common place.
            temp1 = (temp1 != null) ? temp1.next : headB;
            temp2 = (temp2 != null) ? temp2.next : headA;
        }

        return temp1;
    }
}