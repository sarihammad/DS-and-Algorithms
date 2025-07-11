class PacificAtlanticWaterFlow {
public:
    // DFS from the ocean borders only moving to higher cells. Any encountered cell is reachable from that ocean.
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int rows = heights.size(), cols = heights[0].size();
        vector<vector<int>> result;
        vector<vector<bool>> atlanticReachable(rows, vector<bool>(cols, false));
        vector<vector<bool>> pacificReachable(rows, vector<bool>(cols, false));
        for (int r = 0; r < rows; ++r) {
            dfs(heights, r, 0, INT_MIN, pacificReachable);
            dfs(heights, r, cols - 1, INT_MIN, atlanticReachable);
        }

        for (int c = 0; c < cols; ++c) {
            dfs(heights, 0, c, INT_MIN, pacificReachable);
            dfs(heights, rows - 1, c, INT_MIN, atlanticReachable);
        }

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (atlanticReachable[r][c] && pacificReachable[r][c]) result.push_back({r, c});
            }
        }

        return result;
    }
private:
    vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    void dfs(vector<vector<int>>& heights, int r, int c, int prevHeight, vector<vector<bool>>& reachable) {
        int rows = heights.size(), cols = heights[0].size();
        if (r < 0 || c < 0 || r >= rows || c >= cols || heights[r][c] < prevHeight || reachable[r][c]) return;

        reachable[r][c] = true;
        for (const auto& dir : dirs) dfs(heights, r + dir[0], c + dir[1], heights[r][c], reachable);
    }
};
