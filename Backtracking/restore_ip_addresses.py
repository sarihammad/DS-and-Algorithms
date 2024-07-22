class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        answer = []
        
        def backtrack(curr, start, dots):
            if dots == 4 and start == len(s):
                answer.append(curr[:-1])
                return
            
            for i in range(1, 4): 
                if start + i > len(s):
                    break
                part = s[start:start + i]
                if (part.startswith('0') and len(part) > 1) or (i == 3 and int(part) > 255):
                    continue
                backtrack(curr + part + '.', start + i, dots + 1)
        
        backtrack("", 0, 0)
        return answer

