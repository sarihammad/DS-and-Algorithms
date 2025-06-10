// Two pointers. Start from boundaries, move smaller height pointer at each step and update max.
public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int max = 0;
		while (left < right) {
			int currArea = Math.min(height[left], height[right]) * (right - left);
			max = Math.max(max, currArea);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}
