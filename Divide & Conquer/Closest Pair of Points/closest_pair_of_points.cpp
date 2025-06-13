#include <vector>
#include <algorithm>
#include <cmath>
#include <limits>

class ClosestPair {
public:
	typedef std::pair<double, double> Point;

	double closestPair(std::vector<Point>& points) {
		std::sort(points.begin(), points.end()); // defaults to sorting by X

		return closestHelper(points);
	}

private:
	double closestHelper(std::vector<Point>& points) {
		int n = points.size();
		if (n <= 3) { // brute force distances
			double minDistance = std::numeric_limits<double>::infinity();
			for (int i = 0; i < n - 1; ++i) {
				for (int j = i + 1; j < n; ++j) {
					minDistance = std::min(minDistance, distance(points[i], points[j]));
				}
			}
			return minDistance;
		}

		// separation line / midpoint
		int mid = n / 2;
		Point midpoint = points[mid];

		// closet pair from left
		std::vector<Point> left(points.begin(), points.begin() + mid);
		double d1 = closestHelper(left);

		// closet pair from right
		std::vector<Point> right(points.begin() + mid, points.end());
		double d2 = closestHelper(right);

		// delta (minimum left and right)
		double d = std::min(d1, d2);

		// delete all points outside of strip (further than delta from midpoint)
		std::vector<Point> strip;
		for (const auto& point : points) {
			if (std::abs(point.first - midpoint.first) < d) {
				strip.push_back(point);
			}
		}

		// sort strip points by Y
		std::sort(strip.begin(), strip.end(), [](const Point& a, const Point& b) {
			return a.second < b.second;
		});

		// scan points in Y order and get distances up to next 7 neighbors
		for (int i = 0; i < strip.size(); ++i) {
			for (int j = i + 1; j < strip.size() && j <= i + 7; ++j) {
				if (strip[j].second - strip[i].second >= d) break; // already >= delta. check next point.
				d = std::min(d, distance(strip[i], strip[j]));
			}
		}

		return d;
	}

	double distance(const Point& a, const Point& b) {
		return std::sqrt((a.first - b.first) * (a.first - b.first) +
						 (a.second - b.second) * (a.second - b.second));
	}
};
