package Test;

import src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarShallTest {
   @Test
    public void simpleTest() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\simpleTest.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


       
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(0, 2, 4));
        List<Integer> path = graph.getFloydWarshallPath(0,4,parents);
        assertEquals(6, costs[0][4], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void mediumTestHighDensity() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\mediumTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


      
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(1, 4, 11, 10));
        List<Integer> path = graph.getFloydWarshallPath(1,10,parents);
        assertEquals(39, costs[1][10], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void noPathMediumTestHighDensity() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\mediumTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


 
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList());
        List<Integer> path = graph.getFloydWarshallPath(9,0,parents);
        assertEquals(Integer.MAX_VALUE, costs[9][0], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void BigTestHighDensity1() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\BigTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


       
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for(int i=1;i<50;i+=2){
            ans.add(i);
        }
        List<Integer> path = graph.getFloydWarshallPath(0,49,parents);
        assertEquals(674, costs[0][49], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void BigTestHighDensity2() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\BigTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


       
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<50;i+=2){
            ans.add(i);
        }
        List<Integer> path = graph.getFloydWarshallPath(0,48,parents);
        assertEquals(648, costs[0][48], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void testEqualShortestPathsWithNegativeValues() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\equalShortestPathsNegative.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


       
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans1 = new ArrayList<>(Arrays.asList(0,1,4));
        List<Integer> ans2 = new ArrayList<>(Arrays.asList(0,2,3,4));
        List<Integer> actual = graph.getFloydWarshallPath(0,4,parents);
        assertEquals(-5, costs[0][4], "Costs array does not match expected values");
        assertTrue(ans1.equals(actual) || ans2.equals(actual));    }
    @Test
    public void testEqualShortestPathsWithPositiveValues() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\equalShortestPathsPositive.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


       
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans1 = new ArrayList<>(Arrays.asList(0,2,3));
        List<Integer> ans2 = new ArrayList<>(Arrays.asList(0,1,3));
        List<Integer> actual = graph.getFloydWarshallPath(0,3,parents);
        assertEquals(5, costs[0][3], "Costs array does not match expected values");
        assertTrue(ans1.equals(actual) || ans2.equals(actual));
    }
    @Test
    public void oneNode() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\oneNode.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


       
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList());
        List<Integer> path = graph.getFloydWarshallPath(0,0,parents);
        assertEquals(0, costs[0][0], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
  
   
    @Test
    public void GiganticPathOneHighDensity() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\GiganticPathOneHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs= new int[graph.Size()][graph.Size()];


       
        graph.FloydWarshall( parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(0,999));
        List<Integer> path = graph.getFloydWarshallPath(0,999,parents);
        assertEquals(1, costs[0][999], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
   }
   @Test
public void testDisconnectedGraph() throws IOException {
    String filePath = "ShortestPathAlgorithms'\\resources\\disconnectedGraph.txt"; 
    Graph graph = new Graph(filePath);

    int[][] parents = new int[graph.Size()][graph.Size()];
    int[][] costs = new int[graph.Size()][graph.Size()];

    graph.FloydWarshall(parents, costs);

    List<Integer> path = graph.getFloydWarshallPath(0, 3, parents);
    assertEquals(Integer.MAX_VALUE, costs[0][3], "Node should be unreachable");
    assertTrue(path.isEmpty(), "Path should be empty for unreachable node");
}

@Test
public void testZeroEdgeWeights() throws IOException {
    String filePath = "ShortestPathAlgorithms'\\resources\\zeroEdgeWeights.txt"; 
    Graph graph = new Graph(filePath);

    int[][] parents = new int[graph.Size()][graph.Size()];
    int[][] costs = new int[graph.Size()][graph.Size()];

    graph.FloydWarshall(parents, costs);

    List<Integer> expectedPath = Arrays.asList(0, 1, 2);
    List<Integer> actualPath = graph.getFloydWarshallPath(0, 2, parents);
    assertEquals(0, costs[0][2], "Total cost should be 0 due to zero-weight edges");
    assertEquals(expectedPath, actualPath);
}

@Test
public void testMultipleSameCostPathsDeterministic() throws IOException {
    String filePath = "ShortestPathAlgorithms'\\resources\\sameCostPaths.txt"; 
    Graph graph = new Graph(filePath);

    int[][] parents = new int[graph.Size()][graph.Size()];
    int[][] costs = new int[graph.Size()][graph.Size()];

    graph.FloydWarshall(parents, costs);

    List<Integer> actualPath = graph.getFloydWarshallPath(0, 3, parents);
    assertEquals(5, costs[0][3], "Cost to destination should be 5");

    // One of these should be correct depending on implementation
    List<Integer> expected1 = Arrays.asList(0, 1, 3);
    List<Integer> expected2 = Arrays.asList(0, 2, 3);
    assertTrue(actualPath.equals(expected1) || actualPath.equals(expected2));
}

@Test
public void testAllNodesReachable() throws IOException {
    String filePath = "ShortestPathAlgorithms'\\resources\\allReachable.txt"; 
    Graph graph = new Graph(filePath);

    int[][] parents = new int[graph.Size()][graph.Size()];
    int[][] costs = new int[graph.Size()][graph.Size()];

    graph.FloydWarshall(parents, costs);

    for (int i = 1; i < graph.Size(); i++) {
        assertTrue(costs[0][i] < Integer.MAX_VALUE, "Node " + i + " should be reachable");
        List<Integer> path = graph.getFloydWarshallPath(0, i, parents);
        assertFalse(path.isEmpty(), "Path to node " + i + " should not be empty");
    }
}

@Test
public void additionalTest() throws IOException {
    String filePath = "ShortestPathAlgorithms'\\resources\\test6.txt"; 
    Graph graph = new Graph(filePath);

    int[][] parents = new int[graph.Size()][graph.Size()];
    int[][] costs = new int[graph.Size()][graph.Size()];

    graph.FloydWarshall(parents, costs);

    List<Integer> expectedPath = Arrays.asList(0, 2, 6);
    List<Integer> actualPath = graph.getFloydWarshallPath(0, 6, parents);

    assertEquals(5, costs[0][6], "Costs array does not match expected values");
    assertEquals(expectedPath, actualPath, "Parents array does not match expected values");
}

@Test
public void additionalTest7() throws IOException {
    String filePath = "ShortestPathAlgorithms'\\resources\\test7.txt"; 
    Graph graph = new Graph(filePath);

    int[][] parents = new int[graph.Size()][graph.Size()];
    int[][] costs = new int[graph.Size()][graph.Size()];

    graph.FloydWarshall(parents, costs);

    List<Integer> expectedPath = Arrays.asList(0, 2, 4, 5);
    List<Integer> actualPath = graph.getFloydWarshallPath(0, 5, parents);

    assertEquals(6, costs[0][5], "Costs array does not match expected values");
    assertEquals(expectedPath, actualPath, "Parents array does not match expected values");
}

}