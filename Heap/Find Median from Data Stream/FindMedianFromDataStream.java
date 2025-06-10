// Add first to max heap, anything <= max heap top goes to max heap, otherwise to min heap. Rebalance if needed with two cases: 2 more max heap elements or 1 more min heap element. 
public class FindMedianFromDataStream {
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public void addNum(int num) {
		if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}

		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}
	// if equal lengths, get avg of tops, else max heap head
	public double findMedian() {
		if (maxHeap.size() != minHeap.size()) {
			return maxHeap.peek();
		}
		return (maxHeap.peek() + minHeap.peek()) / 2.0;
		
	}
}
