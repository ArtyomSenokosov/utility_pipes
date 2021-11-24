package main.java.farm.algorithms;

import main.java.farm.component.Graph;
import main.java.farm.component.Node;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    private final Graph graph;
    private int costSum = 0;
    private final Set<Integer> visited = new HashSet<>();

    public Prim(Graph graph) {
        this.graph = graph;
    }

    private void prepare(){
        this.costSum = 0;
    }

    public int run(Integer source) {
        this.prepare();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(graph.nodesList.get(source));

        while (!pq.isEmpty()) {
            Node u = pq.poll();

            if (!visited.contains(u.flag)) {
                costSum += u.distance;
                visited.add(u.flag);
                for (Node n : graph.strippedGraph.get(u.flag)) {
                    if(!visited.contains(n.flag))
                        pq.offer(n);
                }
            }
        }
        return costSum;
    }
}