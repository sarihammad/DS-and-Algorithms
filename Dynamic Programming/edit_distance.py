class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # bottom up
        m, n = len(word1), len(word2)
        dp = [[0] * (n + 1) for i in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = i
        for j in range(n + 1):
            dp[0][j] = j 

        for i in range(m + 1):
            for j in range(n + 1):  
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j] + 1,   # delete
                                   dp[i][j - 1] + 1,   # insert
                                   dp[i - 1][j - 1] + 1)  # substitute

        return dp[m][n]

class Solution:
    # top down
    def minDistance(self, word1: str, word2: str) -> int:
        def dp(i, j, memo={}):
            if i == 0:
                return j
            if j == 0:
                return i
            if word1[i - 1] == word2[j - 1]:
                return dp(i - 1, j - 1)
            return min(dp(i - 1, j, memo) + 1,
                dp(i, j - 1, memo) + 1,
                dp(i - 1, j - 1, memo) + 1)
        m, n = len(word1), len(word2)
        return dp(m, n)

        
        

