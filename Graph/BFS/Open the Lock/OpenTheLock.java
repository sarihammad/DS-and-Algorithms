// Shortest path problem. Similar to word ladder: bfs level by level, explore all possbile 8 states +- 1 for each char and ignore deadends. return moves once curr string reaches target, or -1 if queue empties before reaching target.
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(List.of(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String start = "0000";

        if (deadendsSet.contains(start)) return -1; // edge case for 0000 in deadends
        
        visited.add(start);
        queue.add(start);
        int moves = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String currString = queue.poll();
                if (currString.equals(target)) return moves;
                for (String nextString : getNextStates(currString)) {
                    if (!visited.contains(nextString) && !deadendsSet.contains(nextString)) {
                        visited.add(nextString);
                        queue.add(nextString);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = current.toCharArray();
        for (int i = 0; i < 4; i++) {
            char originalChar = chars[i];
            // next states
            chars[i] = chars[i] == '9' ? '0' : (char) (originalChar + 1); // increment to ascii, cast back to char
            nextStates.add(new String(chars));
            chars[i] = originalChar;
            // prev states
            chars[i] = chars[i] == '0' ? '9' : (char) (originalChar - 1);
            nextStates.add(new String(chars));
            chars[i] = originalChar;
        }
        return nextStates;
    }
}
