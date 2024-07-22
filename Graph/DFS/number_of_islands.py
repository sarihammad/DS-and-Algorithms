class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        answer = 0
        visited = set()
        def dfs_visit(r, c):
            if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or (r, c) in visited or grid[r][c] == '0':
                return
            visited.add((r, c))
            dfs_visit(r+1, c)
            dfs_visit(r-1, c)
            dfs_visit(r, c+1)
            dfs_visit(r, c-1)
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == '1' and (r, c) not in visited:
                    dfs_visit(r, c)
                    answer += 1

        return answer

