public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        // build the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, graph, visited)) return false;

        return visited.size() == n; // dfs vists all nodes in one call <-> graph is connected
    }
    // need parent for undirected graph to avoid going back and forth
    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return false; // cycle found -> false
        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            if (!dfs(neighbor, node, graph, visited)) return false; // at least one path leads to cycle
        }
        return true; // no path leads to cycle
    }
}
