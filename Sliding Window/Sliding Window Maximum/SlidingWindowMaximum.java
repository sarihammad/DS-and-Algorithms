// Deque of indices. Decreasing from front/left to back/right. Pop old idx outside of window from front, pop smaller indices from right side, add new idx to the back, get current window max from front.
public class SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> queue = new ArrayDeque<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (!queue.isEmpty() && queue.peek() <= i - k) {
				queue.poll();
			}

			while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
				queue.pollLast();
			}

			queue.offerLast(i);

			if (i >= k - 1)  {
				result[i - k + 1] = nums[queue.peek()];
			}
		}

		return result;
	}
}
