package amazon.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphTraversal {

	static Set<String> smallestPath;
	static int smallestPathLength = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.put("txt", Arrays.asList("html", "csv", "doc", "pdf"));
		graph.put("html", Arrays.asList("csv"));
		graph.put("csv", Arrays.asList("xls"));
		// graph.put("xls", Arrays.asList("pdf"));
		Set<String> path = new LinkedHashSet<>();
		traverseFromSourceToDest(graph, "txt", "pdf", path);
		// System.out.println(smallestPath);
	}

	static void traverseFromSourceToDest(Graph graph, String source, String dest, Set<String> path) {
		if (graph == null) {
			return;
		}
		if (!path.contains(source)) {
			if (source.equals(dest)) {
				path.add(source);
				System.out.println(path);
				// if (path.size() < smallestPathLength) {
				// smallestPath = path;
				// }
			} else {
				List<String> connections = graph.get(source);
				if (connections != null) {
					path.add(source);
					for (String s : connections) {
						traverseFromSourceToDest(graph, s, dest, path);
					}
					path.remove(source);
				}
			}
		}
	}

}

class Graph {
	Map<String, List<String>> graph;

	public List<String> get(String source) {
		return this.graph.get(source);
	}

	public void put(String source, List<String> connections) {
		this.graph.put(source, connections);
	}

	Graph() {
		this.graph = new HashMap<>();
	}
}
