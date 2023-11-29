import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StackTest {

    private Stack testStack;
    private final long seed = 12345; // Fixed seed for reproducibility
    private Random random;

    @Before
    public void setUp() throws IOException {
        testStack = new Stack("search.dot");
        random = new Random(seed); // Random object with seed for test predictability
    }

    private String getExpectedOutput(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    @Test
    public void testParseGraph() throws IOException {
        // Create a test DOT graph file
        String testDotFilePath = "test_Parse_file.dot";

        Stack testStack = new Stack(testDotFilePath);
        //System.out.println(mutableGraph.toString());
        // Assertions
        assertNotNull(testStack);
        // Assuming toString() of the graph prints nodes and edges. Adjust as per actual behavior.
        //testStack.parseGraph(testDotFilePath);
        String output = testStack.toString();
        String expected = getExpectedOutput("expected_Parse.txt");
        System.out.println(output);
        System.out.println(expected);
        assertEquals(expected, output);

        //Files.delete(Paths.get(testDotFilePath));  // cleanup test file
    }

    @Test
    public void testToString() throws IOException {
        String testFilePath = "test_toString_file.dot";

        Stack testStack = new Stack(testFilePath);
        String output = testStack.toString();

        String expected = getExpectedOutput("expected_toString.txt");
        System.out.println(expected);
        System.out.println(output);
        assertEquals(expected, output);
    }
    @Test
    public void testOutputGraph() throws IOException {
        String inputDotFilePath = "test_OutputGraph_file.dot";

        Stack testStack = new Stack(inputDotFilePath);

        String outputDotFilePath = "output_dot_file.png";
        testStack.outputGraph(outputDotFilePath);
        // Check if the file was created
        assertTrue(Files.exists(Paths.get(outputDotFilePath)));

        // Cleanup
        //Files.delete(Paths.get(inputDotFilePath));
        //Files.delete(Paths.get(outputDotFilePath));
    }

    @Test
    public void testAddNode() throws IOException{
        String label = "F";
        String inputDotFilePath = "test_AddNode_file.dot";

        Stack testStack = new Stack(inputDotFilePath);
        testStack.addNode(label);
        String output = testStack.toString();
//        String outputDotFilePath = "output_1.png";
//        testStack.outputGraph(outputDotFilePath);
//        System.out.println(output);
        String expected = getExpectedOutput("expected_addNode.txt");
        System.out.println(output);
        System.out.println(expected);
        assertEquals(expected, output);
    }

    @Test
    public void testAddNodes() throws IOException{
        String[] label = {"Q", "W", "E", "R", "T"};

        String inputDotFilePath = "test_AddNodes_file.dot";

        Stack testStack = new Stack(inputDotFilePath);
        testStack.addNodes(label);
        String expected = getExpectedOutput("expected_addNodes.txt");
        String output = testStack.toString();
        System.out.println(output);
        System.out.println(expected);
        assertEquals(expected, output);
    }

    @Test
    public void testAddEdge() throws IOException{
        String inputDotFilePath = "test_AddEdge_file.dot";
        Stack testStack = new Stack(inputDotFilePath);
        String staLabel = "A";
        String dstLabel = "C";
        testStack.addEdge(staLabel,dstLabel);
        String output = testStack.toString();

        String expected = getExpectedOutput("expected_addEdge.txt");
        assertEquals(expected, output);
    }

    @Test
    public void testOutputDOTGraph() throws IOException{
        String testFilePath = "test_OutputDOTGraph_file.dot";

        Stack testStack = new Stack(testFilePath);
        String outputPath = "output_dot_file.dot";
        testStack.outputDOTGraph(outputPath);

        String output = new String(Files.readAllBytes(Paths.get(outputPath)));
        String expected = getExpectedOutput("expected_outputDOTGraph.txt");
        System.out.println(output);
        System.out.println(expected);
        assertEquals(expected, output);
    }

    @Test
    public void testOutputGraphics() throws IOException{
        String testFilePath = "test_OutputGraphics_file.dot";

        Stack testStack = new Stack(testFilePath);
        String outputPath = "output_graphics_file.png";
        testStack.outputGraphics(outputPath, "png");

        assertTrue(Files.exists(Paths.get(outputPath)));
    }

    @Test
    public void testRemoveNode() throws IOException {
        String testFilePath = "test_RemoveNode_file.dot";
        Stack testStack = new Stack(testFilePath);
        testStack.removeNode("A");
        String output = testStack.toString();
        String expected = getExpectedOutput("expected_removeNode.txt");
        assertEquals(expected, output);
    }

    @Test
    public void testRemoveNodes() throws IOException {
        String[] labelsToRemove = {"A", "B"}; // assuming these nodes exist in the file
        String inputDotFilePath = "test_RemoveNodes_file.dot";

        Stack testStack = new Stack(inputDotFilePath);
        testStack.removeNodes(labelsToRemove);
        String output = testStack.toString();

        String expected = getExpectedOutput("expected_removeNodes.txt");
        //System.out.println(output);
        //System.out.println(expected);
        assertEquals(expected, output);
    }


    @Test
    public void testRemoveEdge() throws IOException {
        String testFilePath = "test_RemoveEdge_file.dot";
        Stack testStack = new Stack(testFilePath);
        testStack.removeEdge("A", "B");
        String output = testStack.toString();
        String expected = getExpectedOutput("expected_removeEdge.txt");
        assertEquals(expected, output);
    }

    @Test
    public void testBFS() throws IOException {
        System.out.println("Running BFS Test");
        Stack testStack = new Stack("search.dot");
        Stack.Path result = testStack.graphSearch("A", "D", Stack.Algorithm.BFS);
        assertNotNull("BFS should find a path", result);
        System.out.println("BFS Path: " + result);
    }


    @Test
    public void testDFS() throws IOException {
        System.out.println("Running DFS Test");
        Stack testStack = new Stack("search.dot");
        Stack.Path result = testStack.graphSearch("A", "D", Stack.Algorithm.DFS);
        assertNotNull("DFS should find a path", result);
        System.out.println("DFS Path: " + result);
    }

    @Test
    public void testRandomWalk() throws IOException {
        System.out.println("Running Random Walk Test");
        Stack.Path result = testStack.graphSearch("A", "G", Stack.Algorithm.RANDOM_WALK, random);
        assertNotNull("Random Walk should find a path", result);
        System.out.println("Random Walk Path: " + result);
    }


}

