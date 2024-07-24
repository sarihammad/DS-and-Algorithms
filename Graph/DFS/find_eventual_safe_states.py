class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        def dfs_has_cycle(node):
            if visited[node] != 0:
                return visited[node] == 1  # already visited
            
            visited[node] = 1  # visited
            for neighbor in graph[node]:
                if dfs_has_cycle(neighbor):
                    return True
            
            visited[node] = 2  # safe
            return False

        n = len(graph)
        visited = [0] * n  # 0: unvisited, 1: visited, 2: safe
        safe_nodes = []

        for node in range(n):
            if not dfs_has_cycle(node):
                safe_nodes.append(node)

        return safe_nodes

