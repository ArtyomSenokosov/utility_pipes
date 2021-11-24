package main.java.farm.algorithms;

import main.java.farm.component.Graph;
import main.java.farm.component.Node;

import java.util.PriorityQueue;

public class Dijkstra {

    private final Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public void run() {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < graph.numberFarms; i++)
            graph.nodesList.add(i, new Node(i, Integer.MAX_VALUE));

        for (Integer hub : graph.hubs) {
            Node currentHub = graph.nodesList.get(hub);
            currentHub.distance = 0;
            currentHub.hub = currentHub;
            currentHub.parent = currentHub;
            priorityQueue.offer(currentHub);
        }

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            for (Node graphElement : graph.graph.get(node.flag)) {
                int newDistance = node.distance + graphElement.distance;
                if (newDistance < graph.nodesList.get(graphElement.flag).distance) {
                    graph.nodesList.get(graphElement.flag).distance = newDistance;
                    graph.nodesList.get(graphElement.flag).parent = node;
                    graph.nodesList.get(graphElement.flag).hub = graph.nodesList.get(node.hub.flag);
                    graph.nodesList.get(graphElement.flag).isUndecided = false;
                    priorityQueue.offer(graph.nodesList.get(graphElement.flag));
                } else if (newDistance == graph.nodesList.get(graphElement.flag).distance && (!graph.nodesList.get(graphElement.flag).hub.equals(node.hub))) {
                    graphElement.isUndecided = true;
                    graph.nodesList.get(graphElement.flag).isUndecided = true;
                    priorityQueue.offer(new Node(graphElement.flag, newDistance, graph.nodesList.get(node.hub.flag), node));
                }
            }
        }
        for (Node nodeElement : graph.nodesList) {
            if (nodeElement.isUndecided) {
                graph.undecidedNodes.add(nodeElement.flag);
            }
        }
    }
}