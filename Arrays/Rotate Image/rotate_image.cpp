class RotateImage {
public:
    // take the transpose and reverse each row: swap lower-left triangle elements with upper-right triangle elements, then reverse each row.
    void rotate(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                std::swap(matrix[i][j], matrix[j][i]);
            }
        }

        for (auto& row : matrix) reverse(row.begin(), row.end());
    }
};
