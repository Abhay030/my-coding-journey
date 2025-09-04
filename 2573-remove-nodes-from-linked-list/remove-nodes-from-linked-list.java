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
    public ListNode removeNodes(ListNode head) {
       return bruteForce(head);
    }

    private static ListNode bruteForce(ListNode head){
         Stack<ListNode> stack = new Stack<>();
        Map<ListNode , Boolean> toRemove = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ptr = head;

        while(ptr != null){
            // pop all smaller Nodes
            while(!stack.isEmpty() && ptr.val > stack.peek().val){
                toRemove.put(stack.pop() , true);
            }
            stack.push(ptr);
            toRemove.put(ptr , false);
            ptr = ptr.next;
        }

        // Remove the marked node
        ListNode itr = dummy;
        while(itr.next != null){
            if(toRemove.get(itr.next)){
                itr.next = itr.next.next;
            }
            else{
                itr = itr.next;
            }
        }

        return dummy.next;

    }
}