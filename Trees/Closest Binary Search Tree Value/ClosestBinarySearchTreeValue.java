// Go in the direction of target as if searching for it, while updating the closest value.
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, int target) {
		int closest = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < Math.abs(closest - target)) {
				closest = root.val;
			}
			root = (target < root.val) ? root.left : root.right;
		}
		return closest;
	}
}
