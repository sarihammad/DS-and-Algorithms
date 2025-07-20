// reverse the list, double each digit % 10, handle carry. If carry on last node, add carry and exit.

// Walkthrough: 1 -> 2 -> 3 becomes 3 -> 2 -> 1 then double each digit: 6 -> 4 -> 2 then reverse it again to get 2 -> 4 -> 6. 
class Solution {
public:
    ListNode* doubleIt(ListNode* head) {
        ListNode* reversedHead = reverseList(head);
        ListNode* curr = reversedHead;
        int carry = 0;

        while (curr) {
            int sum = 2 * curr->val + carry;
            curr->val = sum % 10;
            carry = sum / 10;   
            if (!curr->next && carry) {
                curr->next = new ListNode(carry);
                break;
            }
            curr = curr->next;
        }

        return reverseList(reversedHead);

    }
private:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        while (head) {
            ListNode* next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
};
