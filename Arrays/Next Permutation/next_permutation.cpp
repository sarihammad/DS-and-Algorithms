class NextPermutation {
// Scan from right and find first increasing num: first opportunity to make the number bigger. Swap num with smallest larger nimber by scanning from the right again. Since right portion is maximized -> we can reverse it to minimize it after the swap. 
//
// 14532: first increasing: 4, smallest num > 4: 5, swap -> 15432, reverse right portion -> 15234.
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) --i;
        
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) --j;

            swap(nums[j], nums[i]);
        }

        reverse(nums.begin() + i + 1, nums.end());
    }
};
