class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Step 1: Base Cases
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;

        // Step 2: Recursive Case
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        // Base Cases
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        
        // Recursive Case
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
