// backtracking: track number of open and closed parenthesis. keep closed <= open and open <= n. add when string length reaches 2*n.
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backtrack(n, result, "", 0, 0);
		return result;

	}	

	private void backtrack(int n, List<String> result, String curr, int open, int closed) {
		if (curr.length() == 2 * n) {
			result.add(curr);
			return;
		}
		if (open > closed) {
			backtrack(n, result, curr + ")", open, closed + 1);
		}
		if (open < n) {
			backtrack(n, result, curr + "(", open + 1, closed);
		}

		return;
	}
}
