from collections import deque
class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        colors = [0] * n  # 2-colorable. 0: uncolored, -1, 1: colors

        for i in range(n):
            if colors[i] == 0: 
                queue = deque([i])
                colors[i] = 1 

                while queue:
                    node = queue.popleft()
                    for neighbor in graph[node]:
                        if colors[neighbor] == 0: 
                            colors[neighbor] = colors[node] * -1  # change color
                            queue.append(neighbor)
                        elif colors[neighbor] == colors[node]:
                            return False 

        return True
            
