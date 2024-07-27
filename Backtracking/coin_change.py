class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #backtracking
        answer = float('inf')
        def backtrack(curr_amount, coin_count):
            nonlocal answer
            if curr_amount < 0:
                return
            elif curr_amount == 0:
                answer = min(answer, coin_count)
                return
            else:
                for i in range(len(coins)):
                    backtrack(curr_amount - coins[i], coin_count+1)
            

        backtrack(amount, 0)
        return answer if answer != float('inf') else -1
