class Solution {
// Need to keep track of acceptable range for each node. root starts at (-inf, +inf), when we go right, it becomes (5, inf) and when we go left it becomes (-inf, 5). Use a recursive helper that tracks valid ranges.
public:
    bool isValidBST(TreeNode* root) {
        return isValidHelper(root, std::numeric_limits<long>::min(), std::numeric_limits<long>::max()); // long to prevent overflow beyond 32-bit ints
    }

private:
    bool isValidHelper(TreeNode* node, long minVal, long maxVal) {
        if (!node) return true;
        if (node->val <= minVal || node->val >= maxVal) return false;
        return isValidHelper(node->left, minVal, node->val) && isValidHelper(node->right, node->val, maxVal);
    }
};
