// Maintain queue for k values. Do inorder traversal, and fill queue and update oldest value if needed.
public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Queue<Integer> result = new LinkedList<>();
	}

	private void inorder(TreeNode root, double target, int k, Queue<Integer> result) {
		if (root == null) return;

		inorder(root.left, target, k, result);

		if (result.size() < k) {
			result.offer(root.val);
		} else { // compare with oldest, check if closer to target
			if (Math.abs(root.val - target) < Math.abs(result.peek() - target)) {
				result.poll();
				result.offer(root.val);
			} else {
				return;
			}
		}

		inorder(root.right, target, k, result);
	}
}
