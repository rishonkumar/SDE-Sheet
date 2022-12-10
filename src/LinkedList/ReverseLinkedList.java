package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode foward = null;
        while (current != null) {
            //move the foward
            foward = current.next;
            //now point current node to prev
            current.next = prev;
            //move prev and current node
            prev = current;
            current = foward;
        }
        return prev;
    }
}
