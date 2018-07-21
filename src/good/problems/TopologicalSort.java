package good.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	static Set<Integer> processed = new HashSet<>();
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		graph.put(5, Arrays.asList(2, 0));
		graph.put(2, Arrays.asList(3));
		graph.put(3, Arrays.asList(1));
		graph.put(4, Arrays.asList(0, 1));

		topologicalSort(graph);
	}

	static void topologicalSort(Map<Integer, List<Integer>> graph) {
		if (graph == null || graph.size() == 0) {
			return;
		}
		Iterator<Integer> itr = graph.keySet().iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			topologicalSortRecursive(key, graph);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	static void topologicalSortRecursive(Integer key, Map<Integer, List<Integer>> graph) {
		if (!processed.contains(key)) {
			processed.add(key);
			List<Integer> list = graph.get(key);
			if (list != null) {
				for (Integer a : list) {
					topologicalSortRecursive(a, graph);
				}
			}
			stack.add(key);
		}
	}
}
