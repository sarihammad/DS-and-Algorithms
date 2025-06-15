// Backtracking: at each step, add unexplored nums to path, add path and return once path length = n.
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), visited);
        return result;
    }
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] visited) {
        int n = nums.length;
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            backtrack(nums, result, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
