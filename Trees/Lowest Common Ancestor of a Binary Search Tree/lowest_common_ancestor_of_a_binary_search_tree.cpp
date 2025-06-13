// LCA splits p and q into separate trees, so check if p and q split into left and right subtrees.
class LowestCommonAncestorOfABinarySearchTree {
private:
	struct TreeNode {
		int val;
		TreeNode* left;
		TreeNode* right;
		TreeNode(int v) : val(v), left(NULL), right(NULL) {}
	};

public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (p->val < root->val && q->val < root->val) return lowestCommonAncestor(root->left, p, q);
        if (p->val > root->val && q->val > root->val) return lowestCommonAncestor(root->right, p, q);
        return root; // nullptr or a successful split
    }	
};
