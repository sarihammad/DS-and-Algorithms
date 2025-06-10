// Prefix and suffix products. First loop, get prefix product by multiplying all numbers before self. Second loop, get suffix product by multiplying all the elements after self.
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
	}
}
