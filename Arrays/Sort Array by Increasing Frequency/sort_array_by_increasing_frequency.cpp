class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        std::unordered_map<int, int> freq;
        for (int num : nums) freq[num]++;

        std::sort(nums.begin(), nums.end(), [&freq](int a, int b) { // freq out of score: capture by reference.
            if (freq[a] != freq[b])	{
                return freq[a] < freq[b]; // lower freq first
            } 
            return b < a; // higher value first
        });

        return nums;
    }
};
