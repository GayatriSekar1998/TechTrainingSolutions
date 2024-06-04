package com.java.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class GraphNodeDF {
    int value;
    List<GraphNodeDF> neighbors;

    public GraphNodeDF(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(GraphNodeDF neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return "Node " + value;
    }
}

class Graph {
    private Map<GraphNodeDF, List<GraphNodeDF>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(GraphNodeDF node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(GraphNodeDF node1, GraphNodeDF node2) {
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1); // For undirected graph
    }

    public List<GraphNodeDF> getNeighbors(GraphNodeDF node) {
        return adjacencyList.get(node);
    }

    public void dfs(GraphNodeDF startNode) {
        Set<GraphNodeDF> visited = new HashSet<>();
        Stack<GraphNodeDF> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            GraphNodeDF currentNode = stack.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                System.out.print(currentNode.value + " ");

                for (GraphNodeDF neighbor : adjacencyList.get(currentNode)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void printGraph() {
        for (GraphNodeDF node : adjacencyList.keySet()) {
            System.out.print(node + " is connected to: ");
            for (GraphNodeDF neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph();

        GraphNodeDF node1 = new GraphNodeDF(1);
        GraphNodeDF node2 = new GraphNodeDF(2);
        GraphNodeDF node3 = new GraphNodeDF(3);
        GraphNodeDF node4 = new GraphNodeDF(4);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node4);
        graph.addEdge(node3, node4);

        System.out.println("DFS traversal starting from node 1:");
        graph.dfs(node1);
    }
}