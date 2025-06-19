// Sliding Window: for each right window value, shrink from left until product < k to find all maximum windows ending at current right index. the number of subarrays at each window is its size: right - left + 1.
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int currProduct = 1;
        int left = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++) {
            currProduct *= nums[right];
            while (currProduct >= k) {
                currProduct /= nums[left];
                left++;
            }
            result += right - left + 1; // number of subarrays is the window size (window[:1], ..., window[:n] all valid)
        }
        return result;
    }
}
