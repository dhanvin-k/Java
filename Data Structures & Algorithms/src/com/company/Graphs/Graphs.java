package com.company.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graphs {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        public String getLabel() { return label; }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<String, Node>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<Node, List<Node>>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new LinkedList<Node>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalStateException();


        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (var source: adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            System.out.println(source + " is connected to nodes " + targets);
        }
    }
}
