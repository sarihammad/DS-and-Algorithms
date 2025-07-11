class CloneGraph {
public:
    Node* cloneGraph(Node* node) {
        if (!node) return nullptr;
        if (clones.count(node)) return clones[node]; // if copy exists, return it

        // create and save copy
        Node* newNode = new Node(node->val);
        clones[node] = newNode;

        // update copy's neighbors to be the neighbor's clones recursively
        for (auto neighbor : node->neighbors) {
            newNode->neighbors.push_back(cloneGraph(neighbor));
        }

        return newNode;
    }
private:
    unordered_map<Node*, Node*> clones;
};
