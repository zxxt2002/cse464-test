import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import java.util.*;

public class RandomWalkSearchAlgorithm extends GraphSearchAlgorithm {

    private final Random random;

    public RandomWalkSearchAlgorithm(Graph<String, DefaultEdge> graph, Random random) {
        super(graph);
        this.random = random;
    }

    @Override
    protected Stack.Path performSearch(String src, String dst) {
        List<String> pathList = new ArrayList<>();
        pathList.add(src);

        String current = src;
        System.out.println("random testing");
        System.out.println("visiting Path{nodes=[" + String.join(", ", pathList) + "]}");
        while (!current.equals(dst) && graph.containsVertex(current)) {
            List<String> neighbors = new ArrayList<>(Graphs.successorListOf(graph, current));
            if (neighbors.isEmpty()) {
                break; // No where to go from here, dead end.
            }

            // Select a random neighbor to move to
            current = neighbors.get(new Random().nextInt(neighbors.size()));
            pathList.add(current);
            System.out.println("visiting Path{nodes=[" + String.join(", ", pathList) + "]}");
        }

        // If current is dst, we have found a path, otherwise return null.
        if (current.equals(dst)) {
            System.out.println("Path{nodes=[" + String.join(", ", pathList) + "]}");
            return new Stack.Path(pathList);
        }
        return null;

    }
}
