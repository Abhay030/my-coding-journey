/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node ptr = head;
        // Node contList = null;
        Stack<Node> stack = new Stack<>();
        Node lastNode = null;
        while(ptr != null){
            if(ptr.child != null){
                stack.push(ptr.next);
                ptr.next = ptr.child;
                ptr.next.prev = ptr;
                ptr.child = null;
                ptr = ptr.next;
            }
            else {
                lastNode = ptr;
                ptr = ptr.next;
            }
        }

        while(!stack.isEmpty()){
            Node nextNode = stack.pop();
            if(nextNode != null){
                lastNode.next = nextNode;
                nextNode.prev = lastNode;

                while(nextNode.next != null){
                nextNode = nextNode.next;
                }
                lastNode = nextNode;
            }
        }

        return head;

    }
}