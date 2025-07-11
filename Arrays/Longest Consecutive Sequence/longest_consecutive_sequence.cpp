class LongestConsecutiveSequence {
public:
    // add all to hashset. for each num, check if num - 1 in hashset. if yes, skip it. if no, it's a candidate: keep check num + 1 until it fails. update max after each candidate
    int longestConsecutive(vector<int>& nums) {
        int result = 0;
        unordered_set<int> numsSet;
        for (int num : nums) numsSet.insert(num);

        for (int num : nums) {
            if (numsSet.count(num - 1)) continue;
            int currCount = 1;
            int candidate = num;
            while (numsSet.count(candidate + 1)) {
                ++currCount;
                ++candidate;
            }
            
            result = max(result, currCount);
        }

        return result;
    }
};
