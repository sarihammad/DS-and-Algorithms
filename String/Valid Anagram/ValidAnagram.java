public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> counter = new HashMap<>();

        for (char ch : s.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : t.toCharArray()) {
            if (counter.getOrDefault(ch, 0) == 0) return false; // Same length => trying to decrement any char beyond 0 <=> not anagrams
            counter.put(ch, counter.get(ch) - 1);
        }
        return true;
    }
}
