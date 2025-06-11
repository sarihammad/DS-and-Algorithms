// DP. Split overflow between ith glass and i + 1th glass in next row. return dp[query_row][query_glass]
public class ChampagneTower {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] dp = new double[query_row + 2][query_row + 2];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double overflow = dp[i][j] - 1;
                if (overflow > 0) {
                    dp[i + 1][j] += overflow / 2.0;
                    dp[i + 1][j + 1] += overflow / 2.0;
                }
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
	}
}
