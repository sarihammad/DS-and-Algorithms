
// DP. Store total points obtained by picking each number. Similar to house robber: take the point or skip it. take[i] = skip[i - 1] + points[i] and skip[i] = max{skip[i - 1], take[i - 1]}. Optimize space by storing last skip and take values.
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        int[] points = new int[max + 1];

        for (int num : nums) points[num] += num;
        
        int currTake = 0;
        int currSkip = 0;
        for (int i = 1; i < points.length; i++) {
            int newTake = currSkip + points[i];
            int newSkip = Math.max(currSkip, currTake);
            currTake = newTake;
            currSkip = newSkip;
        }
        return Math.max(currTake, currSkip);
    }
}
