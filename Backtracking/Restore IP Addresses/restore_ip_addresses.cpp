// backtracking. place dot 1, 2, or 3 digits after current start index. Check for leading 0's plus whether segment <= 255. stop at 4 segments, add if used up all digits (start reached end of string).
class RestoreIPAddresses {
public:
	std::vector<std::string> restoreIpAddresses(std::string s) {
		std::vector<std::string> result;
		std::vector<std::string> path;
		backtrack(s, 0, path, result);
		return result;
	}

private:
	void backtrack(const std::string& s, int start, std::vector<std::string>& path, std::vector<std::string>& result) {
		if (path.size() == 4) {
			if (start == s.size()) { // reached end of s (used all digits)
				result.push_back(createIp(path));
			}
			return;
		}

		for (int len = 1; len <= 3; ++len) {
			if (start + len > s.size()) break;

			std::string segment = s.substr(start, len);
			if (isValid(segment)) {
				path.push_back(segment);
				backtrack(s, start + len, path, result);
				path.pop_back();
			}
		}
	}

	bool isValid(const std::string& segment) {
		if (segment[0] == '0' && segment.size() > 1) return false; 
		int val = std::stoi(segment);
		return val >= 0 && val <= 255;
	}

	std::string createIp(const std::vector<std::string>& parts) { // 
		return parts[0] + "." + parts[1] + "." + parts[2] + "." + parts[3]; 
	}
};
