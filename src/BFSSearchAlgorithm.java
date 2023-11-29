import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class BFSSearchAlgorithm extends GraphSearchAlgorithm {
    public BFSSearchAlgorithm(Graph<String, DefaultEdge> graph) {
        super(graph);
    }

    @Override
    protected Stack.Path performSearch(String src, String dst) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> pathTracker = new HashMap<>();

        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(dst)) {
                return reconstructPath(pathTracker, src, dst);
            }

            for (DefaultEdge edge : graph.outgoingEdgesOf(current)) {
                String neighbor = graph.getEdgeTarget(edge);
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    pathTracker.put(neighbor, current);
                }
            }
        }

        return null;
    }

    private Stack.Path reconstructPath(Map<String, String> pathTracker, String src, String dst) {
        LinkedList<String> path = new LinkedList<>();
        String current = dst;
        while (current != null && !current.equals(src)) {
            path.addFirst(current);
            current = pathTracker.get(current);
        }
        if (current != null) {
            path.addFirst(src);
        }
        return new Stack.Path(path);
    }
}