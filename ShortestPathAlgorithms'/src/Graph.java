package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private List<Vertex> vertices = new ArrayList<>(); 

    public Graph(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] firstLine = br.readLine().split(" ");
            int V = Integer.parseInt(firstLine[0]); 
            int E = Integer.parseInt(firstLine[1]); 

            for (int i = 0; i < V; i++) {
                Vertex vertex = new Vertex(String.valueOf(i)); 
                vertices.add(vertex);
            }

            for (int e = 0; e < E; e++) {
                String[] edgeLine = br.readLine().split(" ");
                int i = Integer.parseInt(edgeLine[0]); 
                int j = Integer.parseInt(edgeLine[1]); 
                int w = Integer.parseInt(edgeLine[2]); 

                Vertex source = vertices.get(i);
                Vertex destination = vertices.get(j);

                source.addDestination(destination, w);
            }
        }
    }

    public int Size() {
        return vertices.size(); 
    }

    public void Dijekstra(Vertex source, int[] parents, int[] costs) {
        Arrays.fill(costs, Integer.MAX_VALUE); 
        Arrays.fill(parents, -1); 
        costs[getVertexIndex(source)] = 0; 

        Set<Vertex> settledNodes = new HashSet<>();
        Set<Vertex> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex currentNode = getLowestDistanceNode(unsettledNodes, costs);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Vertex, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Vertex adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    int newCost = costs[getVertexIndex(currentNode)] + edgeWeight;
                    if (newCost < costs[getVertexIndex(adjacentNode)]) {
                        costs[getVertexIndex(adjacentNode)] = newCost;
                        parents[getVertexIndex(adjacentNode)] = getVertexIndex(currentNode);
                        unsettledNodes.add(adjacentNode);
                    }
                }
            }
            settledNodes.add(currentNode);
        }
    }

    public boolean BellmanFord(Vertex source, int[] parents, int[] costs) {
        Arrays.fill(costs, Integer.MAX_VALUE); 
        Arrays.fill(parents, -1); 
        costs[getVertexIndex(source)] = 0; 

        int V = vertices.size();

        for (int i = 0; i < V - 1; i++) {
            for (Vertex u : vertices) {
                for (Map.Entry<Vertex, Integer> adjacencyPair : u.getAdjacentNodes().entrySet()) {
                    Vertex v = adjacencyPair.getKey();
                    int weight = adjacencyPair.getValue();

                    if (costs[getVertexIndex(u)] != Integer.MAX_VALUE && 
                        costs[getVertexIndex(u)] + weight < costs[getVertexIndex(v)]) {
                        costs[getVertexIndex(v)] = costs[getVertexIndex(u)] + weight;
                        parents[getVertexIndex(v)] = getVertexIndex(u);
                    }
                }
            }
        }

        for (Vertex u : vertices) {
            for (Map.Entry<Vertex, Integer> adjacencyPair : u.getAdjacentNodes().entrySet()) {
                Vertex v = adjacencyPair.getKey();
                int weight = adjacencyPair.getValue();

                if (costs[getVertexIndex(u)] != Integer.MAX_VALUE && 
                    costs[getVertexIndex(u)] + weight < costs[getVertexIndex(v)]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean FloydWarshall(int[][] parents, int[][] costs) {
        int V = vertices.size();
        int[][] dist = new int[V][V]; 
        int[][] pred = new int[V][V]; 

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    pred[i][j] = -1;
                } else {
                    dist[i][j] = Integer.MAX_VALUE; 
                    pred[i][j] = -1; 
                }
            }
        }

        for (Vertex u : vertices) {
            for (Map.Entry<Vertex, Integer> adjacencyPair : u.getAdjacentNodes().entrySet()) {
                Vertex v = adjacencyPair.getKey();
                int weight = adjacencyPair.getValue();
                dist[getVertexIndex(u)][getVertexIndex(v)] = weight;
                pred[getVertexIndex(u)][getVertexIndex(v)] = getVertexIndex(u);
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                return false;
            }
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    costs[i][j] = Integer.MAX_VALUE;
                } else {
                    costs[i][j] = dist[i][j];
                }
                parents[i][j] = pred[i][j];
            }
        }

        return true; 
    }

    private int getVertexIndex(Vertex vertex) {
        return Integer.parseInt(vertex.getName());
    }

    private Vertex getLowestDistanceNode(Set<Vertex> unsettledNodes, int[] costs) {
        Vertex lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Vertex node : unsettledNodes) {
            int nodeDistance = costs[getVertexIndex(node)];
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Integer> getPath(int source, int destination, int[] parents) {
        List<Integer> path = new ArrayList<>();
        int current = destination;

        while (current != -1) {
            path.add(0, current); 
            if (current == source) {
                break; 
            }
            current = parents[current]; 
        }

        if (path.get(0) != source) {
            return Collections.emptyList(); 
        }

        return path;
    }

    public List<Integer> getFloydWarshallPath(int source, int destination, int[][] parents) {
        List<Integer> path = new ArrayList<>();
        if (parents[source][destination] == -1) {
            return path; 
        }

        int current = destination;
        while (current != source) {
            path.add(0, current);
            current = parents[source][current]; 
        }
        path.add(0, source); 

        return path;
    }
}
