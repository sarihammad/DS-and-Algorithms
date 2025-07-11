class Solutio {
public:
    // bottom-up dp: divide overflow among (curr_row + 1, curr_glass) and (curr_row + 1, curr_glass + 1)
    double champagneTower(int poured, int query_row, int query_glass) {
        vector<vector<double>> dp(query_row + 2, vector<double>(query_row + 2, 0));
        dp[0][0] = poured;
        double overflow;
        for (int i = 0; i <= query_row; ++i) {
            for (int j = 0; j <= i; ++j) {
                overflow = max(dp[i][j] - 1, 0.0);
                dp[i + 1][j] += overflow / 2.0;
                dp[i + 1][j + 1] += overflow / 2.0;
            }
        }

        return min(1.0, dp[query_row][query_glass]);
    }
};
