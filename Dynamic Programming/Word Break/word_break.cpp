// DP. dp[i] = true if s[:i] can be segmented to words. dp[i] = true if dp[j] && s[j:i] in wordDict for any j < i. return dp[n].
class WordBreak {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        std::vector<bool> dp(s.length() + 1, false);
        std::unordered_set<std::string> words(wordDict.begin(), wordDict.end());
        dp[0] = true;

        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && words.contains(s.substr(j, i - j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
};
