"""
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
"""

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

