class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        answer = []
        def backtrack(curr, i):
            if len(curr) == k:
                answer.append(curr)
                return
            if i == n:
                return
            backtrack(curr, i+1)
            backtrack(curr + [i+1], i+1)
        backtrack([], 0)
        return answer

