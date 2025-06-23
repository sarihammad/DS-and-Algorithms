// Binary Search on minimum and maximum possible answer similar to Capacity To Ship Packages. O(n log(sum(nums)))
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            if (canSplit(nums, k, mid)) { // update right to look for a potentially smaller result
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // left = right = result
    }

    private boolean canSplit(int[] nums, int k, int sum) {
        int count = 1;
        int currSum = 0;
        for (int num : nums) {
            if (currSum + num > sum) { // increment min subarray count and reset curr sum
                currSum = 0;
                count++;
            } 
            currSum += num;
        }
        return count <= k;
    }
}
