// Min-heap. Keep track of current min across all lists by using head value as key.
class MergeKSortedLists {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        auto comparator = [](ListNode* a, ListNode* b) { // lambda comparator
            return a->val > b->val; // b before a
        };

        std::priority_queue<ListNode*, std::vector<ListNode*>, decltype(comparator)> minHeap;
        for (const auto& list : lists) {
            if (list) { // not nullptr
                minHeap.push(list);
            }
        }
        ListNode dummy(0);
        ListNode* curr = &dummy;

        while (!minHeap.empty()) {
            ListNode* next = minHeap.top();
            minHeap.pop();
            curr->next = next;
            curr = curr->next;
            if (next->next) {
                minHeap.push(next->next);
            }
        }

        return dummy.next;
    }
};
