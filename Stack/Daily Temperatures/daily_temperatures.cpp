class Solution {
public:
    // store indices in a monotonic decreasing stack. stack represent unassigned element indices that have not found a greater temperature yet.
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        std::vector<int> result(temperatures.size(), 0);
        std::stack<int> stack;
        // iterate over all temperatures, keep popping from stack to assign previous smaller temperatures with current temperature index - old index to represent number of days needed.
        for (int i = 0; i < temperatures.size(); ++i) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.top()]) {
                // pop the top of the stack
                int currIdx = stack.top();
                stack.pop();
                // update result
                result[currIdx] = i - currIdx;
            }
            stack.push(i);
        }

        return result;
    }
};
