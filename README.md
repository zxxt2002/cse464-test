# CSE-464-2023-xzhao141
This README provides detailed instructions on how to use the Stack class API for testing various functionalities. The StackTest class contains a set of test methods that demonstrate how to use the Stack class to perform common operations on a directed graph represented in DOT format.



Creating a Test DOT File: You will need a test DOT file that represents the directed graph you want to work with in your tests, the input dot file and expected output file should named as same as name shown in below section. Create or obtain this file and specify its path as needed in your test methods.


String testDotFilePath = "path/to/your/test_graph.dot";
Stack testStack = new Stack(testDotFilePath);
Performing Operations: Use the methods provided by the Stack class to perform operations on the graph. For example, you can add nodes, add edges, or convert the graph to a string representation using the toString method.

Detailed expalin how each test work: 

Feature 1:
commit link: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/915d1a9db509de5260c05a8a35d7a4fb7d8162d7 

testParseGraph():
input file name: test_Parse_file.dot
expected file name: expected_Parse.txt
sample output: <img width="652" alt="Screen Shot 2023-10-11 at 22 05 20" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/2c0038be-58d4-4737-89a1-1fb07a955648">

testToString():
input file name: test_toString_file.dot
expected file name: expected_toString.txt
sample output: <img width="588" alt="Screen Shot 2023-10-11 at 22 08 35" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/31cb16ec-a45f-4934-a1d4-1aaaabc74def">


testOutputGraph():
note: this test will take a dot file as input and output a png file, tester could compare the output file to expected png file
input file name: test_OutputGraph_file.dot
output file name: output_dot_file.png
sample output: <img width="131" alt="Screen Shot 2023-10-11 at 22 09 22" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/d2ddc7ce-6eb4-4977-8e94-b14a6ac7e57b"><img width="724" alt="Screen Shot 2023-10-11 at 22 41 19" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/9d09f58d-3cd6-4248-b0a9-91ecb86d7abb">


Feature 2:
commit link: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/30013b2f6883ff0c64c3be711e919851242cbd34

testAddNode():
NOTE: to decide what node to add, modify the line "String label = "F";" in the 'testAddNode()' class, replace 'F' with the node you want to add.
input file name: test_AddNode_file.dot
expected file name: expected_addNode.txt
sample output:<img width="614" alt="Screen Shot 2023-10-11 at 22 11 41" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/4cf11044-0740-44da-8422-e8c188580f0f">


testAddNodes():
NOTE: to decide what nodes to add, modify the line "String[] label = {"Q", "W", "E", "R", "T"};" in the 'testAddNodes()' class, replace '{"Q", "W", "E", "R", "T"}' with the node you want to add in string array format.
input file name:test_AddNodes_file.dot
expected file name: expected_addNodes.txt
sample output:<img width="596" alt="Screen Shot 2023-10-11 at 22 12 09" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/c827c96c-bcf1-408c-8e55-127a65961297">


Feature 3:
commit link: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/4798210925ac42c3c78a557aac6673a699e1c9c1 

testAddEdge():
NOTE: to decide what edge to add, modify the line "String staLabel = "A";" and line "String dstLabel = "C";" in the 'testAddEdge()' class, replace 'A' with the staring node of the edge and replace the 'C' with destination node of edge. 
input file name: test_AddEdge_file.dot
expected file name: expected_addEdge.txt
sample output:<img width="652" alt="Screen Shot 2023-10-11 at 22 12 25" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/e0c575df-405f-48ec-bf2a-f54a5e1cd46c">

Feature 4:
commit link: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/64b7350ae9c28a222cd5d27de9e756ac67b7830c

testOutputDOTGraph():
input file name: test_OutputDOTGraph_file.dot
expected file name: expected_outputDOTGraph.txt
output file name: output_dot_file.dot
sample output:<img width="88" alt="Screen Shot 2023-10-11 at 22 29 48" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/f8caada3-fe9c-487e-9b37-4bb0c356d764">
<img width="593" alt="Screen Shot 2023-10-11 at 22 30 49" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/53f595f6-4f1a-4b51-b010-3fbeaf71de2f">



testOutputGraphics():
note: this test will take a dot file as input and output a png file, tester could compare the output file to expected png file
output file name: output_graphics_file.png
input file name: test_OutputGraphics_file.dot
sample output:<img width="62" alt="Screen Shot 2023-10-11 at 22 30 23" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/22299e4c-3193-4e58-8c63-33cc71245453">
<img width="792" alt="Screen Shot 2023-10-11 at 22 30 32" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/98e57120-ae7a-4447-847a-aa6901c9e66c">

PART2:
1. remove edge and node: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/fbd0f86e38492dc3a6e672d904d769b332e57e8f

removeNode(String label):

input file named: "test_RemoveNode_file.dot";

expected file named: expected_removeNode.txt

in order to remove a node, change the letter "A" in testStack.removeNode("A") to any letter you want to remove. 

successfully remove:<img width="682" alt="Screen Shot 2023-11-05 at 21 40 27" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/a0837238-b91f-4d21-98da-dcc3ece1348f">

remove non exist node:<img width="847" alt="Screen Shot 2023-11-05 at 21 40 42" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/c559d9a8-91ce-426f-9434-3ef57ea90363">


removeNodes(String[] label):

input file named: "test_RemoveNodes_file.dot"

expected file named: expected_removeNodes.txt

change letters to any node you want to remove in line: String[] labelsToRemove = {"A", "B"}

successfully remove:<img width="644" alt="Screen Shot 2023-11-05 at 21 40 56" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/50b7c07c-fc2b-4466-a635-289da0d60331">

remove non exist node:<img width="854" alt="Screen Shot 2023-11-05 at 21 41 21" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/3e86a415-20a2-4b85-a33c-80931a9cfce0">

removeEdge(String srcLabel, String dstLabel):

input file named: test_RemoveEdge_file.dot

expected file named: expected_removeEdge.txt

switch the letter A and B with start node and dst node of the edge you want to remove in line: testStack.removeEdge("A", "B");

successfully remove:<img width="686" alt="Screen Shot 2023-11-05 at 21 41 44" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/6007fb51-1003-4ead-935c-3742943fa4ce">

remove non exist node:<img width="865" alt="Screen Shot 2023-11-05 at 21 41 57" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/da24a852-373b-4d36-a367-df489fe07dbc">

2. Add continuous integration support for your github project:
<img width="1330" alt="Screen Shot 2023-11-05 at 22 30 18" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/d47526ed-cba8-4ebb-b058-c110ff483929">
link: https://github.com/zxxt2002/CSE-464-2023-xzhao141/actions/workflows/main.yml

3. create bfs branch: https://github.com/zxxt2002/CSE-464-2023-xzhao141/tree/bfs

4. create dfs branch: https://github.com/zxxt2002/CSE-464-2023-xzhao141/tree/dfs

5. merge into main and solve merge conflict:
could use API: Path GraphSearch(Node src, Node dst, Algorithm algo), algo should be "BFS" or "DFS"
    before: <img width="1011" alt="Screen Shot 2023-11-05 at 22 17 31" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/604f47d7-0785-487f-bff4-0ec633e85105">
    after: <img width="1012" alt="Screen Shot 2023-11-05 at 22 19 31" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/7c5294e5-db5a-45d6-8cb7-c8a9286fa61b">



Cleaning Up (Optional): If your tests create temporary files or have cleanup tasks, you can uncomment the cleanup code in the test methods to remove temporary files or resources.

How to run this test:

To run the tests effectively, you should provide input DOT files that represent different graph configurations, with the same file name shown in above section. These input files should be placed in the same directory as your test code, and their paths should be specified in your test methods.

Test Descriptions:

The StackTest class contains several test methods, each focusing on different aspects of the Stack class. Refer to the previous README or the Javadoc comments in the Stack class for detailed descriptions of each test method.

Test Output:

The tests will generate output to the console, showing the actual output and the expected output for comparison. If all tests pass, you will see "Tests passed" in the console output.

Please ensure that your input DOT files and expected output files match your specific test scenarios and use cases. Modify the file paths and test data as needed for your testing requirements.
