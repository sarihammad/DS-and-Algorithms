// Track the furthest reachable index at each index. if i exceeds this index, impossible to move past i.
public class JumpGame {
	public boolean canJump(int[] nums) {
		int maxReachable = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > maxReachable) return false;
			maxReachable = Math.max(maxReachable, i + nums[i]);
		}
		return true;
	}
}
