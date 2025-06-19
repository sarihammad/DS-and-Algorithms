// BFS level order traversal: traverse tree level by level keeping track of maximum sum seen and its level.
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int result = 1;
        int currLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                levelSum += curr.val;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            if (levelSum > maxSum) result = currLevel;
            maxSum = Math.max(maxSum, levelSum);
            currLevel++; 
        }
        return result;
    }
}
