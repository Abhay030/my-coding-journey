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
        if(head == null || left == right){
            return head;
        }

        ListNode ptr = head;
        int point = 1;
        while(point != left){
            ptr = ptr.next;
            point++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ptr2 = ptr;
        while(point != right+1){
            list.add(ptr2.val);
            ptr2 = ptr2.next;
            point++;
        }
        System.out.println(list);
        for(int i = list.size()-1; i >= 0; i--){
            ptr.val = list.get(i);
            ptr = ptr.next;
        }
        return head;
    }
}