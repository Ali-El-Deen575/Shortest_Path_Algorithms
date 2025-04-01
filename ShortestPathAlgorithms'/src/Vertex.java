package src;

import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private String name;
    private Vertex precedence; 
    private Integer distance = Integer.MAX_VALUE;
    Map<Vertex, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Vertex destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getPrecedence() {
        return this.precedence;
    }

    public void setPrecedence(Vertex precedence) {
        this.precedence = precedence;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Vertex, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public void setAdjacentNodes(Map<Vertex, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}

