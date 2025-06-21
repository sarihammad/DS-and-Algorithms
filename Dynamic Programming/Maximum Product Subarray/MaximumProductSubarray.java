// DP Kadane's: with negatives, we need to track current max with current min. Next min/max can come from the next num itself or its product with current max/min. Update result at each step.
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currMin = nums[0];
        int currMax = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));
            result = Math.max(result, currMax);
        }

        return result;

    }
}
