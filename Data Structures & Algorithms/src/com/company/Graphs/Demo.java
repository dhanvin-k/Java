package com.company.Graphs;

public class Demo {
    public static void show() {
        var graph = new Graphs();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");


        graph.print();
        System.out.println("Done");
    }
}
