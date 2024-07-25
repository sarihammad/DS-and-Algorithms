class Solution:
  def alienOrder(self, words: List[str]) -> str:
    # create a graph: node for each letter, 
    # edge for each known ordering (same prefix, different letters at curr index)
    # return topological sort of graph

    # create adj list
    graph = {char: [] for word in words for char in word}
    for i in range(len(words) - 1):
      first = words[i]
      second = words[i+1]
      min_length = min(len(first), len(second))
      for j in range(min_length):
        if first[j] != second[j]:
          graph[first[j]].append(second[j])
          break

    visited = {char: 0 for char in graph} # 0: unvisited, 1: visiting
    answer = []

    # dfs
    def dfs_get_topological_sort(char):
        if visited[char] == 1:
            return
        
        visited[char] = 1
        for neighbor in graph[char]:
            dfs_get_topological_sort(neighbor)

        answer.insert(0, char) 

    # dfs each unvisited node to get the topological sort
    for char in graph:
      if visited[char] == 0:
          dfs_get_topological_sort(char)

    answer = "".join(answer)

    return answer
