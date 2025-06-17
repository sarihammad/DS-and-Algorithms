class Interval {
	int start;
	int end;
	Interval(int start, int end) {
		this.start = stard;
		this.end = end;
	}
}

// Min-heap with meeting end times as keys. For each next meeting (sorted by start time), if it's after the earliest end time in the heap, we reuse that room by removing the earliest end time and adding the current meeting (keeping heap size the same). Else, we need a new room by adding a new node to the heap without replacing the current earliest end time meeting (increasing heap size by 1). Heap size at the end represents the minimum number of rooms required.
public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek().end) {
                minHeap.poll();
            }

            minHeap.offer(interval);
        }
        return minHeap.size();
    }
}

