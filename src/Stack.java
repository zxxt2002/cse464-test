import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;

import guru.nidi.graphviz.parse.Parser;
import guru.nidi.graphviz.model.MutableGraph;

public class Stack {


    private Graph<String, DefaultEdge> graph;
    private static final String PNG_FORMAT = "png";

    public Stack(String filepath) throws IOException {
        this.graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        parseGraph(filepath);
    }


    public enum Algorithm {
        BFS, DFS, RANDOM_WALK
    }


    public static class DuplicateNodeException extends RuntimeException {
        public DuplicateNodeException(String label) {
            super("Node with label " + label + " already exists.");
        }
    }


    public static class DuplicateEdgeException extends RuntimeException {
        public DuplicateEdgeException(String startLabel, String dstLabel) {
            super("Edge from " + startLabel + " to " + dstLabel + " already exists.");
        }
    }


    public static class NonExistNodeException extends RuntimeException {
        public NonExistNodeException(String label) {
            super("Node with label " + label + " not exists.");
        }
    }


    public static class NonExistEdgeException extends RuntimeException {
        public NonExistEdgeException(String startLabel, String dstLabel) {
            super("Edge from " + startLabel + " to " + dstLabel + " not exists.");
        }
    }


    private String readFileContent(String filepath) throws IOException {
        if (!Files.exists(Paths.get(filepath))) {
            throw new IOException("File not found: " + filepath);
        }
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
    public void parseGraph(String filepath) throws IOException {
        String dotContent = readFileContent(filepath);
        String[] lines = dotContent.split("\n");
        for (String line : lines) {
            boolean isEdgeDefinition = line.contains("->");
            if (isEdgeDefinition) {
                String[] nodes = line.split("->");
                String source = nodes[0].trim();
                String target = nodes[1].trim().replace(";", "");
                graph.addVertex(source);
                graph.addVertex(target);
                graph.addEdge(source, target);
            } else if (!line.contains("digraph") && !line.contains("{") && !line.contains("}")) {
                String vertex = line.trim().replace(";", "");
                graph.addVertex(vertex);
            }
        }
    }


    private String buildEdges(Set<String> nodesWithEdges) {
        StringBuilder edgeBuilder = new StringBuilder();
        for (DefaultEdge edge : graph.edgeSet()) {
            String source = graph.getEdgeSource(edge);
            String target = graph.getEdgeTarget(edge);
            nodesWithEdges.add(source);
            nodesWithEdges.add(target);
            edgeBuilder.append("  ")
                    .append(source)
                    .append(" -> ")
                    .append(target)
                    .append(";\n");
        }
        return edgeBuilder.toString();
    }


    private String buildVertices(Set<String> nodesWithEdges) {
        StringBuilder vertexBuilder = new StringBuilder();
        for (String vertex : graph.vertexSet()) {
            if (!nodesWithEdges.contains(vertex)) {
                vertexBuilder.append("  ")
                        .append(vertex)
                        .append(";\n");
            }
        }
        return vertexBuilder.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<String> nodesWithEdges = new HashSet<>();
        sb.append("digraph G {\n");
        sb.append(buildEdges(nodesWithEdges));
        sb.append(buildVertices(nodesWithEdges));
        sb.append("}");
        return sb.toString();
    }


    public void outputGraph(String filepath) throws IOException {
        String dotString = toString();
        MutableGraph g = new Parser().read(dotString);
        Graphviz.fromGraph(g).render(Format.PNG).toFile(new File(filepath));
    }


    public void addNode(String label) {
        if (graph.containsVertex(label)) {
            throw new DuplicateNodeException(label);
        }
        graph.addVertex(label);
    }


    public void addNodes(String[] labels) {
        for (String label : labels) {
            addNode(label);
        }
    }


    public void addEdge(String startLabel, String destinationLabel) {
        if (graph.containsEdge(startLabel, destinationLabel)) {
            throw new DuplicateEdgeException(startLabel, destinationLabel);
        }
        graph.addEdge(startLabel, destinationLabel);
    }


    public void outputDOTGraph(String path) throws IOException {
        String dotFormatGraph = this.toString(); // using the custom toString method
        Files.write(Paths.get(path), dotFormatGraph.getBytes());
    }


    private Format getOutputFormat(String format) {
        if (PNG_FORMAT.equalsIgnoreCase(format)) {
            return Format.PNG;
        }
        return Format.valueOf(format.toUpperCase());
    }


    public void outputGraphics(String path, String format) throws IOException {
        String dotString = toString();
        Format outputFormat = getOutputFormat(format);
        MutableGraph g = new Parser().read(dotString);
        Graphviz.fromGraph(g).render(outputFormat).toFile(new File(path));
    }


    public void removeNode(String label) {
        if (!graph.containsVertex(label)) {
            throw new NonExistNodeException(label);
        }
        graph.removeVertex(label);
    }


    public void removeNodes(String[] labels) {
        for (String label : labels) {
            removeNode(label);
        }
    }


    public void removeEdge(String srcLabel, String dstLabel) {
        DefaultEdge edge = graph.getEdge(srcLabel, dstLabel);
        if (edge == null) {
            throw new NonExistEdgeException(srcLabel, dstLabel);
        }
        graph.removeEdge(edge);
    }


    // DFS method to find a path from src to dst
    public Path graphSearch(String src, String dst, Algorithm algo) {
        GraphSearchAlgorithm searchAlgorithm;
        switch (algo) {
            case BFS:
                searchAlgorithm = new BFSSearchAlgorithm(this.graph);
                break;
            case DFS:
                searchAlgorithm = new DFSSearchAlgorithm(this.graph);
                break;
            default:
                throw new IllegalArgumentException("Unsupported search algorithm");
        }
        return searchAlgorithm.search(src, dst);
    }
    public Path graphSearch(String src, String dst, Algorithm algo, Random random) {
        if (algo != Algorithm.RANDOM_WALK) {
            throw new IllegalArgumentException("This method is only for the RANDOM_WALK algorithm");
        }
        RandomWalkSearchAlgorithm searchAlgorithm = new RandomWalkSearchAlgorithm(this.graph, random);
        return searchAlgorithm.search(src, dst);
    }


    // Path class definition
    public static class Path {
        private List<String> nodes;


        public Path(List<String> nodes) {
            this.nodes = nodes;
        }


        @Override
        public String toString() {
            return String.join(" -> ", nodes);
        }
    }
}




