package src;

import java.io.IOException;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Enter the path of the graph file: ");
            String filePath = scanner.nextLine();
            Graph graph = new Graph(filePath);

            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Find shortest paths from a source node");
                System.out.println("2. Find shortest paths between all pairs of nodes");
                System.out.println("3. Check for negative cycles");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        handleSingleSourceShortestPath(graph);
                        break;
                    case 2:
                        handleAllPairsShortestPath(graph);
                        break;
                    case 3:
                        handleNegativeCycleCheck(graph);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the graph file: " + e.getMessage());
        }
    }

    private static void handleSingleSourceShortestPath(Graph graph) {
        System.out.print("Enter the source node index: ");
        int sourceIndex = getValidNodeIndex(graph);

        Vertex source = graph.getVertices().get(sourceIndex);

        System.out.println("Choose an algorithm:");
        System.out.println("1. Dijkstra");
        System.out.println("2. Bellman-Ford");
        System.out.println("3. Floyd-Warshall");
        System.out.print("Enter your choice: ");
        int algorithmChoice = scanner.nextInt();

        int[] parents = new int[graph.Size()];
        int[] costs = new int[graph.Size()];

        boolean success = true;
        switch (algorithmChoice) {
            case 1:
                graph.Dijekstra(source, parents, costs);
                break;
            case 2:
                success = graph.BellmanFord(source, parents, costs);
                break;
            case 3:
                int[][] fwParents = new int[graph.Size()][graph.Size()];
                int[][] fwCosts = new int[graph.Size()][graph.Size()];
                success = graph.FloydWarshall(fwParents, fwCosts);
                for (int i = 0; i < graph.Size(); i++) {
                    parents[i] = fwParents[sourceIndex][i];
                    costs[i] = fwCosts[sourceIndex][i];
                }
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (!success) {
            System.out.println("The graph contains a negative cycle. Cannot compute shortest paths.");
            return;
        }

        while (true) {
            System.out.println("\nSingle Source Shortest Path Menu:");
            System.out.println("1. Get cost to a specific node");
            System.out.println("2. Get path to a specific node");
            System.out.println("3. Exit to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 3) break;

            System.out.print("Enter the destination node index: ");
            int destinationIndex = getValidNodeIndex(graph);

            switch (choice) {
                case 1:
                    System.out.println("Cost to node " + destinationIndex + ": " + costs[destinationIndex]);
                    break;
                case 2:
                    printPath(parents, sourceIndex, destinationIndex);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleAllPairsShortestPath(Graph graph) {
        System.out.println("Choose an algorithm:");
        System.out.println("1. Dijkstra");
        System.out.println("2. Bellman-Ford");
        System.out.println("3. Floyd-Warshall");
        System.out.print("Enter your choice: ");
        int algorithmChoice = scanner.nextInt();

        int[][] parents = new int[graph.Size()][graph.Size()];
        int[][] costs = new int[graph.Size()][graph.Size()];

        boolean success = true;
        switch (algorithmChoice) {
            case 3:
                success = graph.FloydWarshall(parents, costs);
                break;
            case 2:
                for (int i = 0; i < graph.Size(); i++) {
                    int[] singleParents = new int[graph.Size()];
                    int[] singleCosts = new int[graph.Size()];
                    success = graph.BellmanFord(graph.getVertices().get(i), singleParents, singleCosts);
                    if (!success) break;
                    for (int j = 0; j < graph.Size(); j++) {
                        parents[i][j] = singleParents[j];
                        costs[i][j] = singleCosts[j];
                    }
                }
                break;
            case 1:
                for (int i = 0; i < graph.Size(); i++) {
                    int[] singleParents = new int[graph.Size()];
                    int[] singleCosts = new int[graph.Size()];
                    graph.Dijekstra(graph.getVertices().get(i), singleParents, singleCosts);
                    for (int j = 0; j < graph.Size(); j++) {
                        parents[i][j] = singleParents[j];
                        costs[i][j] = singleCosts[j];
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (!success) {
            System.out.println("The graph contains a negative cycle. Cannot compute shortest paths.");
            return;
        }

        while (true) {
            System.out.println("\nAll Pairs Shortest Path Menu:");
            System.out.println("1. Get cost between two nodes");
            System.out.println("2. Get path between two nodes");
            System.out.println("3. Exit to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 3) break;

            System.out.print("Enter the source node index: ");
            int sourceIndex = getValidNodeIndex(graph);
            System.out.print("Enter the destination node index: ");
            int destinationIndex = getValidNodeIndex(graph);

            switch (choice) {
                case 1:
                    System.out.println("Cost from node " + sourceIndex + " to node " + destinationIndex + ": " + costs[sourceIndex][destinationIndex]);
                    break;
                case 2:
                    printPath(parents[sourceIndex], sourceIndex, destinationIndex);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleNegativeCycleCheck(Graph graph) {
        System.out.println("Choose an algorithm:");
        System.out.println("1. Bellman-Ford");
        System.out.println("2. Floyd-Warshall");
        System.out.print("Enter your choice: ");
        int algorithmChoice = scanner.nextInt();

        boolean success = true;
        switch (algorithmChoice) {
            case 1:
                int[] parents = new int[graph.Size()];
                int[] costs = new int[graph.Size()];
                success = graph.BellmanFord(graph.getVertices().get(0), parents, costs);
                break;
            case 2:
                int[][] allParents = new int[graph.Size()][graph.Size()];
                int[][] allCosts = new int[graph.Size()][graph.Size()];
                success = graph.FloydWarshall(allParents, allCosts);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (success) {
            System.out.println("The graph does not contain a negative cycle.");
        } else {
            System.out.println("The graph contains a negative cycle.");
        }
    }

    private static void printPath(int[] parents, int source, int destination) {
        if (destination == -1 || parents[destination] == -1) {
            System.out.println("No path exists.");
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int at = destination; at != -1; at = parents[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("Path: " + path);
    }

    private static int getValidNodeIndex(Graph graph) {
        int index;
        while (true) {
            index = scanner.nextInt();
            if (index >= 0 && index < graph.Size()) {
                break;
            } else {
                System.out.println("Invalid node index. Please enter a value between 0 and " + (graph.Size() - 1) + ": ");
            }
        }
        return index;
    }
}