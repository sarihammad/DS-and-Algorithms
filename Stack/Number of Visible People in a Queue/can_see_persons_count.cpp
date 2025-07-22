class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        std::vector<int> result(heights.size(), 0);
        std::stack<int> stack;
        for (int i = heights.size() - 1; i >= 0; --i) {
            int count = 0;
            while (!stack.empty() && heights[i] > heights[stack.top()]) {
                ++count; // increment count: shorter -> visible
                stack.pop(); // remove from stack: blocked by current person (for remaining previous people)
            }

            if (!stack.empty()) ++count; // increment count: exists an equal/taller person is in front of current person
            result[i] = count;
            stack.push(i);
        }

        return result;
    }
};
