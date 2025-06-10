// Hashmap to map anagram keys to list of anagrams. Sort each str to get the common anagram key. Each hashmap list is a group of anagrams.
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sorted = new String(charArray);
			
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(str);
		}

		return new ArrayList<>(map.values());
	}
}
