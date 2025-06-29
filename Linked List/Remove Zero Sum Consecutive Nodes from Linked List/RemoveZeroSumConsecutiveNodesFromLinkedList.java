// Same prefix sums of nodes => segments in between cancel out to 0. So get the prefix sums of nodes, and update next of current node to the node just after last node with same prefix sum (skipping segments that sum to 0) and repeat until we've removed all 0 sum segments.
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> prefixMap = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // First pass: fill the prefix sum map
        int sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            prefixMap.put(sum, node);
        }

        // Second pass: update pointers from node1 -> node2.next if node1 and node2 have the same prefix sum.
        sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            node.next = prefixMap.get(sum).next;
        }

        return dummy.next;
    }
}
