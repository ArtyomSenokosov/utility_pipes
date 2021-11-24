package main.java.farm.component;

import java.util.*;

public class Graph {

    public int numberFarms;
    public int numberRoads;
    public int numberHubs;

    public Map<Integer, List<Node>> graph;
    public List<Integer> hubs;
    public List<Integer> undecidedNodes = new ArrayList<>();
    public Map<Integer, List<Node>> strippedGraph = new HashMap<>();
    public List<Node> nodesList = new ArrayList<>();

    public Graph(int numberFarms, int numberRoads, int numberHubs, List<Integer> hubs, Map<Integer, List<Node>> graph) {
        this.numberFarms = numberFarms;
        this.numberRoads = numberRoads;
        this.numberHubs = numberHubs;
        this.graph = graph;
        this.hubs = hubs;
    }

    public void stripGraph() {
        for (Node nodeElement : nodesList) {
            if (nodeElement.isUndecided) {
                strippedGraph.put(nodeElement.flag, new ArrayList<>());
            } else {
                List<Node> adjacentNodes = new ArrayList<>();

                for (Node neighbour : graph.get(nodeElement.flag)) {
                    if (nodesList.get(neighbour.flag).isUndecided)
                        continue;
                    if (nodeElement.hub == nodesList.get(neighbour.flag).hub)
                        adjacentNodes.add(neighbour);
                }
                strippedGraph.put(nodeElement.flag, adjacentNodes);
            }
        }
    }
}