// Use Trie to store words. When running DFS to find words, we know which paths to continue from by checking node's children. Runtime: O(m * n * 4^(word list length))
class TrieNode {
	Map<Character, TrieNode> children = new HashMap<>();
	String word = null;
}

public class WordSearchII {
	private final List<String> result = new ArrayList<>();

	public List<String> findWords(char[][] board, String[] words) {
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(i, j, board, root);
			}
		}
		return result;
	}

	private void dfs(int i, int j, char[][] board, TrieNode node) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || !node.children.containsKey(board[i][j])) {
			return;
		}

		char ch = board[i][j];

		node = node.children.get(ch);
		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		
		board[i][j] = '#';
		dfs(i + 1, j, board, node);
		dfs(i - 1, j, board, node);
		dfs(i, j + 1, board, node);
		dfs(i, j - 1, board, node);
		board[i][j] = ch;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode curr = root;
			for (char ch : word.toCharArray()) {
				curr = curr.children.computeIfAbsent(ch, k -> new TrieNode());
			}
			curr.word = word;
		}
		return root;
	}
}
