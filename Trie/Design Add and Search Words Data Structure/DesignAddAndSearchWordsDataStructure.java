public class DesignAddAndSearchWordsDataStructure {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // index i -> (i + 1)_th char in alphabet
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a'; // maps a -> 0, b -> 1, ..., z -> 25
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }
    
    // needs dfs to handle dots: start from index 0 and verify char at each index exists in Trie. Return true if we reach last char index and it's an end of word.
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int index, TrieNode node) {
        // base case: reached end of word -> return true.
        if (index == word.length) return node.isEndOfWord;
        // check current letter. Two cases: '.' or normal char.
        char c = word[index];
        if (c == '.') { // dot. loop through all non-null children and try to find a solution
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) return true;
            }
            return false; // no child found that leads to solution
        } else {
            // check node child of letter, ensure non-null and leads to a solultion.
            int idx = c - 'a';
            TrieNode child = node.children[idx];
            return child != null && dfs(word, index + 1, child);
        }
        
    }
}
