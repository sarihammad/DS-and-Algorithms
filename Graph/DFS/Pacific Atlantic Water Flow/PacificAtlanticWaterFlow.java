// DFS from ocean borders. Store atlantic/pacific reachable cells. Return intersection of both reachable sets.
class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacificReachable, r, 0, -1);
            dfs(heights, atlanticReachable, r, cols - 1, -1);
        }
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacificReachable, 0, c, -1);
            dfs(heights, atlanticReachable, rows - 1, c, -1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int r, int c, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || reachable[r][c] || heights[r][c] < prevHeight) return;

        reachable[r][c] = true;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            dfs(heights, reachable, r + dir[0], c + dir[1], heights[r][c]);
        }
    }
}
