class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

// Tortoise and Hare: fast and slow pointers. If there's a cycle, fast will eventually meet and outlap slow.
public class LinkedListCycle  {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false; // fast is null: end of list
    }
}
