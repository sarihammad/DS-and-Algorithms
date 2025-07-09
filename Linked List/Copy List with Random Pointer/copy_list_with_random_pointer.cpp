// Oif empty, return nullptr. 1st iteration: node -> clone hashmap. 2nd iteration: update copy next and random to og next and random, return copy's head. O(n) time and space.
//
// constant space solution: 1st iteration create copies and add after each curr. 2nd iteration, assign random pointers for copies. 3rd iteration, separate lists with dummy, return dummy->next. O(n) time, O(1) space.
class CopyListWithRandomPointer {
public:
    Node* copyRandomList(Node* head) {
        if (!head) return nullptr;

        // clone nodes and add them next to og
        Node* curr = head;
        while (curr) {
            Node* copy = new Node(curr->val);
            copy->next = curr->next;
            curr->next = copy;
            curr = copy->next;
        }

        // assign random pointers for coipes
        curr = head;
        while (curr) {
            if (curr->random)
                curr->next->random = curr->random->next;
            curr = curr->next->next;
        }

        // separate og and copied lists
        Node* dummy = new Node(0);
        Node* copyPrev = dummy;
        curr = head;

        while (curr) {
            Node* copyCurr = curr->next;
            copyPrev->next = copyCurr;
            copyPrev = copyCurr;

            curr->next = copyCurr->next;
            curr = curr->next;
        }

        return dummy->next;
    }
};

