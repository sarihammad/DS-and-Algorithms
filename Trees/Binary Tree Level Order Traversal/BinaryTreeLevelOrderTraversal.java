// Use queue to represent nodes at current level. For each level, track current queue/level size,  add node values to the level list and add their non-null children for the next level. Add level list to result.
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currNode = queue.poll();
                level.add(currNode.val);
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            result.add(level);
        }

        return result;
    }
}
