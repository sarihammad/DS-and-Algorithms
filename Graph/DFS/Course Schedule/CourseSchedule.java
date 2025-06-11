// Cycle detection. DFS or Topological Sort. Nodes for courses, directed edges for prereq -> course. Cycle implies impossible completion: need Course A to finish Course B, also need Course B to finish Course A. Contradiction.
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] prereq : prerequisites) {
			graph.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
		}
		int[] visited = new int[numCourses];
		for (int course = 0; course < numCourses; course++) {
			if (dfsHasCycle(course, graph, visited)) return false;
		}
		return true;
	}
	// white grey black
	public boolean dfsHasCycle(int course, Map<Integer, List<Integer>> graph, int[] visited) {
		if (visited[course] == 1) return true;
		if (visited[course] == 2) return false;
		
		visited[course] = 1; // mark visiting
		for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
			if (dfsHasCycle(neighbor, graph, visited)) return true;
		}
		visited[course] = 2; // mark visited
		return false;
	}
}
