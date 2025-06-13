// binary search answer on possible capacities: min is max of weights, max is sum of all weights. check if partinioning into <= D days possible with current capacity and update answer. O(n * log(sum(weights))).
class CapacityToShipPackagesWithinDDays {
public:
	int shipWithinDays(std::vector<int>& weights, int D) {
		int left = *std::max_element(weights.begin(), weights.end());
		int right = std::accumulate(weights.begin(), weights.end(), 0);
		int result = right;

		// binary search:
		while (left <= right) {
			int mid = (left + right) / 2;
			if (canShip(weights, D, mid)) { // update answer, look for smaller  
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}

private:
	// get least amount of days to split the weights, return if <= D.
	bool canShip(const std::vector<int>& weights, int D, int capacity) {
		int minDays = 1;
		int currentWeight = 0;
		for (int weight : weights) {
			if (currentWeight + weight > capacity) {
				minDays++;
				currentWeight = 0;
			}
			currentWeight += weight;
		}
		return minDays <= D;
	}
};
