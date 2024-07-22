class Solution: 
    def maxSubArray(self, nums: List[int]) -> int:
        def maxHelper(arr, i, j):
            if i == j:
                return (arr[i], arr[i], arr[i], arr[i]) # opt sum, max prefix, max suffix, total sum
            else:
                m = (i + j) // 2

                left = maxHelper(arr, i, m)
                right = maxHelper(arr, m + 1, j)
                return (max(left[0], right[0], left[2] + right[1]), 
                max(left[1], left[3] + right[1]), 
                max(right[2], left[2] + right[3]),
                left[3] + right[3])

        return maxHelper(nums, 0, len(nums) - 1)[0]
