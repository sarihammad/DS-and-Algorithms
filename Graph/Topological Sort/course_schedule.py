class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # return True if exists valid topological sort: no directed cycles

        # create adj list
        graph = {course: [] for course in range(numCourses)}
        visited = {course: 0 for course in range(numCourses)} # 0: unvisited, 1: visiting, 2: visited
        for prereq in prerequisites:
            graph[prereq[1]].append(prereq[0])
        
        def dfs_has_cycle(node):
            if visited[node] != 0:
                return visited[node] == 1  # visiting -> has cycle
            
            visited[node] = 1  # mark as visiting
            for neighbor in graph[node]:
                if dfs_has_cycle(neighbor): # if any of the neighbors is visiting -> there is a cycle
                    return True
            
            visited[node] = 2  # done visiting. mark visited
            return False # dfs done, never found a visiting node -> no cycle
        
        for course in range(numCourses):
            if dfs_has_cycle(course):
                return False

        return True
        

O

