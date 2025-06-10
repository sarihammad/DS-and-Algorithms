// Backtracking. Use col, row + col, and row - col sets to track used columns and diagonals. For each new row, check if queen can be place in current column by checking col, row + col and row - col sets.
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> results = new ArrayList<>();
		char[][] board = new char[n][n];
		for (char[] row : board) Arrays.fill(row, '.');
		
		backtrack(0, board, results, new HashSet<>(), new HashSet<>(), new HashSet<>());
		return results;
	}

	private void backtrack(int row, char[][] board, List<List<String>> results,
						   Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
		int n = board.length;
		if (row == n) {
			results.add(construct(board));
			return;
		}

		for (int col = 0; col < n; col++) {
			if (cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) {
				continue;
			}

			board[row][col] = 'Q';
			cols.add(col);
			posDiag.add(row + col);
			negDiag.add(row - col);

			backtrack(row + 1, board, results, cols, posDiag, negDiag);

			board[row][col] = '.';
			cols.remove(col);
			posDiag.remove(row + col);
			negDiag.remove(row - col);
		}
	}

	private List<String> construct(char[][] board) {
		List<String> result = new ArrayList<>();
		for (char[] row : board) result.add(new String(row));
		return result;
	}
}
