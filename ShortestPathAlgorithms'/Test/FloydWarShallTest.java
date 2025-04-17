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
}