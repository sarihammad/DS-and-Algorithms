class Solution {
public:
    // Two nodes starting at a dummy, one with a headstart of n + 1. 
    // Move together until headstart node reaches end of list 
    // -> prev lands just before nth node.
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode();
        dummy->next = head;
        ListNode* prev = dummy;
        ListNode* curr = dummy;
        for (int i = 0; i < n + 1; ++i) {
            curr = curr->next;
        }

        while (curr) {
            prev = prev->next;
            curr = curr->next;
        }
        prev->next = prev->next->next;

        return dummy->next;
    } 
};
