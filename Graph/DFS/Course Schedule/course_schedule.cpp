class CourseSchedule {
public:
    // Create a graph where c1 -> c2 denotes c1 is a prereq for c2. A cycle in this graph <=> impossible to complete courses. Kahn's Topological or white grey black DFS. 
    // Runtime: building graph -> O(V + E), DFS -> O(V + E) --> O(V + E) 
    // Space: adjacency list -> O(V + E) --> O(V + E)
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // build graph
        unordered_map<int, vector<int>> graph;
        for (const auto& prereq : prerequisites) {
            graph[prereq[1]].push_back(prereq[0]);
        }        

        vector<int> visited(numCourses, 0);
        for (int course = 0; course < numCourses; ++course) {
            if (hasCycle(graph, course, visited)) return false;
        }

        return true;
    }

private:
    ;
    bool hasCycle(unordered_map<int, vector<int>>& graph, int course, vector<int>& visited) {
        if (visited[course] == 2) return false; // visisted
        if (visited[course] == 1) return true; // visiting

        visited[course] = 1;
        for (int neighbor : graph[course]) {
            if (hasCycle(graph, neighbor, visited)) return true;
        }
        visited[course] = 2;
        return false;
    }

};
