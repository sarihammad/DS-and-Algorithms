// BFS from each graph component. Color curr node then push to queue. Alternate color for neighbors. If a neighbor's color clashes with current color, not 2-colorable -> not bipartite.
// 
class IsGraphBipartite {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        unordered_map<int, int> nodeColors;

        for (int node = 0; node < graph.size(); ++node) {
            if (nodeColors.count(node)) continue;
            queue<int> q;
            q.push(node);
            nodeColors[node] = 0;
            while (!q.empty()) {
                int curr = q.front();
                q.pop();
                for (int neighbor : graph[curr]) {
                    if (!nodeColors.count(neighbor)) {
                        nodeColors[neighbor] = 1 - nodeColors[curr];
                        q.push(neighbor);
                    } else if (nodeColors[neighbor] == nodeColors[curr]) return false;
                }
            }
        }

        return true;
    }
};
