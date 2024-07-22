    def permute(self, nums: List[int]) -> List[List[int]]:
        answer = []
        def backtrack(curr):
            if len(curr) == len(nums):
                answer.append(curr)
                return
            for i in range(len(nums)):
                if nums[i] in curr:
                    continue
                backtrack(curr + [nums[i]])
        backtrack([])
        return answer

