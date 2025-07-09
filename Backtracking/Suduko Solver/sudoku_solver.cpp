// Iterate over board, find non-dots and DFS. If a DFS path with curr num leads to a solution, return true. Otherwise backtrack to try the next num. Return false if no solution for current cell, and true once all cells are filled.
class SudokuSolver {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }

private:
    bool solve(vector<vector<char>>& board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') continue;

                for (char c = '1'; c <= '9'; ++c) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (solve(board)) return true; // a DFS path leads to a full board
                        board[i][j] = '.'; // backtrack to try other nums
                    }
                }

                return false; // No valid num for current cell: no solution
            }
        }

        return true; // all cells filled: solved
    }

    bool isValid(vector<vector<char>>& board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
			// check row, col and 3x3 square
            if (board[row][i] == c || board[i][col] == c ||
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
};
