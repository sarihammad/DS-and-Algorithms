class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # bottom up
        n = len(nums)
        dp = [1] * n
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        
        return max(dp)


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # O(nlogn) solution (intuition: log n -> binary search. We can get the LIS by 
        # minimizing the last element of the current subseqeuence. We use
        # binary search to figure out where to place the current element in our 
        # subseqeunce (note: clear this subseqeunce is always increasing). 
        # if it's larger than all elements, we append. otherwise, add 
        # it to the correct idx found using binary search on the subsequence.
        def binary_search(arr, num, start, end):
            if start <= end:
                m = (end + start) // 2
                if num == arr[m]:
                    return m
                elif num < arr[m]:
                    return binary_search(arr, num, start, m - 1)
                else:
                    return binary_search(arr, num, m + 1, end)
            
            return start
            

        sub = []
        for i in range(len(nums)):
            idx = binary_search(sub, nums[i], 0, len(sub) - 1)
            if idx == len(sub):
                sub.append(nums[i])
            else:
                sub[idx] = nums[i]
        return len(sub)

        
        




        
