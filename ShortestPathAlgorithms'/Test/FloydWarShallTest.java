package Test;

import src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class FloydWarShallTest {
    final int INF = 99999;
    @Test
    public void testFloydWarshall_NoNegativeCycle() throws IOException {
        String filePath = "resources\\sample_graph.txt";
        Graph graph = new Graph(filePath);

        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs = new int[graph.Size()][graph.Size()];

        boolean hasNoNegativeCycle = graph.FloydWarshall(parents, costs);

        int[][] expectedCosts = {
            {0, 4, 6, 7},
            {INF, 0, 2, 3},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };
        int[][] expectedParents = {
            {-1, 0, 1, 2},
            {-1, -1, 1, 2},
            {-1, -1, -1, 2},
            {-1, -1, -1, -1}
        };

        assertTrue(hasNoNegativeCycle, "The graph should not have a negative cycle.");

        assertArrayEquals(expectedCosts, costs, "Costs matrix does not match expected values.");
        assertArrayEquals(expectedParents, parents, "Parents matrix does not match expected values.");
    }

    @Test
    public void testFloydWarshall_NegativeCycle() throws IOException {
        String filePath = "resources\\negative_cycle_graph.txt"; 
        Graph graph = new Graph(filePath);

        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs = new int[graph.Size()][graph.Size()];

        boolean hasNoNegativeCycle = graph.FloydWarshall(parents, costs);

        assertFalse(hasNoNegativeCycle, "The graph should have a negative cycle.");
    }
}