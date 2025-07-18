/*
makes way more sense when you forget the values and just think of them as variables and their frequencies. Suppose you have something like this:

dd aaa bbbb cc ee

iterate through unique values and start with d considering them as middle elements while calculating left * curr_elemenet_frequency * right. number of left elements initially are 0 since d is smallest, right is n and updates to n - freq[d] to give n - 2. First iteration is 0 * freq[d] * n - freq[d] = 0. Then we increment number of left elements by freq[d]. In english: "there are now 2 elements smaller than this unique middle element, and now 3 less elements to place for the last element." sum all the valid triplets. 
*/
class Solution {
public:
    int unequalTriplets(vector<int>& nums) {
        unordered_map<int, int> counter;
        for (const int& num : nums) ++counter[num];
        int result = 0;
        int left = 0, right = nums.size();
        for (const auto& [num, freq] : counter) {
            right -= freq;
            result += left * freq * right;
            left += freq;
        }

        return result;
    }
};
