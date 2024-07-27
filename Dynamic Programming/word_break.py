class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # bottom up
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        
        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break

        return dp[n]

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # top down
        def dp(i, memo={}):
            if i in memo:
                return memo
            if i < 0:
                return True

            for word in wordDict:
                if s[i - len(word) + 1 : i + 1] == word and dp(i - len(word)):
                    return True

            return False
        n = len(s)
        return dp(n - 1)
