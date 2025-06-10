// Hashmap of elements with frequencies. Min heap of element frequencies as keys. Maintain size k by removing n - k low frequency elements. k that remain are the most frequent.
public class TopKFrequentElements {
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (var entry : count.entrySet()) {
			heap.add(entry);
			if (heap.size() > k) heap.poll();
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[k - 1 - i] = heap.poll().getKey();
		}

		return res;
	}
}
