class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int val) { this.val = val; }
}
// recursively compare q.left with p.left and q.right with p.right
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true; // both null
		if (p == null || q == null) return false; // one of them is null
		if (p.val != q.val) return false; // values don't match

		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}
}
