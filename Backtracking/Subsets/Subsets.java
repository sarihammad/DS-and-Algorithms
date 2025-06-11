// Backtracking. Add current subset at each recursive call. Explore elements with indices [i + 1, n] to avoid duplicates and set permutations.
public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(0, new ArrayList<>(), nums, res);
		return res;

	}

	private static void backtrack(int start, List<Integer> curr, int[] nums, List<List<Integer>> res) {
		res.add(new ArrayList<>(curr));
		for (int i = start; i < nums.length; i++) {
			curr.add(nums[i]);
			backtrack(i + 1, curr, nums, res);
			curr.remove(curr.size() - 1);
		}
	}
}
