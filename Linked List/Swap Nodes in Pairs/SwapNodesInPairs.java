class ListNode {
	int val;
	ListNode next;
	ListNode(int val) { this.val = val; }
}

// Init a dummy node. keep track of prev, curr and next, update pointers for each of prev, curr and next on each iteration. Idea is we want to build up the list starting from dummy. so init dummy, set prev equal to it, then set its next to head so we can start updating our list.
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            // Step 1: Save the nodes for later access. Now we have prev, first and second initialized.
            ListNode curr = head;
            ListNode next = head.next;

            // Step 2: Update pointers to swap
            prev.next = next;
            curr.next = next.next;
            next.next = curr;

            // Step 3: After successful swap, update prev and head to swap the next pair
            prev = curr;
            head = curr.next;
        }

        return dummy.next;
    }
}
