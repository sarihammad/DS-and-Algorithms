class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

// Using preorder, first element is always the root. Using inorder, elements to left of root are in the left subtree. Take root from preorder and find it in inorder to divide left and right subtrees, recursing on valid range to build the tree.
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preorderIdx = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        // Step 1: Create the root from the current preorder index
        int rootVal = preorder[preorderIdx++];
        TreeNode root = new TreeNode(rootVal);

        // Step 2: Get root's index in the inorder array from the map
        int rootIdx = inorderMap.get(rootVal);

        // Step 3: Recursively build left and right subtrees and attach to root
        root.left = build(preorder, left, rootIdx - 1);
        root.right = build(preorder, rootIdx + 1, right);

        return root;
    }
}
