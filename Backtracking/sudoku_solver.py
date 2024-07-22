class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        def backtrack(board):            
            for r in range(9):
                for c in range(9):
                    if board[r][c] == ".":
                        for num in range(1, 10):
                            if self.valid_square(board, str(num), r, c):
                                board[r][c] = str(num)
                                if backtrack(board):
                                    return True
                                board[r][c] = "."  # no solution: undo
                        return False  # No valid number: backtrack
            return True  # all cells filled: solution found
        backtrack(board)
    
    def valid_square(self, board, num, r, c):
        valid = True
        square_row_start = (r // 3) * 3
        square_col_start = (c // 3) * 3
        for square_r in range(square_row_start, square_row_start + 3):
            for square_c in range(square_col_start, square_col_start + 3):
                if num == board[square_r][square_c]:
                    return False
        for i in range(9):
            if num == board[r][i] or num == board[i][c]:
                return False
        
        return True

