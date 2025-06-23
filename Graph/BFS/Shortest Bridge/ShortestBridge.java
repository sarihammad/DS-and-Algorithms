// DFS first island and add all its coordinates (or borders) to queue. Then BFS on the queue keeping track of explored levels and return number of levels once we touch the second island.
public class ShortestBridge {
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false; // to break out of dfs
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        // BFS: empty out queue and increment result for every level, add all unvisited cells (marked 0) to queue, and if next cell is 1 (part of second island) return result.
        int result = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] currCell = queue.poll();
                for (int[] dir : dirs) {
                    int x = currCell[0] + dir[0];
                    int y = currCell[1] + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    switch (grid[x][y]) {
                        case 1:
                            return result;
                        case 0:
                            grid[x][y] = -1;
                            queue.offer(new int[]{x, y});
                            break;
                        
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        queue.add(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], queue);
        }
    }
}
