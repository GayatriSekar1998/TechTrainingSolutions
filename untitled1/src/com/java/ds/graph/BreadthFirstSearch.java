package com.java.ds.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class GraphNode {
    int value;
    List<GraphNode> neighbors;

    public GraphNode(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return "Node " + value;
    }
}

class GraphBF {
    private Map<GraphNode, List<GraphNode>> adjacencyList;

    public GraphBF() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(GraphNode node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(GraphNode node1, GraphNode node2) {
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1); // For undirected graph
    }

    public List<GraphNode> getNeighbors(GraphNode node) {
        return adjacencyList.get(node);
    }

    public void bfs(GraphNode startNode) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            System.out.print(currentNode.value + " ");

            for (GraphNode neighbor : adjacencyList.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void printGraph() {
        for (GraphNode node : adjacencyList.keySet()) {
            System.out.print(node + " is connected to: ");
            for (GraphNode neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
public class BreadthFirstSearch {
    public static void main(String[] args) {
        GraphBF graph = new GraphBF();

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node4);
        graph.addEdge(node3, node4);

        System.out.println("BFS traversal starting from node 1:");
        graph.bfs(node1);
    }
}