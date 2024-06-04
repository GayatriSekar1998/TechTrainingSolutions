package com.java.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GraphNodeI {
    int value;
    List<GraphNodeI> neighbors;

    public GraphNodeI(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(GraphNodeI neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return "Node " + value;
    }
}

class GraphI {
    private Map<GraphNodeI, List<GraphNodeI>> adjacencyList;

    public GraphI() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(GraphNodeI node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(GraphNodeI node1, GraphNodeI node2) {
        if (!adjacencyList.containsKey(node1)) {
            addNode(node1);
        }
        if (!adjacencyList.containsKey(node2)) {
            addNode(node2);
        }
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1); // For undirected graph
    }

    public List<GraphNodeI> getNeighbors(GraphNodeI node) {
        return adjacencyList.get(node);
    }

    public void printGraph() {
        for (GraphNodeI node : adjacencyList.keySet()) {
            System.out.print(node + " is connected to: ");
            for (GraphNodeI neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
public class ListRepresentation {
    public static void main(String[] args) {
        GraphI graph = new GraphI();
        GraphNodeI node1 = new GraphNodeI(1);
        GraphNodeI node2 = new GraphNodeI(2);
        GraphNodeI node3 = new GraphNodeI(3);
        GraphNodeI node4 = new GraphNodeI(4);

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node4);
        graph.addEdge(node3, node4);

        graph.printGraph();
    }
}