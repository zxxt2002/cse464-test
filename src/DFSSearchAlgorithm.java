import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class DFSSearchAlgorithm extends GraphSearchAlgorithm {
    public DFSSearchAlgorithm(Graph<String, DefaultEdge> graph) {
        super(graph);
    }

    @Override
    protected Stack.Path performSearch(String src, String dst) {
        Set<String> visited = new HashSet<>();
        Map<String, String> pathTracker = new HashMap<>();

        if (dfsUtil(src, dst, visited, pathTracker)) {
            return reconstructPath(pathTracker, src, dst);
        }

        return null;
    }

    private boolean dfsUtil(String current, String dst, Set<String> visited, Map<String, String> pathTracker) {
        visited.add(current);

        if (current.equals(dst)) {
            return true;
        }

        for (DefaultEdge edge : graph.outgoingEdgesOf(current)) {
            String neighbor = graph.getEdgeTarget(edge);
            if (!visited.contains(neighbor)) {
                pathTracker.put(neighbor, current);
                if (dfsUtil(neighbor, dst, visited, pathTracker)) {
                    return true;
                }
            }
        }

        return false;
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