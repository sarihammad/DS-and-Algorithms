class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

// serialize and deserialize with BFS
public class SerializeAndDeserializeBST {
    public String serialize(TreeNode root) {
        if (root == null) return "N";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                sb.append(curr.val).append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                sb.append("N,");
            } 
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("N")) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (!nodes[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;

            if (!nodes[i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}
