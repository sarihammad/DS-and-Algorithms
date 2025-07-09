// DFS from grid if letter matches first letter of word, return true if any dfs path reaches index = len(word)
class WordSearch {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(), n = board[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

private:
    // vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static constexpr int dirs[4][2] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    bool dfs(vector<vector<char>>& board, int i, int j, int idx, string word) {
        int m = board.size(), n = board[0].size();
        if (idx == word.size()) return true;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word[idx]) return false;

        char ch = board[i][j];
        board[i][j] = '#'; // mark visited
        for (const auto& dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], idx + 1, word)) return true;
        }
        board[i][j] = ch;
        return false;
    }
};
