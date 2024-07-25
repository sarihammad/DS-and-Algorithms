class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        p = [i for i in range(n)]
        rank = [1] * n

        def find(x):
            while x != p[x]:
                p[x] = p[p[x]]  # path compression
                x = p[x]
            return x

        def union(x, y):
            p1 = find(x)
            p2 = find(y)
            if p1 == p2:
                return 0
            if rank[p2] > rank[p1]:
                p[p1] = p2
                rank[p2] += rank[p1]
            else:
                p[p2] = p1
                rank[p1] += rank[p2]
            return 1

        answer = n
        for x, y in edges:
            answer -= union(x, y)

        return answer
