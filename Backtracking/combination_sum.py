class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        answer = []
        
        def backtrack(curr, t, start):
            if t == 0:
                answer.append(curr)
                return
            elif t < 0:
                return
            for i in range(start, len(candidates)):
                backtrack(curr + [candidates[i]], t - candidates[i], i)
        
        backtrack([], target, 0)
        return answer

