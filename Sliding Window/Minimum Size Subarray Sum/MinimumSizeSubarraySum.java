// Sliding window. expand until it exceeds target, contract until it goes below target, update min size while it's >= k.
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            // while valid window, update min size, contract window
            while (currSum >= target) {
                result = Math.min(result, right - left + 1);
                currSum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
