import heapq
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        distance = {i: float('inf') for i in range(1, n + 1)}
        distance[k] = 0
        graph = {i: [] for i in range(1, n + 1)}

        for u, v, w in times:
            graph[u].append((v, w))

        pq = [(0, k)]
        visited = set()
        
        while pq:
            curr_distance, curr_node = heapq.heappop(pq)
            if curr_node in visited:
                continue
            visited.add(curr_node)
            for neighbor, weight in graph[curr_node]:
                distance_through_curr = curr_distance + weight
                if distance_through_curr < distance[neighbor]:
                    distance[neighbor] = distance_through_curr
                    heapq.heappush(pq, (distance_through_curr, neighbor))
        
        max_distance = max(distance.values())
        return max_distance if max_distance < float('inf') else -1
