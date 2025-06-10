// Multi-source BFS. Queue of all rotten orange coordiantes. Store fresh orange total. Each iteration/minute, rot all non-rotten adjacent oranges, add them to queue to track total rotten. Return total minutes if we've rotten all, else -1.
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int totalFresh = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) totalFresh++;
                else if (grid[r][c] == 2) queue.offer(new int[]{r, c});
            }
        }
        int minutes = 0;
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && totalFresh > 0) {
            minutes++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] currRotten = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = currRotten[0] + dir[0];
                    int newCol = currRotten[1] + dir[1];
                    if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || grid[newRow][newCol] != 1) continue;
                    totalFresh--;
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return totalFresh == 0 ? minutes : -1;
    }
}
