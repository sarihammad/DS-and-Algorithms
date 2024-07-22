class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        answer = []
        def backtrack(curr, cols, rdig, ldig, r):
            if r == n:
                answer.append(curr)
                return
            for c in range(n):
                row = ["."] * n
                row[c] = 'Q'
                row = "".join(row)
                if c in cols or r-c in rdig or r+c in ldig:
                    continue
                backtrack(curr + [row], cols + [c], rdig + [r-c], ldig + [r+c], r+1)
        
        backtrack([], [], [], [], 0)
        return answer

