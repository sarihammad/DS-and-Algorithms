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
                return memo[i]
            if i == 0:
                return True
            
            for j in range(i):
                if s[j:i] in wordDict and dp(j, memo):
                    memo[i] = True
                    return True
            
            memo[i] = False
            return False

        n = len(s)
        return dp(n)

