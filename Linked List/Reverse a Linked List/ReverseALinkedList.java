class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

// Keep track of previous node, save next so that when curr's next is updated to prev, we can move to and reverse the next node
public class ReverseALinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next; // save next node
            head.next = prev; // update curr

            // move to the next node
            prev = head;
            head = next;
        }

        // head is at null, prev is at the last node
        return prev;
    }
}
