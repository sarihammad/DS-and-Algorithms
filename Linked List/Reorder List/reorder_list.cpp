struct ListNode {
	int val;
    ListNode* next;
    ListNode(int x) : val(x) {}
}

// Cut two halves, reverse second half, merge them: first1 -> second1 -> first2 -> second2 -> ...
class ReorderList {
public:
	void reorderList(ListNode* head) {
        if (!head || !head->next || !head->next->next) return; // len <= 2 no changes

        //Step 1: Find nodes just after middle
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        //Step 2: Reverse second half after niddle node
        ListNode* prev = nullptr;
        ListNode* curr = slow->next;
        while (curr) {
            ListNode* tmp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = tmp;
        }

        //Step 3: Cut off both lists
        slow->next = nullptr;

        //Step 4: Merge two lists
        ListNode* first = head;
        ListNode* second = prev;
        while (second) {
            ListNode* tmp1 = first->next;
            ListNode* tmp2 = second->next;
            first->next = second;
            second->next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
};
