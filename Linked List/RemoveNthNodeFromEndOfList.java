class ListNode {
	int val;
	ListNode next;
	ListNode(int val) { this.val = val; }
}

// Use dummy to handle edges cases like deleting head. Initialize two pointers first and second at dummy. Move second n + 1 steps to have a headstart, while first starts at head. Then have move both pointers at the same pace until second reaches the end. First will land just before the node we want to delete: update first.next to first.next.next to remove the target node.
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            second = second.next;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
 
}
