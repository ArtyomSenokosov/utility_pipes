package main.java.farm;

import main.java.farm.algorithms.Dijkstra;
import main.java.farm.component.Graph;
import main.java.farm.algorithms.Prim;
import main.java.farm.reader.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Graph graph = new Reader().readGraphFaster();

        new Dijkstra(graph).run();

        graph.stripGraph();
        Prim prim = new Prim(graph);

        int sum = 0;
        for (Integer hub : graph.hubs) {
            sum += prim.run(hub);
        }
        System.out.println("result: " + sum + " " + graph.undecidedNodes.size());
    }
}