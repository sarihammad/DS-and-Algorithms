// Backtracking. Add i to path, then consider [i + 1, n] to avoid duplicates and reusing i. Stop at length k.
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(n, k, 1, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(int n, int k, int start, List<Integer> currComb, List<List<Integer>> result) {
		if (currComb.size() == k) {
			result.add(new ArrayList<>(currComb));
			return;
		}

		for (int i = start; i <= n; i++) {
			currComb.add(i);
			backtrack(n, k, i + 1, currComb, result);
			currComb.remove(currComb.size() - 1);
		}
	}
}

