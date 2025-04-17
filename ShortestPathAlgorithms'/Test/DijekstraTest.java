package Test;
import src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijekstraTest {
  
    @Test
    public void simpleTest() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\simpleTest.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(0, 2, 4));
        List<Integer> path = graph.getPath(0,4,parents);
        assertEquals(6, costs[4], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void mediumTestHighDensity() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\mediumTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(1);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(1, 4, 11, 10));
        List<Integer> path = graph.getPath(1,10,parents);
        assertEquals(39, costs[10], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void noPathMediumTestHighDensity() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\mediumTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(9);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList());
        List<Integer> path = graph.getPath(9,0,parents);
        assertEquals(Integer.MAX_VALUE, costs[0], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void BigTestHighDensity1() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\BigTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for(int i=1;i<50;i+=2){
            ans.add(i);
        }
        List<Integer> path = graph.getPath(0,49,parents);
        assertEquals(674, costs[49], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void BigTestHighDensity2() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\BigTestHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<50;i+=2){
            ans.add(i);
        }
        List<Integer> path = graph.getPath(0,48,parents);
        assertEquals(648, costs[48], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    @Test
    public void testEqualShortestPathsWithNegativeValues() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\equalShortestPathsNegative.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans1 = new ArrayList<>(Arrays.asList(0,1,4));
        List<Integer> ans2 = new ArrayList<>(Arrays.asList(0,2,3,4));
        List<Integer> actual = graph.getPath(0,4,parents);
        assertEquals(-5, costs[4], "Costs array does not match expected values");
        assertTrue(ans1.equals(actual) || ans2.equals(actual));    }
    @Test
    public void testEqualShortestPathsWithPositiveValues() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\equalShortestPathsPositive.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans1 = new ArrayList<>(Arrays.asList(0,2,3));
        List<Integer> ans2 = new ArrayList<>(Arrays.asList(0,1,3));
        List<Integer> actual = graph.getPath(0,3,parents);
        assertEquals(5, costs[3], "Costs array does not match expected values");
        assertTrue(ans1.equals(actual) || ans2.equals(actual));
    }
    @Test
    public void testNegativeCycle() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\negativeCycle.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(0,2,3,5));
        List<Integer> path = graph.getPath(0,5,parents);
        assertEquals(3, costs[5], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    // @Test
    // public void testNegativeHardVersion() throws IOException {
    
    //     String filePath = "ShortestPathAlgorithms'\\resources\\negativeHardVersion.txt"; 
    //     Graph graph = new Graph(filePath);

      
    //     int[] parents = new int[graph.Size()];
    //     int[] costs = new int[graph.Size()];


    //     Vertex source = graph.getVertices().get(0);
    //     graph.Dijekstra(source, parents, costs);
        
    //     List<Integer> ans = new ArrayList<>(Arrays.asList(0,2,3,1,4,5));
    //     List<Integer> path = graph.getPath(0,5,parents);
    //     assertEquals(3, costs[5], "Costs array does not match expected values");
    //     assertEquals(ans, path, "Parents array does not match expected values");
    // }
    @Test
    public void oneNode() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\oneNode.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(0));
        List<Integer> path = graph.getPath(0,0,parents);
        assertEquals(0, costs[0], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
    // @Test
    // public void multipleEdges() throws IOException {
    
    //     String filePath = "ShortestPathAlgorithms'\\resources\\multipleEdges.txt"; 
    //     Graph graph = new Graph(filePath);

      
    //     int[] parents = new int[graph.Size()];
    //     int[] costs = new int[graph.Size()];


    //     Vertex source = graph.getVertices().get(0);
    //     graph.Dijekstra(source, parents, costs);
        
    //     List<Integer> ans = new ArrayList<>(Arrays.asList(0,1));
    //     List<Integer> path = graph.getPath(0,1,parents);
    //     assertEquals(1, costs[1], "Costs array does not match expected values");
    //     assertEquals(ans, path, "Parents array does not match expected values");
    // }
    @Test
    public void GiganticPathOneHighDensity() throws IOException {
    
        String filePath = "ShortestPathAlgorithms'\\resources\\GiganticPathOneHighDensity.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);
        
        List<Integer> ans = new ArrayList<>(Arrays.asList(0,999));
        List<Integer> path = graph.getPath(0,999,parents);
        assertEquals(1, costs[999], "Costs array does not match expected values");
        assertEquals(ans, path, "Parents array does not match expected values");
    }
}