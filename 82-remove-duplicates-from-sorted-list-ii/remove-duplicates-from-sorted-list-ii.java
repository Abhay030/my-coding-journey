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
    public ListNode deleteDuplicates(ListNode head) {
        // return usingHashMap(head);
        return usingTwoPointer(head);
    }

    private static ListNode usingHashMap(ListNode head) {
        if (head == null)
            return null;

        Map<Integer, Integer> freq = new HashMap<>();
        ListNode ptr = head;

        // Step 1: store the freq of the elements
        while (ptr != null) {
            freq.put(ptr.val, freq.getOrDefault(ptr.val, 0) + 1);
            ptr = ptr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ptr = head;

        // Step 2: make the unique linked list
        while (ptr != null) {
            if (freq.get(ptr.val) == 1) {
                tail.next = new ListNode(ptr.val);
                tail = tail.next;
            }
            ptr = ptr.next;
        }

        return dummy.next;
    }

    private static ListNode usingTwoPointer(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            // If current node is a duplicate
            if (head.next != null && head.val == head.next.val) {
                int duplicateVal = head.val;
                // Skip all nodes with this value
                while (head != null && head.val == duplicateVal) {
                    head = head.next;
                }
                prev.next = head; // unlink duplicates
            } else {
                prev = prev.next; // move prev only if unique
                head = head.next;
            }
        }

        return dummy.next;
    }
}