// BFS: similar to word ladder. add initial gene to queue, add all valid non-visited next mutations to queue and return result as soon as end gene is found.
public class MinimumGeneticMutation {
	private final char[] genes = {'A', 'C', 'G', 'T'};

	public int minMutation(String startGene, String endGene, String[] bank) {
		Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
		if (!bankSet.contains(endGene)) return -1;

		Queue<String> queue = new LinkedList<>();
		queue.offer(startGene);
		Set<String> visited = new HashSet<>();
		visited.add(startGene);

		int result = 0;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				String currGene = queue.poll();
				if (currGene.equals(endGene)) return result;

				char[] chars = currGene.toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char original = chars[j];
					for (char gene : genes) {
						chars[j] = gene;
						String nextGene = new String(chars);
						if (bankSet.contains(nextGene) && !visited.contains(nextGene)) {
							queue.offer(nextGene);
							visited.add(nextGene);
						}
					}
					chars[j] = original;
				}
			}
			result++;
		}
        
		return -1;
	}
}
