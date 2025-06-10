// Heap. Maintain size k max heap with distances (or squared distances) as keys. All n - k bigger points get extracted, k closest remain in heap. 
public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		int[][] result = new int[k][];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (distanceSquared(b) - distanceSquared(a)));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
	}

	private int distanceSquared(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}
// Max heap size is k, n heap operations -> O(n log k)
