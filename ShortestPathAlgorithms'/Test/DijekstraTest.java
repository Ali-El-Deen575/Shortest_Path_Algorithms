package Test;
import src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class DijekstraTest {

    @Test
    public void testDijekstra() throws IOException {
    
        String filePath = "resources\\sample_graph.txt"; 
        Graph graph = new Graph(filePath);

      
        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];


        Vertex source = graph.getVertices().get(0);
        graph.Dijekstra(source, parents, costs);

       
        int[] expectedCosts = {0, 4, 6, 7};
        int[] expectedParents = {-1, 0, 1, 2}; 

    
        assertArrayEquals(expectedCosts, costs, "Costs array does not match expected values");
        assertArrayEquals(expectedParents, parents, "Parents array does not match expected values");
    }
}