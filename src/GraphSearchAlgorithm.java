import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public abstract class GraphSearchAlgorithm {
    protected Graph<String, DefaultEdge> graph;

    public GraphSearchAlgorithm(Graph<String, DefaultEdge> graph) {
        this.graph = graph;
    }

    public final Stack.Path search(String src, String dst) {
        if (!graph.containsVertex(src) || !graph.containsVertex(dst)) {
            return null;
        }
        return performSearch(src, dst);
    }

    protected abstract Stack.Path performSearch(String src, String dst);
}